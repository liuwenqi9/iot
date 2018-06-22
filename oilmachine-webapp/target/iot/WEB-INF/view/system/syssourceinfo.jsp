<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:50px">
		<form class="form-horizontal" role="form" id="syssourceform">
			<input type="hidden" value="${busiSysInfo.busisysid}" id="busisysid" name="busisysid">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">系统来源</label>
				<div class="col-sm-7">
					<input type="text" id="syssource" name="syssource" value="${busiSysInfo.syssource}" placeholder="系统来源" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">用户名</label>
				<div class="col-sm-7">
					<input type="text" id="username" name="username" value="${busiSysInfo.username}" placeholder="登录用户名" class="form-control" />
				</div>
			</div>
			<c:if test="${empty busiSysInfo.busisysid}">
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">密码</label>
					<div class="col-sm-7">
						<input type="password" id="password1" name="password1" placeholder="密码" class="form-control" />
						<input type="hidden" id="password" name="password" value="${busiSysInfo.password}" placeholder="密码" class="form-control" />
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">系统描述</label>
				<div class="col-sm-7">
					<input type="text" id="sysdesc" name="sysdesc" value="${busiSysInfo.sysdesc}" placeholder="系统描述" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">回调地址</label>
				<div class="col-sm-7">
					<input type="text" id="callbackurl" name="callbackurl" value="${busiSysInfo.callbackurl}" placeholder="回调地址" class="form-control" />
				</div>
			</div>
		</form>
	</div>