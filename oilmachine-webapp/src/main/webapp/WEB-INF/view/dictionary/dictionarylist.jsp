<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
.table tr  {
	cursor:pointer;
}
</style>
<script>
	var dictionary_id = '';
	var is_cache = '';
	var dictionary_table;
	$(document).ready(function() {
		dictionary_table = $('#dictionary_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/dictionary/dictionaryList.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			columns : [ {
				"data" : "dictionaryid"
			}, {
				"data" : "dicCode"
			}, {
				"data" : "dicName"
			}, {
				"data" : "iscache"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"dictionary_checkbox\" value=\""+row.dictionaryid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					if(data == 0){
						return "不缓存";
					}
					if(data == 1){
						return "缓存";
					}
				},
				"targets" : 3,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					return optionBtn("'"+row.dictionaryid+"'", "main_edit", "del");
				},
				"targets" : 4,
				"center" : "center"
			} ],
			"oLanguage" : {
				"sLengthMenu" : "每页显示 _MENU_ 条记录",
				"sZeroRecords" : "抱歉， 没有找到",
				"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				"sInfoEmpty" : "没有数据",
				"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "前一页",
					"sNext" : "后一页",
					"sLast" : "尾页"
				},
				"sZeroRecords" : "没有检索到数据",
				"sProcessing" : "<img src='./loading.gif' />"
			}
		});
		$('#dictionary_table').on( 'click','tbody tr', function () {
			$("input[name=dictionary_checkbox]").prop("checked", false);
			$(this).children().eq(0).children().children().prop("checked", true);
			dictionary_id = $(this).children().eq(0).children().children().val();
			is_cache = $(this).children().eq(3).text();
			$("#search_dictionaryid").val(dictionary_id);
			dictdata_query();
		});
	});
	function query() {
		dictionary_table.ajax.reload();
	}
	function del(id) {
		confirmDialog("确定删除已选择信息？",function(){
			formDelte(id?id:null, dictionary_table, "dictionary/delete.do", "dictionary_checkbox");
		});
	}
	//删除
	function main_del(ids) {
		var ids = [];
		$("input[name='dictionary_checkbox']").each(function() {
			if (this.checked == true) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0){
			layer.msg("请选择删除项！");
			return false;
		}else{
			confirmDialog("确定删除已选择信息？",function(){
				formDelte(ids?ids:null, dictionary_table, "dictionary/delete.do", "dictionary_checkbox");
			});
		}
	}
	function add() {
		openDialog({
			type : 1,
			title : "字典添加",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "dictionary/addPage.do",
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_dictionaryform();
				if(boo){
					formOpt($('#dictionaryform'), "dictionary/add.do", dictionary_table, index, null);
				}
			}
		});
	}
	function main_edit(id) {
		openDialog({
			type : 1,
			title : "字典修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "dictionary/editPage.do?dictionaryid="+id,
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_dictionaryform();
				if(boo){
					formOpt($('#dictionaryform'), "dictionary/edit.do", dictionary_table, index, null);
				}
			}
		});
	}
	$("#dictionary_checkbox").click(function() {
		$("input[name=dictionary_checkbox]").prop("checked", $(this).prop("checked"));
	});
	function validate_dictionaryform(){
		if($("#dicCode").val().trim() == ""){
			layer.msg("字典编码不能为空！");
			return false;
		}
		if($("#dicName").val().trim() == ""){
			layer.msg("字典名不能为空！");
			return false;
		}
		if($("#iscache").val().trim() == ""){
			layer.msg("是否缓存不能为空！");
			return false;
		}
		return true;
	}
</script>
<div class="row">
	<div class="col-xs-12">
		<div class="pull-left tableTools-container">
			<p>
				<span style="color: blue;font-size: 20px;">字典信息</span>
				<button class="btn btn-white btn-info btn-bold" onclick="add()" style="margin-left:10px">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 添加
				</button>

				<button class="btn btn-white btn-warning btn-bold" onclick="main_del()" style="margin-left:10px">
					<i class="ace-icon fa fa-trash-o bigger-120 orange"></i> 批量删除
				</button>
			</p>
		</div>

		<!-- div.table-responsive -->

		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="dictionary_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="dictionary_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">字典编码</th>
						<th class="center" width="10%">字典名</th>
						<th class="center" width="10%">是否缓存</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<hr />
<jsp:include page="dictionarydatalist.jsp"></jsp:include>
<div class="row" id="dialogPage" style="display:none" >
</div>