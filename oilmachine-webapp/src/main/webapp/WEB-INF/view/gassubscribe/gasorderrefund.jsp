<jsp:directive.page language="java" pageEncoding="UTF-8"/>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var gasorderrefund_table;
	$.fn.dataTable.ext.errMode = function(s,h,m){}
	$(document).ready(function() {
		gasorderrefund_table = $('#gasorderrefund_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/gasorderrefund/gasorderrefundList.do',
				dataSrc : function ( json ) {
					var list = json.data;
					var data1 = "";	
					if(list != '' && list != null && list != undefined){
						var data0 = list[0];
						var data1 = list[1];
						$.each(data1,function(i,val){
							$.each(data0,function(j,jval){
								if(i==j){
									val.updateuser = jval.username;
								}	
							});
						});
					}
			        return data1;
			      }
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
				"data" : "gasOrderrefundID"
			}, {
				"data" : "updateuser"
			}, {
				"data" : "gasorderid"
			}, {
				"data" : "tranrecord"
			}, {
				"data" : "opetime"
			}, {
				"data" : "amount"
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
			$("#gasorderrefund_table tbody").on( "click", "tr", function () {
				var data;
		        if ( $(this).hasClass("selected") ) {
		            $(this).removeClass("selected");
		        	data = gasorderrefund_table.row(this).data().id;
		        }
		        else {
		            gasorderrefund_table.$("tr.selected").removeClass("selected");
		            $(this).addClass("selected");
		        	data = gasorderrefund_table.row(this).data().id;
		        	
		        }
		       
	    	} );
	});
	
	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	
	function query() {
		gasorderrefund_table.ajax.reload();
	}
</script>
<div class="row">
	<div class="col-xs-12">
	<form id="searchForm">
		<div class="row">
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="加油订单ID" name="gasorderid" id="gasorderid">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" type="text" name="tranrecord" placeholder='交易流水' id="tranrecord">
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
			<table id="gasorderrefund_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox"/> <span class="lbl"/>
							</label>
						</th>
						<th class="center" width="10%">用户名</th>
						<th class="center" width="10%">加油订单ID</th>
						<th class="center" width="10%">交易流水</th>
						<th class="center" width="15%">
							<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"/>交易时间
						</th>
						<th class="center" width="10%">退款金额</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
