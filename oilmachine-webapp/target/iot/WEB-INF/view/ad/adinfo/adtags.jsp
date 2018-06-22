<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>

<script type="text/javascript">
	var adtags_table;
	$.fn.dataTable.ext.errMode = function(s,h,m){};
	$(document).ready(function() {
		var adinfoid = '${adinfoid}';
		$("#adinfoid").val(adinfoid);
		adtags_table = $('#adtags_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/adtags/adtagsList.do',
				type: 'POST',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>>',
			fnServerParams: function (aoData) {
				pushCondition_tags(aoData);
			},
			columnDefs : [ {
				"defaultContent" : "",
				"targets" : "_all"
			} ],
			columns : [ {
				"data" : "tagname"
			},{
				"data" : "adtagcode"
			} ],
			"columnDefs" : [ {
				"render" : function(data, type, row) {
					return optionBtn("'"+row.adtagsid+"'", false , "main_tags_del");
				},
				"targets" : 2,
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
	});
	// 新建
	function add_tags() {
		openDialog({
			type : 1,
			title : "标签添加",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '450px', '340px' ],
			scrollbar : false,
			content : "adtags/addPage.do",
			viewid : "dialogPage2",
			btn : [ '确定', '取消' ],
			yes : function(index2) {
				var boo = validateParams_tags();
				if(boo){
					var adinfoid = $("input[name='list_checkbox']:checked").val();
					var adtagcode = $("#adtagcode").val();
					var tagname = $("#tagname").val();
					var params = {
							"adinfoid":adinfoid,
							"adtagcode":adtagcode,
							"tagname":tagname
					}
					formOption(params, "adtags/addtags.do", adtags_table, index2, null);
				}
			}
		});
	}
	function formOption(params, url, grid, index2, event){
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/" + url,
			data : params,
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
						layer.close(index2);
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
	function pushCondition_tags(params) {
		var t = $("#tags_search").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
	function main_tags_del(ids) {
		confirmDialog("确定删除已选择标签？",function(){
			formDelte(ids ? ids : null, adtags_table, "adtags/delete.do", null,null);
		});
	}
	
</script>
<div class="row" style="margin: 0px 10px 10px 10px;">
	<form id="tags_search">
		<input hidden="hidden" name="adinfoid" id="adinfoid">
	</form>
	<div class="col-xs-12">
		<br>
		<div class="pull-left tableTools-container" style="padding-left:20px">
			<p>
				<button class="btn btn-white btn-info btn-bold" onclick="add_tags()">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i>
					新增
				</button>
			</p>
		</div>
		<!-- div.table-responsive -->
		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="adtags_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="20%">标签名称</th>
						<th class="center" width="20%">标签编码</th>
						<th class="center" width="10%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>