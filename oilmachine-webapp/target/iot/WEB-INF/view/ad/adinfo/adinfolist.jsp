<%@ page language="java" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>

<style>
	.dataTable{
		text-align:center;
	}
	.table tr  {
		cursor:pointer;
	}
</style>

<div class="row">
	<div class="col-xs-12">
		<form id="searchForm">
		<div class="row">
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="广告名称" name="adname" id="adname">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<input type="text" class="form-control col-sm-3" placeholder="商户名称" name="buname" id="buname">
				</div>
			</div>
			<div class="col-xs-2">
				<div class="form-group">
					<select class="form-control col-sm-3" name="isuse" id="isuse">
						<option value="">---发布状态---</option>
						<option value="0">未发布</option>
						<option value="1">已发布</option>
					</select>
				</div>
			</div>
			<div class="col-xs-2">
				<span class="btn btn-sm btn-primary" onclick="query()">
				<i class="ace-icon fa fa-search align-top bigger-105"></i>
				<font>查询</font>
				</span>
			</div>
		</div>
	</form>
		<br>
		<div class="pull-left tableTools-container">
			<p>
				<span style="color: blue;font-size: 20px;">广告基本信息</span>
				<button class="btn btn-white btn-info btn-bold" onclick="add()" style="margin-left:10px">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i>
					新增
				</button>
				<button class="btn btn-white btn-warning btn-bold" onclick="main_del()" style="margin-left:10px">
					<i class="ace-icon fa fa-trash-o bigger-120 orange"></i> 
					批量删除
				</button>
				<button class="btn btn-white btn-info btn-bold" onclick="addAdtags()" style="margin-left:10px">
					<i class="ace-icon fa fa-bookmark-o bigger-120 blue"></i>
					标签
				</button>
			</p>
		</div>

		<!-- div.table-responsive -->
		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="adinfo_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="15%">广告名称</th>
						<th class="center" width="10%">失效日期</th>
						<th class="center" width="5%">发布状态</th>
						<th class="center" width="15%">商户名称</th>
						<th class="center" width="5%">播放顺序</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<hr />
<div class="row">
	<div class="col-xs-12">
		<div class="pull-left tableTools-container">
			<p>
				<span style="color: blue;font-size: 20px;">广告明细信息</span>
				<button class="btn btn-white btn-info btn-bold" onclick="add_detail()" style="margin-left:10px">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i>
					新增
				</button>
				<button class="btn btn-white btn-warning btn-bold" onclick="main_detail_del()" style="margin-left:10px">
					<i class="ace-icon fa fa-trash-o bigger-120 orange"></i> 
					批量删除
				</button>
			</p>
		</div>
		<form id="detailSearch">
			<input hidden="hidden" id="adinfoid_search" name="adinfoid">
		</form>
		<!-- div.table-responsive -->
		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="adinfo_detail_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox1" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="20%">文件名称</th>
						<th class="center" width="10%">广告类型</th>
						<th class="center" width="20%">广告地址</th>
						<th class="center" width="5%">排序</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

