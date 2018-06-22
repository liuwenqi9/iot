<jsp:directive.page language="java" pageEncoding="UTF-8"/>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var mqsendexception_table;
	$.fn.dataTable.ext.errMode = function(s,h,m){}
	$(document).ready(function() {
		mqsendexception_table = $('#mqsendexception_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/mqsendexception/mqsendexceptionList.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
				pushCondition(aoData);
			},
			columns : [ {
				"data" : "mqsendexceptionid"
			}, {
				"data" : "typecode"
			}, {
				"data" : "methodname"
			}, {
				"data" : "exmsg"
			} ],
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			}, {
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"list_checkbox\" value=\""+row.gasOrderrefundID+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					var check = "未知";
					if(data == "0001"){
						check = "加油订单";
					}else if(data == "0002"){
						check = "预约订单";
					}else if(data == "0003"){
						check = "退款订单";
					}
					return check; 
				},
				"targets" : 1,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					var btn = "<a onclick = seeExmsgDetail(\""+ row.mqsendexceptionid +"\"); style='cursor:pointer;text-decoration:none;'>查看</a>";
					return btn; 
				},
				"targets" : 3,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					var btn = "<a onclick = reSendMq(\""+ row.mqsendexceptionid +"\"); style='cursor:pointer;text-decoration:none;'>重新发送</a>";
					return btn; 
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
			$("#mqsendexception_table tbody").on( "click", "tr", function () {
				var data;
		        if ( $(this).hasClass("selected") ) {
		            $(this).removeClass("selected");
		        	data = mqsendexception_table.row(this).data().id;
		        }
		        else {
		            mqsendexception_table.$("tr.selected").removeClass("selected");
		            $(this).addClass("selected");
		        	data = mqsendexception_table.row(this).data().id;
		        	
		        }
		       
	    	} );
	});
	
	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	
	function query() {
		mqsendexception_table.ajax.reload();
	}
	function reSendMq(mqsendexceptionid){
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/mqsendexception/reSendMq.do?mqsendexceptionid=" + mqsendexceptionid,
			data : null,
			dataType : "text",
			success : function(re) {
				if(re != ""){
					var json = eval("(" + re + ")");
					if(json.status){
						buttomDialog("已重发！");
					}else{
						buttomDialog(json.msg);
					}
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});
	}
	function seeExmsgDetail(mqsendexceptionid){
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/mqsendexception/findById.do?mqsendexceptionid=" + mqsendexceptionid,
			data : null,
			dataType : "text",
			success : function(re) {
				if(re != ""){
					var json = eval("(" + re + ")");
// 					layer.open(json.msg);
					layer.open({
						  type: 1,
						  skin: 'layui-layer-rim', //加上边框
						  area: ['800px', '400px'], //宽高
						  shadeClose: true, //开启遮罩关闭
						  content: json.msg
						});
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});
	}
</script>
<div class="row">
	<div class="col-xs-12">
	<form id="searchForm">
		<div class="row">
			<div class="col-xs-2">
				<div class="form-group">
					<select id="typecode" name="typecode" class="form-control col-sm-3">
						<option value="">---请选择消息类型---</option>
						<option value="0001">加油订单</option>
						<option value="0002">预约订单</option>
						<option value="0003">退款订单</option>
					</select>
				</div>
			</div>
			<div class="col-xs-2">
					<span class="btn btn-sm btn-primary" onclick="query()">
					<i class="ace-icon fa fa-search align-top bigger-105"></i><font>搜索</font>
					</span>
				</div>
		</div>
	</form>
		<div class="clearfix">
			<div class="pull-right tableTools-container"/>
		</div>
		<div>
			<table id="mqsendexception_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox"/> <span class="lbl"/>
							</label>
						</th>
						<th class="center" width="10%">消息类型</th>
						<th class="center" width="10%">调用方法名</th>
						<th class="center" width="10%">异常信息</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
