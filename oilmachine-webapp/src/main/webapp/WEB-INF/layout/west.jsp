<%@ page language="java" pageEncoding="UTF-8"%>
<ul class="nav nav-list">
	<li class="active">
		<a href="${pageContext.request.contextPath}/home/index.do"> <i class="menu-icon fa fa-tachometer"></i> <span class="menu-text"> Dashboard </span></a> <b class="arrow"></b>
	</li>
	<li class="active">
		<a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-desktop"></i> <span class="menu-text">系统管理 </span> <b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b>
		<ul class="submenu">
<!-- 			<li class=""><a href="javascript:void(0)" onclick="Switch('','icon-double-angle-right','系统来源管理')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> 系统来源管理<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li> -->
<!-- 			<li class=""><a href="javascript:void(0)" onclick="Switch('','icon-double-angle-right','日志管理')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>日志管理<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li> -->
				<li class=""><a href="javascript:void(0)" onclick="Switch('dictionary/dictionaryPage.do','icon-double-angle-right','数据字典')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>数据字典<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
				<li class=""><a href="javascript:void(0)" onclick="Switch('home/userLoginInfoPage.do','icon-double-angle-right','用户登录信息')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>用户登录信息<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
				<li class=""><a href="javascript:void(0)" onclick="Switch('home/systemErrormsgPage.do','icon-double-angle-right','异常信息')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>异常信息<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
		</ul>
	</li>
	<li class="active">
		<a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-desktop"></i> <span class="menu-text">加油管理 </span> <b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b>
		<ul class="submenu">
			<li class=""><a href="javascript:void(0)" onclick="Switch('sellorder/sellOrderListPage.do','icon-double-angle-right','加油明细')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>加油明细<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
			<li class=""><a href="javascript:void(0)" onclick="Switch('gasSubscribe/gasSubscribeListPage.do','icon-double-angle-right','预约明细')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>预约明细<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
			<li class=""><a href="javascript:void(0)" onclick="Switch('gasorderrefund/gasOrderRefundListPage.do','icon-double-angle-right','退款明细')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>退款明细<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
			<li class=""><a href="javascript:void(0)" onclick="Switch('mqsendexception/mqSendExceptionListPage.do','icon-double-angle-right','MQ异常明细')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>MQ异常明细<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
		</ul>
	</li>
	<li class="active">
		<a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-desktop"></i> <span class="menu-text">广告维护 </span> <b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b>
		<ul class="submenu">
			<li class=""><a href="javascript:void(0)" onclick="Switch('adinfo/adinfoPage.do','icon-double-angle-right','广告维护')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>广告维护<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
			<li class=""><a href="javascript:void(0)" onclick="Switch('usertags/usertagsPage.do','icon-double-angle-right','用户特征维护')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>用户特征维护<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
		</ul>
	</li>
	<li class="active">
		<a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-desktop"></i> <span class="menu-text">网点运营 </span> <b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b>
		<ul class="submenu">
			<li class=""><a href="javascript:void(0)" onclick="Switch('stn/stnPage.do','icon-double-angle-right','网点运营')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>网点运营<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
		</ul>
	</li>
	<!-- <li class="">
		<a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-desktop"></i> <span class="menu-text">账户管理 </span> <b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b>
		<ul class="submenu">
			<li class=""><a href="javascript:void(0)" onclick="Switch('account/accountListPage.do','icon-double-angle-right','账户管理')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> 账户管理<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
			<li class=""><a href="javascript:void(0)" onclick="Switch('accountFlow/accountflowListPage.do','icon-double-angle-right','交易明细')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i>交易明细<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
			<li class=""><a href="javascript:void(0)" onclick="Switch('account/accountListPage.do','icon-double-angle-right','积分清零')" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> 积分清零<b class="arrow fa fa-angle-down"></b></a> <b class="arrow"></b></li>
		</ul>
	</li> -->
</ul>
<!-- /.nav-list -->
<script type="text/javascript">
	$(function() {
// 		initMenu();
	});
	
	function initMenu(){
		$.ajax({
		  	type: "POST",
		  	dataType:"json",
		  	url:"${pageContext.request.contextPath}/home/createMenu.do?time="+new Date().getTime(),
//		   	data:obj,
		  	async: false,
			 	error: function(request) {
			 	    jError("获取菜单失败!",{autoHide:false,HorizontalPosition:"center",VerticalPosition:"top",clickOverlay:true});    
			 	},
			 	success: function(data) {
			 		console.log("获取菜单返回值="+data);
			 	}
		  });
	}
</script>
