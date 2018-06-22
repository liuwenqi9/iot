<jsp:directive.page language="java" pageEncoding="UTF-8"/>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var gasorder_table;
	$(document).ready(function() {
		initDataTable();
	});

	function initDataTable() {
		gasorder_table = $('#gasorder_table').DataTable({
		ajax : {
			url : '${pageContext.request.contextPath}/sellorder/sellorderlist.do',
			dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			lengthMenu: [5, 10, 25, 50, 100],
 			fnServerParams: function (aoData) {
				pushCondition_sellorder(aoData);
			},
			columns : [{
				"data" : "username"
			}, {
				"data" : "stncode"
			}, {
				"data" : "stnname"
			}, {
				"data" : "saleno"
			}, {
				"data" : "ystotal"
			}, {
				"data" : "sstotal"
			}, {
				"data" : "yhtotal"
			}, {
				"data" : "paytypename"
			}, {
				"data" : "accountid"
			}, {
				"data" : "opetime"
			} ],
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			},{
				"render" : function(data, type, row) {
					if(data == "" || data == null || data == undefined){
						var data = "0.00";
					}else{
						var data = data/100;
					}
					return data;
				},
				"targets" :[4, 5, 6 ],
				"center" : "center"
			}],
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
		$('#gasorder_table').on( 'click','tbody tr', function () {
			stnCode = $(this).children().eq(1).text();
			stnName = $(this).children().eq(2).text();
			saleno = $(this).children().eq(3).text();
			$("input[name=stn_list_checkbox]").prop("checked", false);
			$(this).children().eq(0).children().children().prop("checked", true);
			//$("#stncode").val(stnCode);
			//$("#saleno").val(saleno);
			selectSellOrderTable(stnCode,saleno);
		});
		}
		
		function pushCondition_sellorder(params) {
			var t = $("#searchForm").serializeArray();
			$.each(t, function() {
				if(this.value != null && this.value != ""){
					eval("params." + this.name + "='" + this.value + "'");
				}
			});
		}
		
	function selectSellOrderTable(stnCode,saleno){
		if(saleno){
			Saleno = saleno;
			openDialog({
				type : 1,
				title : "订单信息明细",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '1100px', '650px' ],
				scrollbar : false,
				content : "sellorder/addPage.do",
				viewid : "dialogPage",
				btn : [ '取消' ],
				yes : function(index) {
					layer.close(index);
				}
			});
		}else{
			layer.msg("请选择一个订单信息！");
		}
	}
	
	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	
	function query() {
		gasorder_table.ajax.reload();
	}
</script>
<div class="row">
	<div class="col-xs-12">
	<form id="searchForm">
		<div class="row">
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="网点编码" name="stncode" id="stncode">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" type="text" name="saleno" placeholder='订单流水号' id="saleno">
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
			<table id="gasorder_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="10%">用户名</th>
						<th class="center" width="10%">网点编码</th>
						<th class="center" width="10%">网点名称</th>
						<th class="center" width="20%">订单流水号</th>
						<th class="center" width="10%">应收（元）</th>
						<th class="center" width="10%">实收（元）</th>
						<th class="center" width="10%">优惠（元）</th>
						<th class="center" width="10%">付款方式名称</th>
						<th class="center" width="10%">支付账户标识</th>
						<th class="center" width="15%">
							<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"/>交易时间
						</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<hr />
<div class="row" id="dialogPage" style="display:none" >
</div>
