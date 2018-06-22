<%@ page language="java" pageEncoding="UTF-8"%>
<style>
.dataTable{
	text-align:center;
}
</style>
<script>
	 var systemErrormsg_table;
	 $(document).ready(function() {
		initDataTable();
		initselectlogtype();
		initselectlogindex();
	 });
	 
	 function initDataTable() {
		systemErrormsg_table = $('#systemErrormsg_table').DataTable({
			ajax : {
				url : '${pageContext.request.contextPath}/home/systemErrormsglist.do',
				dataSrc : "data"
			},
			serverSide : true,
			searching : false,
			bSort : false,
			dataType : "json",
			padding : true,
			dom : '<f<t>lip>',
			fnServerParams: function (aoData) {
				pushCondition_log(aoData);
			},
			columns : [ {
				"data" : "logtype"
			}, {
				"data" : "logtype"
			}, {
				"data" : "logmodule"
			} , {
				"data" : "createdate"
			} , {
				"data" : "creator"
			} , {
				"data" : "logmsg"
			}, {
				"data" : "logmsg"
			} ],
			"columnDefs" : [ 
				 {
					"defaultContent" : "",
					"targets" : "_all"
				},{
				"render" : function(data, type, row) {
					var check = "<label class=\"pos-rel\"  class=\"center\"> <input type=\"checkbox\" class=\"ace\" name=\"syslog_list_checkbox\" value=\""+row.busisysid+"\"/> <span class=\"lbl\"></span>";
					return check;
				},
				"targets" : 0,
				"center" : "center"
			},{  
				"render" : function (data, type, row) {  
				 	if(data == 0){
						return "普通日志";
					}else if(data == 1){
						return "错误日志";
					}else{
						return data;
					}
				  },
				"targets" : 1,
				"center" : "center" 
			},{  
				"render" : function (data, type, row) {
				 	if(data == 0){
						return "摄像头采集数据日志 ";
					}else if(data == 1){
						return "用户认证日志";
					}else{
						return data;
					}
				  },
				"targets" : 2,
				"center" : "center" 
			},{  
				"render" : function (data, type, row) {  
				 	return changeDateFormat(row.createdate);  
				  },
				"targets" : 3,
				"center" : "center" 
			},{
				"render" : function(data, type, row) {
					if(data.length > 20){
						data = data.substring(0,20) +"......";
					} 
					return data;
				},
				"targets" : 5,
				"center" : "center"
			} ,{
				"render" : function(data, type, row) {
					return "<a>日志详情</a><textarea  style=\"display:none\">" +data+ "</textarea>";
				},
				"targets" : 6,
				"center" : "center",
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
		$('#systemErrormsg_table').on( 'click','tbody tr', function () {
			var logmsg = $(this).children().eq(6).text();
			$("input[name=syslog_list_checkbox]").prop("checked", false);
			$(this).children().eq(0).children().children().prop("checked", true);
			$("#myModalLabel").text(logmsg);//给弹出框赋值
			$("#myModal").modal();//弹出弹出框
		});
	}
	function pushCondition_log(params) {
		var t = $("#searchForm").serializeArray();
		$.each(t, function() {
			if(this.value != null && this.value != ""){
				eval("params." + this.name + "='" + this.value + "'");
			}
		});
	}
	
	$("#main_checkbox").click(function() {
		$("input[name=syslog_list_checkbox]").prop("checked", $(this).prop("checked"));
	});
	
	$("#querybtn").click(function() {
		if($("#selecttype").val().trim() != "" || $("#selectindex").val().trim() != ""){
			if(systemErrormsg_table){
				systemErrormsg_table.ajax.reload();
			}else{
				initDataTable();
			}
		}else{
			layer.msg("至少选择一个条件！");
			return false;
		}
 	});
 	
 	 //修改——转换日期格式(时间戳转换为datetime格式)  
        function changeDateFormat(cellval) {  
            if (cellval != null) {  
                var date = new Date(parseInt(cellval));
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;  
                var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();  
                return date.getFullYear() + "-" + month + "-" + currentDate;  
            }  
        }  
        
     function initselectlogtype(){
	 	$.ajax({
			  type: 'POST',
			  url: "${pageContext.request.contextPath}/home/dictionaryloglist.do",
			  data:{
				  'dicCode':'type_systemlog'
			  },
			  dataType: "json",
			  success:function(data){
			        var option = "";
			        for (var i = 0; i < data.length; i++) {
			          option += "<option value="+data[i].itemCode+">" + data[i].itemValue + "</option>";
			        }
			        $("#selecttype").append(option);
      			}
			});
		}
		
	function initselectlogindex(){
	 	$.ajax({
			  type: 'POST',
			  url: "${pageContext.request.contextPath}/home/dictionaryloglist.do",
			  data:{
				  'dicCode':'index_systemlog'
			  },
			  dataType: "json",
			  success:function(data){
			        var option = "";
			        for (var i = 0; i < data.length; i++) {
			          option += "<option value="+data[i].itemCode+">" + data[i].itemValue + "</option>";
			        }
			        $("#selectindex").append(option);
      			}
			});
		}
        
</script>
<div class="row">
	<div class="col-xs-12">
		<form id="searchForm">
		<div class="row">
 			<div class="col-xs-2">
				<div class="form-group">
                       <select id="selecttype" name ="logtype" class="form-control col-sm-3" > 
      						<option value="" >--请选择日志类型--</option>
      					</select>
                  </div>
			</div> 
 			<div class="col-xs-2">
				<div class="form-group">
                       <select id = "selectindex" class="form-control col-sm-3" name="logmodule"> 
      						<option value="" >--请选择日志来源--</option>
      					</select>
                  </div>
			</div>  
			<div class="col-xs-2">
					<span class="btn btn-sm btn-primary" id="querybtn">
					<i class="ace-icon fa fa-search align-top bigger-105"></i><font>搜索</font>
					</span>
				</div>
		</div>
		</form>
		</br>
		<div>
			<table id="systemErrormsg_table" class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center" width="5%">
							<label class="pos-rel"> <input type="checkbox" class="ace" id="main_checkbox" /> <span class="lbl"></span>
							</label>
						</th>
						<th class="center" width="10%">日志类型</th>
						<th class="center" width="10%">日志来源</th>
						<th class="center" width="10%">创建时间</th>
						<th class="center" width="10%">创建人</th>
						<th class="center" width="10%">日志内容</th>
						<th class="center" width="10%">详情</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
<div class="row" id="dialogPage" style="display:none" >
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
       	<div class="modal-dialog modal-lg" role="document"><!-- 中等弹出框 -->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h6 class="modal-title" id="myModalLabel">详细</h6>
                </div>
                <div class="modal-footer">
               		<button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
        	 	</div>
            </div>
        </div>
      
</div>
