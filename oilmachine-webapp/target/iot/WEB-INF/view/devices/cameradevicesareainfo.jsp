<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:20px">
		<form class="form-horizontal" role="form" id="devicesform">
			<input type="hidden" id="devicesid" name="devicesid" value="${Devices.devicesid }">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">加油机名称<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select required id="connameid" name="conname" onchange="initTypeCode();" class="form-control">
						<option value="">---请选择加油机---</option>
					</select>
				</div>
			</div>
			<div id="areacode_hidden" style="display: none;">
				<div class="form-group" >
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">区域编号（即屏幕操作位号）<span style='color:#ff0000'>*</span></label>
					<div class="col-sm-7">
						<select id="areacodeid" name="areacode" class="form-control" required  onchange="selectAreacode();">
							<option value="">--请选择区域编号--</option>
						</select>
					</div>
				</div>
			</div>
			<div id="xy_hidden" style="display: none;">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">左上X轴（米）</label>
					<div class="col-sm-7">
						<input type="text" required id="lefttopx" name="lefttopx" placeholder="左上X轴" value="${DevicesArea.lefttopx }" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">左上Y轴（米）</label>
					<div class="col-sm-7">
						<input type="text" required id="lefttopy" name="lefttopy" value="${DevicesArea.lefttopy }" placeholder="左上Y轴" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">右下X轴（米）</label>
					<div class="col-sm-7">
						<input type="text" required id="rightbottomx" name="rightbottomx" value="${DevicesArea.rightbottomx }" placeholder="右下X轴" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">右下Y轴（米）</label>
					<div class="col-sm-7">
						<input type="text" required id="rightbottomy" name="rightbottomy" value="${DevicesArea.rightbottomy }" placeholder="右下Y轴" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
			</div>	
		</form>
	</div>
<script type="text/javascript">
$(document).ready(function() {
	initAllDevices();
	$("#devicesid").val(DevicesId);
});

//加载摄像机所在网点下所有加油机
function initAllDevices(){
	var devicesList = '${devicesList}';
	if(devicesList != null && devicesList != '' && devicesList != undefined){
		var list = eval("("+devicesList+")");
		var str = "";
		for(var i=0; i<list.length; i++){
 			if (list != undefined && list != null && list != '' ) {
	 			str += "<option value='"+list[i].devicesid+"'>"+list[i].conname+"</option>";
 			}
 		}
		$("#connameid").append(str);
	}else{
		layer.alert("没有可选择的加油机及安全加油位，请维护！");
	}
}

//获取选中加油机的值
function initTypeCode(){
	var val = $("#connameid").find("option:selected").val();
	if(val){
		$("#xy_hidden").hide();
		var conname = $("#connameid").find("option:selected").text();
		initConnid(conname,val);
	}else{
		$("#areacode_hidden").hide();
		$("#xy_hidden").hide();
		$("#areacodeid").html("");
		$("#areacodeid").append("<option value=''>---请选择区域编号---</option>");
	}
}

//选择加油机显示当前加油机下面的未绑定摄像机的加油位
function initConnid(conname, devicesid){
	$("#areacode_hidden").show();
	var arealist = '${arealist }';
	var str = "";
	if(arealist != null && arealist != '' && arealist != undefined){
		var arealist = eval("("+arealist+")");
		for ( var i = 0; i < arealist.length; i++) {
				if(arealist[i].oilid == devicesid ){
					if( arealist[i].cameraid == "" || arealist[i].cameraid == '' || arealist[i].cameraid == undefined){
						str += "<option value='"+arealist[i].devicesareaid+"'>"+arealist[i].areacode+"</option>";
					}
				}
			}
	}else{
		layer.alert("请在加油机下维护安全加油位！");
	}
	$("#areacodeid").html("");
	$("#areacodeid").append("<option value=''>---请选择区域编号---</option>");
	$("#areacodeid").append(str);
}

//获取选中区域
function selectAreacode(){
	var val = $("#areacodeid").find("option:selected").val();
	if(val){
		var areacode = $("#areacodeid").find("option:selected").text();
		initAreaCodeid(areacode,val);
	}else{
		$("#xy_hidden").hide();
	}
}

//根据选择的区域编号展示xy数据
function initAreaCodeid(areacode,val){
	$("#xy_hidden").show();
	var devicesid = $("#connameid").find("option:selected").val();
	var arealist = '${arealist }';//已创建区域的集合
	if(arealist != null && arealist != '' && arealist != undefined){
		var arealist = eval("("+arealist+")");
		for ( var i = 0; i < arealist.length; i++) {
			if(devicesid == arealist[i].oilid && areacode == arealist[i].areacode ){//如果加油机id与区域编码找到对应的区域数据 并赋值
				$("#lefttopx").val(arealist[i].lefttopx);
				$("#lefttopy").val(arealist[i].lefttopy);
				$("#rightbottomx").val(arealist[i].rightbottomx);
				$("#rightbottomy").val(arealist[i].rightbottomy);
			}
		}
	}
}
</script>