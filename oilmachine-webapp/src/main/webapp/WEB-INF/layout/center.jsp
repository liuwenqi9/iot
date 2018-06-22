<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8">
	var centerTabs;
	var tabsMenu;
	$(function() {
		tabsMenu = $('#tabsMenu').menu({
			onClick : function(item) {
				var curTabTitle = $(this).data('tabTitle');
				var type = $(item.target).attr('type');

				if (type === 'refresh') {
					refreshTab(curTabTitle);
					return;
				}

				if (type === 'close') {
					var t = centerTabs.tabs('getTab', curTabTitle);
					if (t.panel('options').closable) {
						centerTabs.tabs('close', curTabTitle);
					}
					return;
				}

				var allTabs = centerTabs.tabs('tabs');
				var closeTabsTitle = [];

				$.each(allTabs, function() {
					var opt = $(this).panel('options');
					if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
						closeTabsTitle.push(opt.title);
					} else if (opt.closable && type === 'closeAll') {
						closeTabsTitle.push(opt.title);
					}
				});

				for (var i = 0; i < closeTabsTitle.length; i++) {
					centerTabs.tabs('close', closeTabsTitle[i]);
				}
			}
		});

		centerTabs = $('#centerTabs').tabs({
			fit : true,
			border : false,
			onContextMenu : function(e, title) {
				e.preventDefault();
				tabsMenu.menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data('tabTitle', title);
			}
		});
	});
	function addTab(node) {
		var urlTarget = "tab";
		var url = "/demo/demoAction!demo.action";
		if (centerTabs.tabs('exists', node.text)) {
			centerTabs.tabs('select', node.text);
		} else {
			if ("content" == urlTarget && url.length > 0) {
				$.messager.progress({
					text : '页面加载中....',
					interval : 100
				});
				window.setTimeout(function() {
					try {
						$.messager.progress('close');
					} catch (e) {
					}
				}, 500);
				centerTabs.tabs('add', {
					title : node.text,
					closable : true,
					iconCls : node.iconCls,
					content : '<iframe src="${pageContext.request.contextPath}' + url + '" frameborder="0" style="border:0;width:100%;height:96%;"></iframe>'
				});
			} else if ("tab" == urlTarget && url.length > 0) {
				centerTabs.tabs('add', {
					title : node.text,
					href : "${pageContext.request.contextPath}" + url,
					iconCls : "icon-forum",
					closable : true
				});
			}
		}
	}
	function refreshTab(title) {
		var tab = centerTabs.tabs('getSelected');
		tab.panel('refresh');
	}
	function refreshCenterTab() {
		var centerTab = $('#centerTabs').tabs('getTab', '首页').panel('options').tab;
		centerTab.panel('refresh');
	}
</script>
<div id="centerTabs">
	<div title="首页" data-options="border:true,href:'${pageContext.request.contextPath}/layout/portal.jsp'"
		style="overflow: hidden;background-image:url(${pageContext.request.contextPath}/images/bg_bodyccaec.jpg);background-repeat:repeat;overflow:hidden;"></div>
</div>
<div id="tabsMenu" style="width: 120px;display:none;">
	<div type="refresh">刷新</div>
	<div class="menu-sep"></div>
	<div type="close">关闭</div>
	<div type="closeOther">关闭其他</div>
	<div type="closeAll">关闭所有</div>
</div>