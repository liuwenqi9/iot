<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var vehicle_table;
	$(document).ready(function() {
		$("#search_stnCode").val(stnCode);
		$("#search_connid").val(Connid);
		$("#search_devicetypecode").val(Devicestypecode);
		
		vehicle_table = $('#vehicle_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/devices/vehicleList.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
				pushCondition_vehicle(aoData);
			},
			columns : [ {
				"data" : "cameraid"
			}, {
				"data" : "carnum"
			}, {
				"data" : "userid"
			}, {
				"data" : "username"
			}, {
				"data" : "carcolorname"
			}, {
				"data" : "cartypename"
			}, {
				"data" : "carstatus"
			}, {
				"data" : "areacode"
			}, {
				"data" : "oilconnid"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"vehicle_checkbox\" value=\""+row.cameraid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					if(data == 0){
						return "停止";
					}else{
						return "行驶";
					}
				},
				"targets" : 7,
				"center" : "center"
 			}, {
 				"render" : function(data, type, row) {
 					return "<a class=\"green\" href=\"javascript:;\" onclick=\"optionBtn('"+row.carnum+"','"+row.oilconnid+"')\" ><i class=\"ace-icon fa fa-search bigger-130\"></i></a>";
 					//return optionBtn("'"+row.carnum+"'","'"+row.oilconnid+"'");
 				},
 				"targets" : 10,
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
	
	function optionBtn(carnum,oilconnid){
		console.log(carnum);
		console.log(oilconnid);
		var stnCode = $("#search_stnCode").val();
		$.ajax({
			  type: 'POST',
			  url: "${pageContext.request.contextPath}/devices/clearVehicles.do",
			  data:{
				  'oilconnid':oilconnid,
				  'carnum':carnum,
				  'stnCode':stnCode
			  },
			  dataType: "json",
			});
			//不管清除成功还是失败都进行刷新
			vehicle_table.ajax.reload();
	}
	function pushCondition_vehicle(params) {
		var t = $("#vehicleSearch").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
	function query() {
		vehicle_table.ajax.reload();
	}
	function area_del(id) {
		confirmDialog("确定删除已选择信息？",function(){
			formDelte(id?id:null, vehicle_table, "devicesarea/delete.do", "vehicle_checkbox");
		});
	}
	function area_add() {
		openDialog({
			type : 1,
			title : "设备区域添加",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "devicesarea/addPage.do?devicesid="+DevicesId,
			viewid : "dialogPage3",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_devicesareaform();
				if(boo){
					formOpt($('#devicesareaform'), "devicesarea/add.do", vehicle_table, index, null);
				}
			}
		});
	}
	function area_edit(id) {
		openDialog({
			type : 1,
			title : "设备区域修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "devicesarea/editPage.do?devicesareaid="+id+"&devicesid="+DevicesId,
			viewid : "dialogPage3",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_devicesareaform();
				if(boo){
					formOpt($('#devicesareaform'), "devicesarea/edit.do", vehicle_table, index, null);
				}
			}
		});
	}
	$("#vehicle_checkbox").click(function() {
		$("input[name=vehicle_checkbox]").prop("checked", $(this).prop("checked"));
	});
	function validate_devicesareaform(){
		if($("#areacode").val().trim() == ""){
			layer.msg("区域编号不能为空！");
			return false;
		}
		return true;
	}
</script>
<div class="row">
	<div class="col-xs-12">
		<form id="vehicleSearch" style="display: none;">
			<input hidden="hidden" id="search_stnCode" name="stnCode">
			<input hidden="hidden" id="search_connid" name="connid">
			<input hidden="hidden" id="search_devicetypecode" name="devicetypecode">
		</form>
		<!-- <div class="pull-left tableTools-container" style="padding-left:20px">
			<p>
				<button class="btn btn-white btn-info btn-bold" onclick="area_add()">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 添加
				</button>
			</p>
		</div> -->

		<!-- div.table-responsive -->

		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="vehicle_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="vehicle_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">车牌号</th>
						<th class="center" width="10%">用户ID</th>
						<th class="center" width="10%">用户名</th>
						<th class="center" width="10%">车辆颜色</th>
						<th class="center" width="10%">车辆类型</th>
						<th class="center" width="10%">车辆状态</th>
						<th class="center" width="10%">所属区域号</th>
 						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

