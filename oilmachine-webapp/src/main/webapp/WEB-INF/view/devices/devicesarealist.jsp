<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	var devicesarea_table;
	$(document).ready(function() {
		$("#search_devicesid").val(DevicesId);
		devicesarea_table = $('#devicesarea_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/devicesarea/devicesareaList.do?oilid='+DevicesId,
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
				pushCondition_area(aoData);
			},
			columns : [ {
				"data" : "devicesareaid"
			}, {
				"data" : "areacode"
			}, {
				"data" : "lefttopx"
			}, {
				"data" : "lefttopy"
			}, {
				"data" : "rightbottomx"
			}, {
				"data" : "rightbottomy"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"area_checkbox\" value=\""+row.devicesareaid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			}, {
				"render" : function(data, type, row) {
					return optionBtn("'"+row.devicesareaid+"'", "area_edit", "area_del");
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
	});
	function pushCondition_area(params) {
		var t = $("#areaSearch").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
	function query() {
		devicesarea_table.ajax.reload();
	}
	function area_del(id) {
		confirmDialog("确定删除已选择信息？",function(){
			formDelte(id?id:null, devicesarea_table, "devicesarea/delete.do", "area_checkbox");
		});
	}
	function area_add() {
		openDialog({
			type : 1,
			title : "设备区域添加",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '420px' ],
			scrollbar : false,
			content : "devicesarea/addPage.do?oilid="+DevicesId,
			viewid : "dialogPage3",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				/* var boo = validate_devicesareaform();
				if(boo){
					
				} */
				formOpt($('#devicesareaform'), "devicesarea/add.do?devicetypecode=001&deviceid="+DevicesId, devicesarea_table, index, null);
			}
		});
	}
	function area_edit(id) {
		openDialog({
			type : 1,
			title : "设备区域修改",
			shadeClose : false,
			maxmin : true, //开启最大化最小化按钮
			skin : 'layui-layer-rim',
			area : [ '650px', '420px' ],
			scrollbar : false,
			content : "devicesarea/editPage.do?devicesareaid="+id+"&oilid="+DevicesId,
			viewid : "dialogPage3",
			btn : [ '确定', '取消' ],
			yes : function(index) {
				var boo = validate_devicesareaform();
				if(boo){
					formOpt($('#devicesareaform'), "devicesarea/edit.do", devicesarea_table, index, null);
				}
			}
		});
	}
	$("#area_checkbox").click(function() {
		$("input[name=area_checkbox]").prop("checked", $(this).prop("checked"));
	});
	function validate_devicesareaform(){
		if($("#areacode").val().trim() == ""){
			layer.msg("区域编号不能为空！");
			return false;
		}
		if($("#lefttopx").val().trim() == ""){
			layer.msg("左上X轴不能为空！");
			return false;
		}
		if($("#lefttopy").val().trim() == ""){
			layer.msg("左上Y轴不能为空！");
			return false;
		}
		if($("#rightbottomx").val().trim() == ""){
			layer.msg("右下X轴不能为空！");
			return false;
		}
		if($("#rightbottomy").val().trim() == ""){
			layer.msg("右下Y轴不能为空！");
			return false;
		}
		return true;
	}
</script>
<div class="row">
	<div class="col-xs-12">
		<form id="areaSearch" style="display: none;">
			<input hidden="hidden" id="search_devicesid" name="devicesid">
		</form>
		<div class="pull-left tableTools-container" style="padding-left:20px">
			<p>
				<button class="btn btn-white btn-info btn-bold" onclick="area_add()">
					<i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> 添加
				</button>
			</p>
		</div>

		<!-- div.table-responsive -->

		<!-- div.dataTables_borderWrap -->
		<div>
			<table id="devicesarea_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="area_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">区域编号</th>
						<th class="center" width="10%">左上x轴(米)</th>
						<th class="center" width="10%">左上Y轴(米)</th>
						<th class="center" width="10%">右下X轴(米)</th>
						<th class="center" width="10%">右下Y轴(米)</th>
						<th class="center" width="8%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>

