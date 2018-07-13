<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var DevicesId = "";
	var Connid = "";
	var devices_table = $('#devices_table').DataTable({
		ajax : {
			url : '${pageContext.request.contextPath}/devices/devicesList.do',
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
			"data" : "devicesid"
		}, {
			"data" : "buname"
		}, {
			"data" : "connstatus"
		}, {
			"data" : "conname"
		}, {
			"data" : "devicestypecode"
		}, {
			"data" : "devicestypename"
		} ],
		"columnDefs" : [ 
			 {
				"defaultContent" : "",
				"targets" : "_all"
			},{
			"render" : function(data, type, row) {
				var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"list_checkbox\" value=\""+row.devicesid+"\"/> <span class=\"lbl\"></span>";
				return check;
			},
			"targets" : 0,
			"center" : "center"
		}, {
			"render" : function(data, type, row) {
				if(data == 0){
					return "正常";
				}else{
					return "<font color='red'>失效</font>";
				}
			},
			"targets" : 2,
			"center" : "center"
		}, {
			"render" : function(data, type, row) {
				return "<a class=\"green\" href=\"javascript:;\" onclick=\"addArea('"+row.connid  +"','"+ row.devicestypecode+"')\" ><i class=\"ace-icon fa fa-floppy-o bigger-130\"></i></a>";
			},
			"targets" : 6,
			"center" : "center"
		},/*   {
			"render" : function(data, type, row) {
				return "<a class=\"green\" href=\"javascript:;\" onclick=\"addnozzle('"+row.connid  +"','"+ row.devicestypecode+"')\" ><i class=\"ace-icon fa fa-floppy-o bigger-130\"></i></a>";
			},
			"targets" : 7,
			"center" : "center"
		}, */{
			"render" : function(data, type, row) {
				return "<a class=\"green\" href=\"javascript:;\" onclick=\"seeVehivleInfo('"+row.connid+"','"+row.devicestypecode+"')\" ><i class=\"ace-icon fa fa-search bigger-130\"></i></a>";
			},
			"targets" : 7,
			"center" : "center"
		}, {
			"render" : function(data, type, row) {
				return optionBtn("'"+row.devicesid+"'", "main_edit", "del");
			},
			"targets" : 8,
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
	$('#devices_table').on( 'click','tbody tr', function () {
		$("input[name=list_checkbox]").prop("checked", false);
		$(this).children().eq(0).children().children().prop("checked", true);
		DevicesId = $(this).children().eq(0).children().children().val();
	});
	function query() {
		devices_table.ajax.reload();
	}
	function del(id) {
		confirmDialog("确定删除已选择信息？",function(){
			formDelte(id?id:null, devices_table, "devices/delete.do", "list_checkbox");
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
				formDelte(ids?ids:null, devices_table, "devices/delete.do", "list_checkbox");
			});
		}
	}
	function add() {
		if($("#stncode").val()){
			openDialog({
				type : 1,
				title : "设备信息添加",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '650px', '500px' ],
				scrollbar : false,
				content : "devices/addPage.do?stncode="+$("#stncode").val(),
				viewid : "dialogPage",
				btn : [ '确定', '取消' ],
				yes : function(index) {
					var boo = validate_devicesform();
					if(boo){
						formOpt($('#devicesform'), "devices/add.do", devices_table, index, null);
					}
				}
			});
		}else{
			layer.msg("请选择一个网点信息！");
		}
	}
	function main_edit(id) {
		openDialog({
			type : 1,
			title : "设备信息修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '500px' ],
			scrollbar : false,
			content : "devices/editPage.do?devicesid="+id+"&nodecode="+$("#stncode").val(),
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_devicesform();
				if(boo){
					formOpt($('#devicesform'), "devices/edit.do", devices_table, index, null);
				}
			}
		});
	}
	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	function validate_devicesform(){
		if(!$("#bucode").val().trim()){
			layer.msg("商户名称不能为空！");
			return false;
		}
		if(!$("#devicestypecode").val().trim()){
			layer.msg("设备类型名称不能为空！");
			return false;
		}
		if(!$("#conname").val().trim() && !$("#connameIn").val().trim()){
			layer.msg("设备连接名称不能为空！");
			return false;
		}
		if($("#inputConname").css("display")=="block"){
			if(!$("#connid").val()){
				layer.msg("连接ID不能为空！");
				return false;
			}
		}
		if($("#type_hidden").css("display")=="block"){
			if(!$("#selfservice").val()){
				layer.msg("是否自助加油不能为空！");
				return false;
			}
			if(!$("#receivedata").val()){
				layer.msg("是否接收数据不能为空！");
				return false;
			}
		}
		return true;
	}
	function addArea(id,typecode){
		if(typecode == "002"){//摄像头区域维护
		//根据租户id.网点编码查询已维护的加油机数据
			DevicesId = id;
			openDialog({
				type : 1,
				title : "摄像机绑定加油机及安全区域",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '750px', '500px' ],
				scrollbar : false,
				content : "devicesarea/cameradevicesareaPage.do",
				viewid : "dialogPage",
				btn : [ '确定'],
				yes : function(index) {
					layer.close(index);
				}
			});
		
		}else{
			DevicesId = id;
			openDialog({
				type : 1,
				title : "安全区域",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '750px', '500px' ],
				scrollbar : false,
				content : "devicesarea/devicesareaPage.do",
				viewid : "dialogPage",
				btn : [ '确定'],
				yes : function(index) {
					layer.close(index);
				}
			});
		}
	}
	
	
	//加油机油枪维护
	function addnozzle(id,typecode){
		if(typecode == "001"){//摄像头区域维护
		//根据租户id.网点编码查询已维护的加油机数据
			DevicesId = id;
			openDialog({
				type : 1,
				title : "添加油枪",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '750px', '500px' ],
				scrollbar : false,
				content : "devices/nozzlePage.do",
				viewid : "dialogPage",
				btn : [ '确定'],
				yes : function(index) {
					layer.close(index);
				}
			});
		
		}
	}
	//查看当前车辆信息
	function seeVehivleInfo(connid,devicestypecode){
		Connid = connid;
		Devicestypecode = devicestypecode;
		openVehicleDialog();
	}
</script>
<div class="row">
	<div class="col-xs-12">
		<form id="searchForm">
			<input hidden="hidden" id="stncode" name="stncode">
		</form>
		<div class="pull-left tableTools-container">
			<p>
			    <span style="color: blue;font-size: 20px;">网点设备信息</span>
				<button class="btn btn-white btn-info btn-bold" onclick="add()" style="margin-left:10px">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 添加
				</button>

				<button class="btn btn-white btn-warning btn-bold" onclick="main_del()" style="margin-left: 10px;">
					<i class="ace-icon fa fa-trash-o bigger-120 orange"></i> 批量删除
				</button>
				
				<!-- <button class="btn btn-white btn-info btn-bold" onclick="seeVehivleInfo()" style="margin-left:10px">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 当前车辆
				</button> -->
			</p>
		</div>

		<!-- div.table-responsive -->

		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="devices_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">商户名称</th>
						<th class="center" width="5%">连接状态</th>
						<th class="center" width="20%">设备连接名称</th>
						<th class="center" width="8%">设备类型编码</th>
						<th class="center" width="10%">设备类型名称</th>
						<th class="center" width="8%">区域维护</th>
						<!-- <th class="center" width="8%">油枪维护</th> -->
						<th class="center" width="8%">当前车辆</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
