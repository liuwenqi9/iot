<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
	var onlineDatagrid;
	var onlinePanel;
	var calendar;
	var userOnlineInfoDialog;
	var userOnlineInfoDataGrid;
	$(function() {
		/*calendar = $('#calendar').calendar({
			fit : true,
			current : new Date(),
			border : false,
			onSelect : function(date) {
				$(this).calendar('moveTo', new Date());
			}
		});*/

		onlinePanel = $('#onlinePanel').panel({
			tools : [ {
				iconCls : 'icon-reload',
				handler : function() {
					if (onlineDatagrid.datagrid('options').url) {
						onlineDatagrid.datagrid('load');
					}
				}
			} ]
		});

		onlineDatagrid = $('#onlineDatagrid').datagrid({
			url : '',
			title : '',
			iconCls : '',
			fit : true,
			fitColumns : true,
			pagination : false,
			pageSize : 10,
			pageList : [ 10 ],
			nowarp : false,
			border : false,
			idField : 'cid',
			sortName : 'cdatetime',
			sortOrder : 'desc',
			frozenColumns : [ [ {
				title : '编号',
				field : 'cid',
				width : 150,
				hidden : true
			} ] ],
			columns : [ [ {
				title : '名称',
				field : 'cname',
				width : 150,
				sortable : true,
				formatter : function(value, rowData, rowIndex) {
					return sys.fs('<span title="{0}">{1}</span>', value, value);
				}
			}, {
				title : '来源',
				field : 'cip',
				width : 100,
				sortable : true,
				formatter : function(value, rowData, rowIndex) {
					return sys.fs('<span title="{0}">{1}</span>', value, value);
				}
			}, {
				title : '登录时间',
				field : 'cdatetime',
				width : 150,
				sortable : true,
				formatter : function(value, rowData, rowIndex) {
					return new Date(value).format("yyyy-MM-dd hh:mm:ss");
				}
			}] ],
			onClickRow : function(rowIndex, rowData) {
				userOnlineInfoDataGrid.datagrid('loadData', [ {
					value : '登录名',
					name : rowData.cname
				}, {
					value : 'IP',
					name : rowData.cip
				}, {
					value : '登录时间',
					name : new Date(rowData.cdatetime).format("yyyy-MM-dd hh:mm:ss")
				} ]);
				userOnlineInfoDialog.dialog('open');
				$(this).datagrid('unselectAll');
			},
			onLoadSuccess : function(data) {
				onlinePanel.panel('setTitle', '( ' + data.total + ' )人在线');
			}
		});

		userOnlineInfoDialog = $('#userOnlineInfoDialog').show().dialog({
			modal : true,
			closed : true,
			title : '明细'
		});

		userOnlineInfoDataGrid = $('#userOnlineInfoDataGrid').datagrid({
			showHeader : false,
			fit : true,
			fitColumns : true,
			scrollbarSize : 0,
			border : false,
			columns : [ [ {
				title : '',
				width : 100,
				field : 'value'
			}, {
				title : '',
				width : 150,
				field : 'name'
			} ] ]
		});

	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<!--  <div data-options="region:'north',border:false" style="height:180px;overflow: hidden;">
		<div id="calendar"></div>
	</div>-->
	<div data-options="region:'center',border:false" style="overflow: hidden;background-image:url(${pageContext.request.contextPath}/images/bg_bodyccaec.jpg);background-repeat:repeat;overflow:hidden;">
		<div id="onlinePanel" data-options="fit:true,border:false" title="客户在线列表">
			<table id="onlineDatagrid"></table>
		</div>
	</div>

	<div id="userOnlineInfoDialog" style="display: none;width: 250px;height: 130px;">
		<table id="userOnlineInfoDataGrid"></table>
	</div>
</div>