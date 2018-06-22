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
	var stn_table;
	var stnCode = "";
	var stnName = "";
	$(document).ready(function() {
		initDataTable();
	});
	
	function initDataTable() {
		stn_table = $('#stn_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/stn/stnList.do',
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
				pushCondition(aoData);
			},
			columns : [ {
				"data" : "stnId"
			}, {
				"data" : "stnCode"
			}, {
				"data" : "stnName"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"stn_list_checkbox\" value=\""+row.stnId+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
				}, {
					"render" : function(data, type, row) {
						return "<a class=\"green\" href=\"javascript:;\" onclick=\"seeStnVehivleInfo('"+row.stnCode+"')\" ><i class=\"ace-icon fa fa-search bigger-130\"></i></a>";
					},
					"targets" : 3,
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
		$('#stn_table').on( 'click','tbody tr', function () {
			stnCode = $(this).children().eq(1).text();
			stnName = $(this).children().eq(2).text();
			$("input[name=stn_list_checkbox]").prop("checked", false);
			$(this).children().eq(0).children().children().prop("checked", true);
			$("#stncode").val(stnCode);
			devices_table.ajax.reload();
		});
	}
// 	$("#stn_checkbox").click(function() {
// 		$("input[name=stn_list_checkbox]").prop("checked", $(this).prop("checked"));
// 	});
	
	$("#querybtn").click(function() {
		if(stn_table){
			stn_table.ajax.reload();
		}else{
			initDataTable();
		}
 	});

	function seeStnVehivleInfo(stncode){
		stnCode = stncode;
		openVehicleDialog();
	}
	function openVehicleDialog(){
		openDialog({
			type : 1,
			title : "当前车辆信息",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '950px', '500px' ],
			scrollbar : false,
			content : "devices/vehiclePage.do",
			viewid : "dialogPage",
			btn : [ '确定'],
			yes : function(index) {
				layer.close(index);
			}
		});
	}
	
	$("#clearCarnum").click(function() {
		var carnum = $("#carnum").val();
		if(carnum != undefined && carnum != "" && carnum != null ){
			$.ajax({
				  type: 'POST',
				  url: "${pageContext.request.contextPath}/devices/clearVehicles.do",
				  data:{
					  'carnum':carnum
				  },
				  dataType: "json"
				});
		}
 	});
</script>
<div class="row">
	<div class="col-xs-12">
		<!-- div.table-responsive -->
		<!-- div.dataTables_borderWrap -->
		<form id="searchForm">
		<div class="row">
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="网点名称" name="stnname" id="stnname">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" type="text" name="stncode" placeholder='网点编码' id="stncode">
				</div>
			</div>
			<div class="col-xs-2">
					<span class="btn btn-sm btn-primary" id="querybtn">
					<i class="ace-icon fa fa-search align-top bigger-105"></i><font>搜索</font>
					</span>
					<!-- <a class="green" href="javascript:;" id="querybtn" ><font>搜索</font></a> -->
				</div>
				
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" type="text" name="stncode" placeholder='车牌号码' id="carnum">
				</div>
			</div>
			<div class="col-xs-2">
					<span class="btn btn-sm btn-primary" id="clearCarnum">
					<i class="ace-icon fa fa-search align-top bigger-105"></i><font>清除</font>
					</span>
					<!-- <a class="green" href="javascript:;" id="querybtn" ><font>搜索</font></a> -->
				</div>
		</div>
		</form>
		<hr />
		<div>
			<table id="stn_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="stn_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">网点编码</th>
						<th class="center" width="10%">网点名称</th>
						<th class="center" width="10%">当前车辆</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<hr />
<jsp:include page="deviceslist.jsp"></jsp:include>
<div class="row" id="dialogPage" style="display:none" >
</div>
<div class="row" id="dialogPage3" style="display:none" >
</div>