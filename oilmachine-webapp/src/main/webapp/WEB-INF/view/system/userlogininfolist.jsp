<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	 var userLoginInfo_table;
	 $(document).ready(function() {
		initDataTable();
	 });
	 
	 function initDataTable() {
		userLoginInfo_table = $('#userLoginInfo_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/home/userlogininfolist.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
				pushCondition_user(aoData);
			},
			columns : [ {
				"data" : "id"
			} , {
				"data" : "username"
			} , {
				"data" : "stncode"
			} , {
				"data" : "carnum"
			} , {
				"data" : "deviceconnid"
			} , {
				"data" : "saleno"
			} , {
				"data" : "oilcode"
			} , {
				"data" : "ip"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"list_checkbox\" value=\""+row.busisysid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			},{
				"render" : function(data, type, row) {
					return "<a class=\"green\" href=\"javascript:;\" onclick=\"seeUserDetail('"+ row.id +"')\" >详细信息</a>";
				},
				"targets" : 8,
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
	function pushCondition_user(params) {
		var t = $("#searchForm").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
	
	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	
	$("#querybtn").click(function() {
		if(userLoginInfo_table){
			userLoginInfo_table.ajax.reload();
		}else{
			initDataTable();
		}
 	});
 	
 	
 	function seeUserDetail(id){
 		openDialog({
			type : 1,
			title : "用户详情信息",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '1170px', '700px' ],
			scrollbar : false,
			content : "home/seeUserDetail.do?id="+id,
			viewid : "dialogPage1",
			btn : [ '关闭'],
			yes : function(index) {
				layer.close(index);
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
					<input type="text" class="form-control col-sm-3" placeholder="网点编码" name="stncode" id="stncode">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="车牌号码" name="carnum" id="carnum">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder='用户名' name="userName"  id="userName">
				</div>
			</div>
		</div>
		</br>	
		<div class="row">	
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="订单编号" name="saleno" id="saleno">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="加油机连接ID" name="deviceconnid" id="deviceconnid">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder='油品编码' name="oilcode"  id="oilcode">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<select class="form-control col-sm-3" placeholder='登录状态' name="status" >
						<option value="">---登录状态---</option>
						<option value="0">登录中</option>
						<option value="1">已退出</option>
					</select>
				</div>
			</div>
			<div class="col-xs-2">
					<span class="btn btn-sm btn-primary" id="querybtn">
					<i class="ace-icon fa fa-search align-top bigger-105"></i><font>搜索</font>
					</span>
				</div>
		</div>
		</form>
		</br>
		<div>
			<table id="userLoginInfo_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">用户名称</th>
						<th class="center" width="10%">网点编码</th>
						<th class="center" width="10%">车牌号</th>
						<th class="center" width="10%">加油机连接ID</th>
						<th class="center" width="10%">订单号</th>
						<th class="center" width="10%">油品编码</th>
						<th class="center" width="10%">IP</th>
						<th class="center" width="10%">详情</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<div class="row" id="dialogPage1" style="display:none;width:100%"></div>