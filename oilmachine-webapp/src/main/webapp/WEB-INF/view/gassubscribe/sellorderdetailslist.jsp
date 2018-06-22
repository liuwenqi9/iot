<jsp:directive.page language="java" pageEncoding="UTF-8"/>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>
<style>
.dataTable{
	text-align:center;
}

ul li a{
margin-left:5px;
} 
</style>
<script>
	var sellproduct_table;
	//$("#saleno").val(Saleno);
	$(document).ready(function() {
		initDataTable();
	});

	function initDataTable() {
		sellproduct_table = $('#sellproduct_table').DataTable({
		ajax : {
			url : '${pageContext.request.contextPath}/sellorder/sellProductlist.do?saleno='+Saleno,
			dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			destroy:true, //Cannot reinitialise DataTable,解决重新加载表格内容问题
			padding : true,
			dom : '<f<t>lip>',
			columns : [ {
				"data" : "saleno"
			}, {
				"data" : "productname"
			}, {
				"data" : "productcode"
			}, {
				"data" : "productprice"
			}, {
				"data" : "volume"
			}, {
				"data" : "ystotal"
			}, {
				"data" : "sstotal"
			}, {
				"data" : "yhtotal"
			} ],
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			}, {
				"render" : function(data, type, row) {
					if(data == "" || data == null || data == undefined){
						var data = "0.00";
					}else{
						var data = data/100;
					}
					return data;
				},
				"targets" :[5, 6, 7],
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
	}
	
	var selldiscounts_table;
	function discountsDataTable() {
		selldiscounts_table = $('#selldiscounts_table').DataTable({
		ajax : {
			url : '${pageContext.request.contextPath}/sellorder/sellDiscountslist.do?saleno='+Saleno,
			dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			destroy:true, //Cannot reinitialise DataTable,解决重新加载表格内容问题
			padding : true,
			dom : '<f<t>lip>',
			columns : [ {
				"data" : "saleno"
			}, {
				"data" : "discountsbody"
			}, {
				"data" : "discountstype"
			}, {
				"data" : "discountsamount"
			}, {
				"data" : "gist"
			}],
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			},{
				"render" : function(data, type, row) {
					if(data == 0){
						var data = "本次交易";
					}
					if(data == 1){
						var data = "单一商品";
					}
						return data;
				},
				"targets" :[1],
				"center" : "center"
			},{
				"render" : function(data, type, row) {
					if(data == 0){
						var data = "电子券";
					}
					return data;
				},
				"targets" :[2],
				"center" : "center"
			},{
				"render" : function(data, type, row) {
					if(data == "" || data == null || data == undefined){
						var data = "0.00";
					}else{
						var data = data/100;
					}
					return data;
				},
				"targets" :[3],
				"center" : "center"
			},{
				"render" : function(data, type, row) {
					if(data == 0){
						var data = "电子券编码";
					}
					return data;
				},
				"targets" :[4],
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
	}
	
	//查询订单商品信息
	function sellProductInfo(){
		$("#discounts_hidden").hide();
		$("#product_hidden").show();
	//alert("订单商品信息");
		initDataTable();
	}
	
	//查询订单预约信息
	function sellSubscribe(){
	//alert("订单预约信息");
		initDataTable();
	}
	
	//查询订单优惠信息
	function sellDiscounts(){
	//alert("订单优惠信息");
		$("#product_hidden").hide();
		$("#discounts_hidden").show();
		discountsDataTable();
	}
	
	//查询订单退款信息
	function sellRefund(){
	//alert("订单退款信息");
		initDataTable();
	}
	
   $("#sellul li").click(function() {  
       $(this).siblings('li').removeClass('active');    
       $(this).addClass('active');                            
    });  
</script>

<ul id='sellul' class="nav nav-tabs">
	<li  class="active"><a href="javascript:void(0)" onclick="sellProductInfo()">订单商品信息</a></li>
	<li><a href="javascript:void(0)" onclick="sellSubscribe()">订单预约信息</a></li> 
	<li><a href="javascript:void(0)" onclick="sellDiscounts()">订单优惠信息</a></li>
	<li><a href="javascript:void(0)" onclick="sellRefund()">订单退款信息</a></li>
</ul>
<div class="row"  id="product_hidden" >
		 <div class="col-xs-12">
					<%-- <input type="hidden" class="form-control col-sm-3" placeholder="网点编码" name="stncode" id="stncode">
					<input type="hidden" class="form-control col-sm-3" type="text" name="saleno" placeholder='销售流水号' id="saleno"> --%>
		<div> 
			<table id="sellproduct_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="10%">订单流水号</th>
						<th class="center" width="10%">商品名称</th>
						<th class="center" width="10%">商品编码</th>
						<th class="center" width="20%">商品单价</th>
						<th class="center" width="10%">数量</th>
						<th class="center" width="10%">应收（元）</th>
						<th class="center" width="10%">实收（元）</th>
						<th class="center" width="10%">优惠（元）</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<div class="row" id="discounts_hidden" style="display: none;">
		 <div class="col-xs-12">
		<div> 
			<table id="selldiscounts_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="10%">订单流水号</th>
						<th class="center" width="10%">优惠对象</th>
						<th class="center" width="10%">优惠类型</th>
						<th class="center" width="20%">优惠金额（元）</th>
						<th class="center" width="10%">优惠依据</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>