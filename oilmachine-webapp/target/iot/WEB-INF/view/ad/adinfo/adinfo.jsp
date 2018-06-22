<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>

<div class="col-xs-12" class="center" style="width:100%;padding-top:50px">
		<form class="form-horizontal" role="form" id="adinfoform">
			<input type="hidden" value="${adInfo.adinfoid}" id="adinfoid" name="adinfoid" />
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">广告名称<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" required id="adname" name="adname" value="${adInfo.adname}" placeholder="广告名称" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">商户名称<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select id="bucode" name="bucode" class="form-control" required>
						<option value="">--请选择商户名称--</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">失效时间<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7" >
					<div class="input-group date" id="datetimepicker">
						<input type="text" id="expirydate" name="expirydate" placeholder="失效时间" class="form-control" />
						<span class="input-group-addon">  
		                    <span class="glyphicon glyphicon-calendar"></span>  
		                </span> 
	                </div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">播放顺序<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input  type="text" required id="sorts" name="sorts" value="${adInfo.sorts}" placeholder="播放顺序" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
				</div>
			</div>
		</form>
	</div>
<script type="text/javascript">
	$(document).ready(function() {
		initBuInfo();
		$("#datetimepicker").datetimepicker({
			format: 'YYYY-MM-DD hh:mm:ss',
			locale: moment.locale('zh-cn')
		});
	});
	
	//加载商户信息
	function initBuInfo(){
		var buInfo = '${buInfo}';
		var success = '${success}';
		if(success == "true"){
			var buname = '${adInfo.buname}';
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
			layer.alert(buInfo);
		}
	}
</script>