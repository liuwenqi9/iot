<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var usertags_table;
	$(document).ready(function() {
		usertags_table = $('#usertags_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/usertags/usertagsList.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			columns : [ {
				"data" : "usertagsid"
			}, {
				"data" : "usertagsname"
			}, {
				"data" : "usertag"
			}, {
				"data" : "tagvalue"
			}, {
				"data" : "tagvaluetype"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"list_checkbox\" value=\""+row.usertagsid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					if(data == 0){
						return "数字枚举";
					}else if(data == 1){
						return "字符枚举";
					}else if(data == 2){
						return "数字范围";
					}
				},
				"targets" : 4,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					return optionBtn("'"+row.usertagsid+"'", "main_edit", "del");
				},
				"targets" : 5,
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
	function query() {
		usertags_table.ajax.reload();
	}
	function del(id) {
		confirmDialog("确定删除已选择信息？",function(){
			formDelte(id?id:null, usertags_table, "usertags/delete.do", "list_checkbox");
		});
	}
	//删除
	function main_del(ids) {
		var ids = [];
		$("input[name='list_checkbox']").each(function() {
			if (this.checked == true) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0){
			layer.msg("请选择删除项！");
			return false;
		}else{
			confirmDialog("确定删除已选择信息？",function(){
				formDelte(ids?ids:null, usertags_table, "usertags/delete.do", "list_checkbox");
			});
		}
	}
	function add() {
		openDialog({
			type : 1,
			title : "用户特征添加",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "usertags/addPage.do",
			viewid : "dialogPage_usertags",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_usertagsform();
				if(boo){
					formOpt('#usertagsform', "usertags/add.do", usertags_table, index, null);
				}
			}
		});
	}
	function main_edit(id) {
		openDialog({
			type : 1,
			title : "用户特征修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "usertags/editPage.do?usertagsid="+id,
			viewid : "dialogPage_usertags",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_usertagsform();
				if(boo){
					formOpt('#usertagsform', "usertags/edit.do", usertags_table, index, null);
				}
			}
		});
	}
	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	function validate_usertagsform(){
		if($("#usertagsname").val().trim() == ""){
			layer.msg("特征名称不能为空！");
			return false;
		}else if($("#usertag").val().trim() == ""){
			layer.msg("特征字段不能为空！");
			return false;
		}else if($("#tagvalue").val().trim() == ""){
			layer.msg("特征值不能为空！");
			return false;
		}else if($("#tagvaluetype").val().trim() == ""){
			layer.msg("特征数值类型不能为空！");
			return false;
		}else{
			return true;
		}
	}
</script>
<div class="row">
	<div class="col-xs-12">
		<div class="pull-left tableTools-container" style="padding-left:20px">
			<p>
				<button class="btn btn-white btn-info btn-bold" onclick="add()">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 添加
				</button>

				<button class="btn btn-white btn-warning btn-bold" onclick="main_del()">
					<i class="ace-icon fa fa-trash-o bigger-120 orange"></i> 批量删除
				</button>
			</p>
		</div>

		<!-- div.table-responsive -->

		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="usertags_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">特征名称</th>
						<th class="center" width="10%">特征字段</th>
						<th class="center" width="10%">特征值</th>
						<th class="center" width="10%">特征数值类型</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<div class="row" id="dialogPage_usertags" style="display:none" >
</div>