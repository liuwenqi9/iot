<%@ page language="java" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="zh_CN">
<head>
<meta charset="UTF-8">
<title>加油机系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="assets/css/login_style.css" media="screen" type="text/css" />
<script type="text/javascript" src="components/js/jquery.js"></script>
<!--表单验证-->
<script src="plug/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="plug/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<link rel="stylesheet" href="assets/css/bootstrap.css" />
<script src="components/js/bootstrap.js"></script>
<script src="jslib/md5.js"></script>

<script>
$(function() {
	$("#username").focus();
});
$(document).keydown(function(event) {
	if (event.keyCode == 13) {
		gotoLogin();
	}
});
//登陆
function gotoLogin() {
	var username = $("#username").val();
	var password = $("#password").val();
	if (username != '' && password != '' && null != username && username != "" && null != password && password != "") {
		$.ajax({
	          type: 'POST',
	          dataType:'json',
	          url: "${pageContext.request.contextPath}/home/doLogin.do?username="+username+"&password="+password,
	          success: function (value){
	        	  var error = value.error;
	        	  if(error){
	        		  alert(error);
	        	  }else{
	        		  location.href = "${pageContext.request.contextPath}/home/index.do";
	        	  }
	          },
	          error:function(){
	              alert("服务器异常！");
	          } 
          });
	} else {
		if (username == '' || null == username || username == "") {
			$("#username").focus();
		} else if (password == '' || null == password || password == "") {
			$("#password").focus();
		}
	}

}

function register() {
	alert("即将发布...");
}
</script>
</head>
<body>
  <form action="#" class="logForm">
	<div class="login">
		<div class="input">
			<input class="username" type="text" id="username" name="username" placeholder="账号">
			<input class="password" type="password" id="password" name="password" placeholder="密码">


			<div class="set">
				<a href="#" class="a">忘记密码?</a>
			</div>
		</div>
		<div style="clear:both;"></div>
		<div class="btn">
			<a href="javascript:void(0);" onclick="gotoLogin();" class="in"></a>
		</div>
	</div>
  </form>
</body>
</html>
