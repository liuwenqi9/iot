<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:20px">
		<form class="form-horizontal" role="form" id="devicesform">
			<input type="hidden" id="devicesid" name="devicesid" value="${Devices.devicesid }">
			<input type="hidden" id="nodecode" name="nodecode" value="${Devices.nodecode }">
			<input type="hidden" id="nodetag" name="nodetag" value="${Devices.nodetag }">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">商户名称<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select id="bucode" name="bucode" class="form-control" required>
						<option value="">--请选择商户名称--</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">设备类型名称<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select required id="devicestypecode" name="devicestypecode" onchange="initTypeCode();" class="form-control">
						<option value="">---请选择设备类型名称---</option>
					</select>
				</div>
			</div>
			<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">是否接收数据<span style='color:#ff0000'>*</span></label>
					<div class="col-sm-7">
						<select required id="receivedata" name="receivedata" class="form-control">
							<option value="">---是否接收数据---</option>
							<option value="0">是</option>
							<option value="1">否</option>
						</select>
					</div>
				</div>
			<div id="inputConname" style="display: none;">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">设备连接名称<span style='color:#ff0000'>*</span></label>
					<div class="col-sm-7">
						<input required id="connameIn" name="conname" placeholder="设备连接名称" class="form-control">
					</div>
					<a class="col-sm-2" onclick="showOtherConname(1)" style="cursor: pointer;text-decoration: none;">可选择</a>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">设备连接ID<span style='color:#ff0000'>*</span></label>
					<div class="col-sm-7">
						<input required id="connid" name="connid" placeholder="设备连接ID" class="form-control">
					</div>
				</div>
			</div>
			<div class="form-group" id="selectConname">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">设备连接名称<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select required id="conname" name="conname" class="form-control">
						<option value="">---请选择设备类型名称---</option>
					</select>
				</div>
				<!-- <div id="a_hide"><a class="col-sm-2" onclick="showOtherConname(0)" style="cursor: pointer;text-decoration: none;">自定义</a></div> -->
			</div>
			<div id="type_hidden">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">设备区域数量<span style='color:#ff0000'>*</span></label>
					<div class="col-sm-7">
						<input type="text" required id="deviceareanum" name="deviceareanum" placeholder="设备区域数量" value="${Devices.deviceareanum }" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">是否自助加油<span style='color:#ff0000'>*</span></label>
					<div class="col-sm-7">
						<select required id="selfservice" name="selfservice" class="form-control">
							<option value="">---请选择是否自助加油---</option>
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</div>
				</div>
				<%-- <div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">X轴(米)</label>
					<div class="col-sm-7">
						<input type="text" required id="xlength" name="xlength" placeholder="X轴" value="${Devices.xlength }" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">Y轴(米)</label>
					<div class="col-sm-7">
						<input type="text" required id="ylength" name="ylength" placeholder="Y轴" value="${Devices.ylength }" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div> --%>
			</div>
		</form>
	</div>
<script type="text/javascript">
$(document).ready(function() {
	initBuInfo();
	initDevicesType();
// 	initConnid();
	$("#nodecode").val(stnCode);
	$("#nodetag").val(stnName);
	$("#selfservice option[value='${Devices.selfservice }']").prop("selected",true);
	$("#receivedata option[value='${Devices.receivedata }']").prop("selected",true);
	initTypeCode();
});
function initDevicesType(){
	var devicesTypeList = '${DevicesTypeList}';
	if(devicesTypeList != null && devicesTypeList != '' && devicesTypeList != undefined){
		var list = eval("("+devicesTypeList+")");
		var str = "";
		var dname = '${Devices.devicestypecode }';
		for(var i=0; i<list.length; i++){
 			if (dname != undefined && dname != null && dname != '' && dname == list[i].itemCode) {
	 			str += "<option selected value='"+list[i].itemCode+"'>"+list[i].itemValue+"</option>";
 			}else{
	 			str += "<option value='"+list[i].itemCode+"'>"+list[i].itemValue+"</option>";
 			}
 		}
		$("#devicestypecode").append(str);
	}else{
		layer.alert("载入设备类型列表失败！");
	}
}
//编辑页 加载商户下拉列表
function initBuInfo(){
	var buInfo = '${buInfo}';
	var success = '${success}';
	if(success == "true"){
		var buname = '${Devices.buname}';
		var bu = eval("("+buInfo+")");
		var str = "";
		for(var i=0; i<bu.length; i++){
 			var b = bu[i];
 			if (buname != undefined && buname != null && buname != '' && buname == b[2]) {
	 			str += "<option selected value='"+b[3]+"'>"+b[2]+"</option>";
 			}else{
	 			str += "<option value='"+b[3]+"'>"+b[2]+"</option>";
 			}
 		}
		$("#bucode").append(str);
	}else{
		if(buInfo){
			layer.alert(buInfo);
		}else{
			layer.alert("载入商户列表失败！");
		}
	}
}
function initConnid(typename, typecode){
	var keySet = '${keySet}';
	var idStr = eval("("+keySet+")");
	if(keySet && keySet != "[]"){
		var pre = stnName+"_";
		if(typename){
			pre += typename+"_";
		}else{
			var devicestypename = '${Devices.devicestypename}';
			if(devicestypename){
				pre += devicestypename+"_";
			}else{
				return false;
			}
		}
		var str = "<option value=''>---请选择设备连接名称---</option>";
		var conname = '${Devices.conname}';
		var connid = '${Devices.connid}';
		var count = 0;
		for(var i=0; i<idStr.length; i++){
			var conntype = idStr[i].conntype;
			var clientId = idStr[i].clientId;
			var name = pre+clientId;
			if(clientId == connid){
	 			count++;
			}
			if(typecode == conntype){
				if(name == conname){
		 			str += "<option selected value='"+name+"'>"+name+"</option>";
				}else{
		 			str += "<option value='"+name+"'>"+name+"</option>";
				}
			}
 		}
		$("#conname").html("");
		$("#conname").append(str);
		if(count == 0){//展示input
			showOtherConname(0);
			$("#inputConname").find("input").eq(0).val(name);
			$("#inputConname").find("input").eq(1).val(connid);
		}
	}else{
		layer.alert("当前无连接信息！");
	}
}
function initTypeCode(){
	var val = $("#devicestypecode").find("option:selected").val();
	if(val){
		var typename = $("#devicestypecode").find("option:selected").text();
		initConnid(typename,val);
	}else{
		$("#conname").html("");
		$("#conname").append("<option value=''>---请选择设备类型名称---</option>");
	}
	showOtherConname(1);
	
	$("deviceareanum,selfservice,receivedata").val("");
	if(val == "002"){//摄像头
		$("#type_hidden").hide();
	}
}
function showOtherConname(param){
	if(param == 1){
		$("#inputConname").hide();
		$("input[name='conname']").val("");
		$("input[name='connid']").val("");
		$("#selectConname").show();
	}else{
		$("#selectConname").hide();
		$("#conname option[value='']").prop("selected",true);
		$("#inputConname").show();
	}
}
</script>