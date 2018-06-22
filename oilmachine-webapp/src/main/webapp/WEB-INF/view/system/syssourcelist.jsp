<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var sysSource_table;
	$.fn.dataTable.ext.errMode = function(s,h,m){}
	$(document).ready(function() {
		sysSource_table = $('#sysSource_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/home/queryBusiSysInfoList.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			} ],
			columns : [ {
				"data" : "busisysid"
			}, {
				"data" : "syssource"
			}, {
				"data" : "sysdesc"
			}, {
				"data" : "callbackurl"
			}, {
				"data" : "createdate"
			} ],
			"columnDefs" : [ {
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"list_checkbox\" value=\""+row.busisysid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					return optionBtn(row.busisysid, "main_edit", "main_del");
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

	//删除
	function main_del(ids) {
		confirmDialog("确定删除选择系统来源",function(){
			formDelte(ids ? ids : null, sysSource_table, "home/detele.do", "list_checkbox",null);
		});
	}
	function main_edit(id) {
		openDialog({
			type : 1,
			title : "系统来源修改",
			shadeClose : true,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '800px', '600px' ],
			scrollbar : false,
			content : "home/editPage.do?busisysid="+id,
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				formOpt($('#syssourceform'), "home/edit.do", sysSource_table, index, null);
			}
		});
	}
	function add() {
		openDialog({
			type : 1,
			title : "系统来源添加",
			shadeClose : true,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '800px', '600px' ],
			scrollbar : false,
			content : "home/addPage.do",
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var password = $("#password1").val();
				$("#password").val(hex_md5(password));
				formOpt($('#syssourceform'), "home/add.do", sysSource_table, index, null);

			}
		});
	}

	/**
	 * 保存跳转
	 */
	/* function add() {
	   formOpt($('#syssourceform'),"home/add.action",$('#busisys_addbtn'),null);	
	} */
	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
</script>
<div class="row">
	<div class="col-xs-12">
		<div class="clearfix">
			<div class="pull-right tableTools-container"></div>
		</div>
		<hr />
		<div class="pull-left tableTools-container" style="padding-left:20px">
			<p>
				<button class="btn btn-white btn-info btn-bold" onclick="add()">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 添加
				</button>

				<button class="btn btn-white btn-warning btn-bold" onclick="main_del()">
					<i class="ace-icon fa fa-trash-o bigger-120 orange"></i> Delete
				</button>
			</p>
		</div>

		<!-- div.table-responsive -->

		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="sysSource_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">系统来源</th>
						<th class="center" width="10%">系统描述</th>
						<th class="center" width="10%">回调地址</th>
						<th class="center" width="15%">
							<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>创建时间
						</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<div class="row" id="dialogPage" style="display:none;width:800px"></div>