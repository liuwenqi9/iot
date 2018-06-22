<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var dictionarydata_table;
	$(document).ready(function() {
		dictionarydata_table = $('#dictionarydata_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/dictionarydata/dictionarydataList.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
				pushCondition_dicdata(aoData);
			},
			columns : [ {
				"data" : "dictionarydataid"
			}, {
				"data" : "itemCode"
			}, {
				"data" : "itemValue"
			}, {
				"data" : "itemName"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"dictionarydata_checkbox\" value=\""+row.dictionarydataid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					return optionBtn("'"+row.dictionarydataid+"'", "dictdata_edit", "dictdata_del_one");
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
	});
	function pushCondition_dicdata(params) {
		var t = $("#dicdataSearch").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
	function dictdata_query() {
		dictionarydata_table.ajax.reload();
	}
	function dictdata_del_one(id) {
		confirmDialog("确定删除已选择信息？",function(){
			formDelte(id?id:null, dictionarydata_table, "dictionarydata/delete.do", "dictionarydata_checkbox");
		});
	}
	//删除
	function dictdata_del(ids) {
		var ids = [];
		$("input[name='dictionarydata_checkbox']").each(function() {
			if (this.checked == true) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0){
			layer.msg("请选择删除项！");
			return false;
		}else{
			confirmDialog("确定删除已选择信息？",function(){
				formDelte(ids?ids:null, dictionarydata_table, "dictionarydata/delete.do", "dictionarydata_checkbox");
			});
		}
	}
	function dictdata_add() {
		var ids = [];
		$("input[name='dictionary_checkbox']").each(function() {
			if (this.checked == true) {
				ids.push($(this).val());
			}
		});
		if(ids.length != 1){
			layer.msg("请选择一条字典信息！");
			return false;
		}else{
			dictionary_id = ids[0];
			openDialog({
				type : 1,
				title : "字典明细添加",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '650px', '400px' ],
				scrollbar : false,
				content : "dictionarydata/addPage.do",
				viewid : "dialogPage",
				btn : [ '确定', '取消' ],
				yes : function(index) {
					var boo = validate_dictionarydataform();
					if(boo){
						formOpt($('#dictionarydataform'), "dictionarydata/add.do", dictionarydata_table, index, null);
					}
				}
			});
		}
	}
	function dictdata_edit(id) {
		openDialog({
			type : 1,
			title : "字典明细修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "dictionarydata/editPage.do?dictionarydataid="+id,
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_dictionarydataform();
				if(boo){
					formOpt($('#dictionarydataform'), "dictionarydata/edit.do", dictionarydata_table, index, null);
				}
			}
		});
	}
	$("#dictionarydata_checkbox").click(function() {
		$("input[name=dictionarydata_checkbox]").prop("checked", $(this).prop("checked"));
	});
	function validate_dictionarydataform(){
		if($("#itemCode").val().trim() == ""){
			layer.msg("项目编码不能为空！");
			return false;
		}
		if($("#itemValue").val().trim() == ""){
			layer.msg("项目值不能为空！");
			return false;
		}
		return true;
	}
</script>
<div class="row">
	<div class="col-xs-12">
		<form id="dicdataSearch" style="display: none;">
			<input hidden="hidden" id="search_dictionaryid" name="dictId">
		</form>
		<div class="pull-left tableTools-container">
			<p>
				<span style="color: blue;font-size: 20px;">字典明细信息</span>
				<button class="btn btn-white btn-info btn-bold" onclick="dictdata_add()" style="margin-left:10px">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 添加
				</button>

				<button class="btn btn-white btn-warning btn-bold" onclick="dictdata_del()" style="margin-left:10px">
					<i class="ace-icon fa fa-trash-o bigger-120 orange"></i> 批量删除
				</button>
			</p>
		</div>

		<!-- div.table-responsive -->

		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="dictionarydata_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="dictionarydata_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">项目编码</th>
						<th class="center" width="10%">项目值</th>
						<th class="center" width="10%">描述</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