<div class="row" id="dialogPage" style="display:none;width:650px"></div>
<div class="row" id="dialogPage2" style="display:none;width:450px"></div>
<script>
	var adinfo_table;
	var adinfo_detail_table;
	$.fn.dataTable.ext.errMode = function(s,h,m){};
	$(document).ready(function() {
		adinfo_table = $('#adinfo_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/adinfo/adinfoList.do',
				type: 'POST',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
				pushCondition_adinfo(aoData);
			},
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			} ],
			columns : [ {
				"data" : "adinfoid"
			},{
				"data" : "adname"
			},{
				"data" : "expirydate"
			},{
				"data" : "isuse"
			}, {
				"data" : "buname"
			}, {
				"data" : "sorts"
			} ],
			"columnDefs" : [ {
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"list_checkbox\" value=\""+row.adinfoid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					var re = "未知";
					if(data == "0"){
						re = "未发布";
					}else if(data == "1"){
						re = "已发布";
					}
					return re;  
				},
				"targets" : 3,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
 					return optionBtn("'"+row.adinfoid+"'", "main_edit", "main_del");
				},
				"targets" : 6,
				"center" : "center"
			} ],
			"oLanguage" : {
				"sLengthMenu" : "每页显示 _MENU_ 条记录",
				"sZeroRecords" : "抱歉， 没有找到",
				"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				"sInfoEmpty" : "没有数据",
				"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "前一页",
					"sNext" : "后一页",
					"sLast" : "尾页"
				},
				"sZeroRecords" : "没有检索到数据",
				"sProcessing" : "<img src='./loading.gif' />"
			}
		});
		
		adinfo_detail_table = $('#adinfo_detail_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/adinfodetail/adinfodetailList.do',
				type: 'POST',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
// 				aoData.push(eval('({"name": "adinfoid", "value":"'+$("# ").val()+'"})'));
// 				eval("params.adinfoid='" + $("#searchParam_detail").val() + "'");
				pushCondition_detail(aoData);
			},
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			} ],
			columns : [ {
				"data" : "adinfodetailid"
			},{
				"data" : "filename"
			},{
				"data" : "adtype"
			}, {
				"data" : "url"
			}, {
				"data" : "sorts"
			} ],
			"columnDefs" : [ {
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"list_checkbox1\" value=\""+row.adinfodetailid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					var re = "未知";
					if(data == "0"){
						re = "视频";
					}else if(data == "1"){
						re = "图片";
					}
					return re;  
				},
				"targets" : 2,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
 					return optionBtn("'"+row.adinfodetailid+"'", "main_detail_edit", "main_detail_del");
				},
				"targets" : 5,
				"center" : "center"
			} ],
			"oLanguage" : {
				"sLengthMenu" : "每页显示 _MENU_ 条记录",
				"sZeroRecords" : "抱歉， 没有找到",
				"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
				"sInfoEmpty" : "没有数据",
				"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "前一页",
					"sNext" : "后一页",
					"sLast" : "尾页"
				},
				"sZeroRecords" : "没有检索到数据",
				"sProcessing" : "<img src='./loading.gif' />"
			}
		});
		$('#adinfo_table').on( 'click','tbody tr', function () {
			$("input[name=list_checkbox]").prop("checked", false);
			$(this).children().eq(0).children().children().prop("checked", true);
			var id = $(this).children().eq(0).children().children().val();
			$("#adinfoid_search").val(id);
			adinfo_detail_table.ajax.reload();
		});
	});

	//删除
	function main_del(ids) {
		confirmDialog("确定删除已选择广告基本信息？",function(){
			formDelte(ids ? ids : null, adinfo_table, "adinfo/delete.do", "list_checkbox",null);
		});
	}
	function main_detail_del(ids) {
		confirmDialog("确定删除已选择广告明细信息？",function(){
			formDelte(ids ? ids : null, adinfo_detail_table, "adinfodetail/delete.do", "list_checkbox1",null);
		});
	}
	// 编辑
	function main_edit(id) {
		openDialog({
			type : 1,
			title : "广告基本信息修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "adinfo/editPage.do?adinfoid="+id,
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				formOpt($('#adinfoform'), "adinfo/edit.do", adinfo_table, index, null);
			}
		});
	}
	function main_detail_edit(id) {
		openDialog({
			type : 1,
			title : "广告明细信息修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "adinfodetail/editPage.do?adinfodetailid="+id,
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				detail_edit(index);
			}
		});
	}
	function add() {
		openDialog({
			type : 1,
			title : "广告基本信息添加",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '400px' ],
			scrollbar : false,
			content : "adinfo/addPage.do",
			viewid : "dialogPage",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				formOpt($('#adinfoform'), "adinfo/add.do", adinfo_table, index, null);
			}
		});
	}
	function add_detail() {
		var ids = [];
		$("input[name='list_checkbox']").each(function() {
			if (this.checked == true) {
				ids.push($(this).val());
			}
		});
		if(ids.length != 1){
			layer.msg("请选择一条广告基本信息！");
			return;
		}else{
			openDialog({
				type : 1,
				title : "广告明细信息添加",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '650px', '400px' ],
				scrollbar : false,
				content : "adinfodetail/addPage.do",
				viewid : "dialogPage",
				btn : [ '确定', '取消' ],
				yes : function(index) {
					uploadfile(index,ids[0]);
				}
			});
		}
	}
	
	function addAdtags(){
		var ids = [];
		$("input[name='list_checkbox']").each(function() {
			if (this.checked == true) {
				ids.push($(this).val());
			}
		});
		if(ids.length != 1){
			layer.msg("请选择一条广告基本信息！");
			return;
		}else{
			openDialog({
				type : 1,
				title : "广告标签添加",
				shadeClose : false,
				maxmin : true, //开启最大化最小化按钮
				skin : 'layui-layer-rim',
				area : [ '650px', '400px' ],
				scrollbar : false,
				content : "adtags/adTagsPage.do?adinfoid="+ids[0],
				viewid : "dialogPage",
				btn : [ '确定'],
				yes : function(index) {
					layer.close(index);
				}
			});
		}
	}

	$("#main_checkbox").click(function() {
		$("input[name=list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	$("#main_checkbox1").click(function() {
		$("input[name=list_checkbox1]").prop("checked", $(this).prop("checked"));
	});
	
	function query() {
		adinfo_table.ajax.reload();
		adinfo_detail_table.ajax.reload();
	}
	
	function uploadfile(index,adinfoid){
		//上传
		var filesc =  $("#file_name")[0].files;
		 if(filesc.length == 0){
			 layer.msg('请选择文件！');
			 return false;
	     }
	     var fd = new FormData();
	     for (var i = 0; i < filesc.length; i++) {
	    	 var file = filesc[i];
	    	 fd.append("file_name",file);
	     }
		//广告基本信息
	     fd.append("adinfoid",adinfoid);
	     fd.append("filename",$("#filename").val());
	     fd.append("adtype",$("#adtype").val());
	     fd.append("sorts",$("#sorts").val());
	     adinfodetail_ajax("adinfodetail/add.do",index,adinfo_detail_table,fd);
    }
	
	function detail_edit(index){
		//上传
		var filesc =  $("#file_name")[0].files;
	     var fd = new FormData();
		 if(filesc.length != 0){
			 //修改上传文件
		     for (var i = 0; i < filesc.length; i++) { 
		    	 var file = filesc[i];
		    	 fd.append("file_name",file);
		     }
	     }
		 fd.append("adinfodetailid",$("#adinfodetailid").val());
	     fd.append("filename",$("#filename").val());
	     fd.append("adtype",$("#adtype").val());
	     fd.append("sorts",$("#sorts").val());
	     adinfodetail_ajax("adinfodetail/edit.do",index,adinfo_detail_table,fd);
	}
	function adinfodetail_ajax(func,index,grid,fd) {
		 $.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/"+func,
				cache: false, 
				data : fd,
				processData: false,  
		        contentType: false,
				success : function(re) {
					if(re != ""){
						var json = eval("(" + re + ")");
						if(json.status){
							grid.ajax.reload();
							layer.close(index);
							buttomDialog("操作成功！");
						}else{
							buttomDialog(json.msg);
						}
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					buttomDialog("操作失败");
				}
			});
	}
	function pushCondition_detail(params) {
		var t = $("#detailSearch").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
	function pushCondition_adinfo(params) {
		var t = $("#searchForm").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
</script>