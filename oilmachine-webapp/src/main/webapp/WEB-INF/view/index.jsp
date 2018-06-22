<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.pcitc.oilmachine.form.UserInfo"%>
<%@page import="com.pcitc.oilmachine.commons.constant.Constant"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="include.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>加油机后台管理系统</title>
<link rel="icon" href="${pageContext.request.contextPath}/images/logo_icon.ico" type="image/x-icon"/>
<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<% 
	UserInfo userinfo = (UserInfo)session.getAttribute(Constant.SESSION_KEY);
	if(null == userinfo){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
%>
<script type="text/javascript">
	$(function() {
		Switch("home/detailpage.do", "icon-user-md", "主页面");
	});
	/**
	 * 页面跳转函数
	 * @param uri 跳转的地址
	 * @param icon 显示的图标
	 * @param title 标题
	 * @param params json参数对象
	 */
	function Switch(uri, icon, title, params) {
		$.get("${pageContext.request.contextPath}/" + uri + "?number=" + Math.random(), params, function(data, textStatus) {
			$("#main_main_menu").html("<h1>" + title + "</h1><i class='"+icon+"'></i>");
			$("#main_main_screen").html(data);
		});
		$(document).scrollTop(0);
	}
	function optionBtn(id, edit, del) {
		var btn = "";
		if (edit) {
			btn = "<div class=\"hidden-sm hidden-xs action-buttons\">" + "<a class=\"green\" href=\"javascript:;\" onclick=\"" + edit + "(" + id + ")\" ><i class=\"ace-icon fa fa-pencil bigger-130\"></i></a>";
		}
		if (del)
			btn = btn + "<a class=\"red\"  href=\"javascript:;\" onclick=\"" + del + "(" + id + ")\" ><i class=\"ace-icon fa fa-trash-o bigger-130\"></i></a>" + "</div>";
		return btn;
	}
	/**
	 * 全删除，单记录删除
	 * @param params   点击框的id
	 * @param grid  被选框的name
	 * @param url  被选框的names
	 * @param chklist  被选框的name
	 */
	function formDelte(params, grid, url, chklist, event) {
		var ids = [];
		if (params == undefined || params == null) {
			$("input[name='" + chklist + "']").each(function() {
				if (this.checked == true) {
					ids.push($(this).val());
				}
			});
		} else {
			ids.push(params);
		}
		$.ajax({
			url : '${pageContext.request.contextPath}/' + url,
			data : {
				ids : ids.join(',')
			},
			dataType : 'json',
			success : function(data) {
				//data = eval("("+data+")");
				if (event) {
					event(data);
				} else {
					var msg = "";
					if (data.status) {
						grid.ajax.reload();
						if (data.msg) {
							msg = data.msg;
						} else {
							msg = "操作成功";
						}
					} else {
						if (data.msg) {
							msg = data.msg;
						} else {
							msg = "操作失败";
						}
					}
					buttomDialog(msg);
				}
			}
		});
	}
	function loadData(url, param, func) {
		var returndata;
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "${pageContext.request.contextPath}/" + url,
			data : param ? param : {},
			async : false,
			error : function(request) {
				buttomDialog("操作失败");
			},
			success : function(data) {
				returndata = data
				if (func) {
					func(data);
				}
			}
		});
		return returndata;
	}
	function ajaxAction(url, param, grid, event) {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "${pageContext.request.contextPath}/" + url,
			data : param ? param : {},
			async : false,
			error : function(request) {
				buttomDialog("操作失败");
			},
			success : function(data) {
				data = eval("(" + data + ")");
				if (event) {
					event(data);
				} else {
					var msg = "";
					if (data.status) {
						grid.ajax.reload();
						if (data.msg) {
							msg = data.msg;
						} else {
							msg = "操作成功";
						}
						layer.close(index);
					} else {
						if (data.msg) {
							msg = data.msg;
						} else {
							msg = "操作失败";
						}
					}
					buttomDialog(msg);
				}
			}
		});
	}
	/**
	 * 表单提交操作
	 * @param obj form表单对象
	 * @param url 表单提交url
	 * @param reSubmit 防止重复提交对象
	 * @param callback 回调函数
	 */
	function formOpt(formObj, url, grid, index, event) {
		//防止重复提交
		/* if ($(reSubmit)) {
			$(reSubmit).attr('disabled', 1);
		} */
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/" + url,
			data : $(formObj).serialize(),
			async : false,
			error : function(request) {
				buttomDialog("操作失败");
			},
			success : function(data) {
				data = eval("(" + data + ")");
				if (event) {
					event(data);
				} else {
					var msg = "";
					if (data.status) {
						grid.ajax.reload();
						if (data.msg) {
							msg = data.msg;
						} else {
							msg = "操作成功";
						}
						layer.close(index);
					} else {
						if (data.msg) {
							msg = data.msg;
						} else {
							msg = "操作失败";
						}
					}
					buttomDialog(msg);
				}
			}
		});
		//	$(reSubmit).removeAttr('disabled');
	}
	function openDialog(obj) {
		var uri = "${pageContext.request.contextPath}/" + obj.content;
		obj.content = $("#" + obj.viewid + "");
		$.get(uri, null, function(data, textStatus) {
			$("#" + obj.viewid + "").html(data);
		});
		layer.open(obj);
	}
	function pushCondition(params) {
		var t = $("#searchForm").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
</script>
</head>

<body class="no-skin">
	<jsp:include page="../layout/north.jsp"></jsp:include>
	<!-- /section:basics/navbar.layout -->
	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<!-- #section:basics/sidebar -->
		<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<!-- #section:basics/sidebar.layout.shortcuts -->
					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>

					<!-- /section:basics/sidebar.layout.shortcuts -->
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span>

					<span class="btn btn-info"></span>

					<span class="btn btn-warning"></span>

					<span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- /.sidebar-shortcuts -->

			<div id="mune">
				<jsp:include page="../layout/west.jsp"></jsp:include>
			</div>
			<!-- #section:basics/sidebar.layout.minimize -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>

			<!-- /section:basics/sidebar.layout.minimize -->
		</div>

		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a></li>
						<li class="active">Dashboard</li>
					</ul>
					<!-- /.breadcrumb -->

					<!-- #section:basics/content.searchbox -->
					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->

					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<div class="page-header" id="main_main_menu">
						<h1>
							<i class="ace-icon fa fa-angle-double-right"></i> Dashboard
						</h1>
					</div>
					<!-- /.page-header -->
					<!-- /.page-header -->
					<div id="main_main_screen"></div>
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<div class="footer">
			<div class="footer-inner">
				<!-- #section:basics/footer -->
				<div class="footer-content">
					<span class="bigger-120">
						<span class="blue bolder">Ace</span>
						Application &copy; 2013-2014
					</span>
					&nbsp; &nbsp;
					<span class="action-buttons">
						<a href="#"> <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
						</a> <a href="#"> <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
						</a> <a href="#"> <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
						</a>
					</span>
				</div>
			</div>
		</div>

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document.write("<script src='${pageContext.request.contextPath}/components/js/jquery.mobile.custom.js'>" + "<"+"/script>");
	</script>
</body>
</html>
