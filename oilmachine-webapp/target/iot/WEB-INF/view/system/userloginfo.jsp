<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.div-inline{ display:inline} 
</style>

<div  style="width:1100px;padding-top:10px">
		<form class="form-horizontal div-inline" style="width:500px;" role="form" id="userform">
			<input type="hidden" value="${user.id}" id="id" name="id">
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">租户ID</label>
				<div class="col-sm-4">
					<input type="text"  name="tenantid" value="${user.tenantid}" placeholder="租户ID" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">用户ID</label>
				<div class="col-sm-4">
					<input type="text"  name="userid" value="${user.userid}" placeholder="用户ID" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">用户姓名</label>
				<div class="col-sm-4">
					<input type="text"  name="username" value="${user.username}" placeholder="用户姓名" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">网点名称</label>
				<div class="col-sm-4">
					<input type="text"  name="stnname" value="${user.stnname}" placeholder="网点名称" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">所属区域号</label>
				<div class="col-sm-4">
					<input type="text"  name="areacode" value="${user.areacode}" placeholder="所属区域号" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">枪号</label>
				<div class="col-sm-4">
					<input type="text"  name="nozzleno" value="${user.nozzleno}" placeholder="枪号" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">油品名称</label>
				<div class="col-sm-4">
					<input type="text"  name="oilno" value="${user.oilno}" placeholder="油品名称" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">油品价格</label>
				<div class="col-sm-4">
					<input type="text"  name="price" value="${user.price}" placeholder="油品价格" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">车辆颜色</label>
				<div class="col-sm-4">
					<input type="text"  name="carcolor" value="${user.carcolor}" placeholder="车辆颜色" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">车型</label>
				<div class="col-sm-4">
					<input type="text"  name="cartype" value="${user.cartype}" placeholder="车型" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">摄像头ID</label>
				<div class="col-sm-4">
					<input type="text"  name="cameraid" value="${user.cameraid}" placeholder="摄像头ID" class="form-control" />
				</div>
				<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">电子钱包账户标识</label>
				<div class="col-sm-4">
					<input type="text"  name="accountid" value="${user.accountid}" placeholder="电子钱包账户标识" class="form-control" />
				</div>
			</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">余额</label>
				<div class="col-sm-4">
					<input type="text"  name="amount" value="${user.amount}" placeholder="余额" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">冻结金额</label>
				<div class="col-sm-4">
					<input type="text"  name="useableamount" value="${user.useableamount}" placeholder="冻结金额" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">是否免密</label>
				<div class="col-sm-4">
					<input type="text"  name="freepword" value="${user.freepword=='0'?'不免密':'免密'}" placeholder="是否免密" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">免密金额</label>
				<div class="col-sm-4">
					<input type="text"  name="avoidamount" value="${user.avoidamount}" placeholder="免密金额" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">加油区域左上x轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="lefttopx" value="${user.lefttopx}" placeholder="加油区域左上x轴(厘米)" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">加油区域左上Y轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="lefttopy" value="${user.lefttopy}" placeholder="加油区域左上Y轴(厘米)" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">加油区域左上Y轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="rightbottomx" value="${user.rightbottomx}" placeholder="加油区域左上Y轴(厘米)" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">加油区域右下Y轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="rightbottomy" value="${user.rightbottomy}" placeholder="加油区域右下Y轴(厘米)" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">车辆左上x轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="cleft" value="${user.cleft}" placeholder="车辆左上x轴(厘米)" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">车辆左上Y轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="ctop" value="${user.ctop}" placeholder="车辆左上y轴(厘米)" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">车辆右下X轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="cright" value="${user.cright}" placeholder="车辆右下X轴(厘米)" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">车辆右下Y轴(厘米)</label>
				<div class="col-sm-4">
					<input type="text"  name="cbottom" value="${user.cbottom}" placeholder="车辆右下Y轴(厘米)" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">登录时间</label>
				<div class="col-sm-4">
					<input type="text"  name="logintime" value="${user.logintime}" placeholder="登录时间" class="form-control" />
				</div>
				<label class="col-sm-2 control-label no-padding-right" for="form-field-1-1">退出时间</label>
				<div class="col-sm-4">
					<input type="text"  name="logouttime" value="${user.logouttime}" placeholder="退出时间" class="form-control" />
				</div>
			</div>
		</form>	
	</div>