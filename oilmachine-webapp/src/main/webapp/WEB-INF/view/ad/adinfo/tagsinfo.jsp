<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:50px">
		<form class="form-horizontal" role="form" id="tagsform">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">可选标签</label>
				<div class="col-sm-7">
					<select id="select_tagname" class="form-control">
						<option value="">---选择标签---</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">标签编码<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input  type="text" required id="adtagcode" name="adtagcode" placeholder="标签编码" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">标签名称<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" required id="tagname" name="tagname" placeholder="广告名称" class="form-control" />
				</div>
			</div>
		</form>
	</div>
<script type="text/javascript">
	$(document).ready(function() {
		initTagsSelect();
	});
	function validateParams_tags(){
		var adtagcode = $("#adtagcode").val();
		var tagname = $("#tagname").val();
		if(tagname.trim() == "" && adtagcode.trim() == ""){
			alert("参数不能为空！");
			return false;
		}else{
			return true;
		}
	}
	function initTagsSelect(){
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/adtags/getAllTagsList.do",
			data : {},
			async : false,
			error : function(request) {
				buttomDialog("操作失败");
			},
			success : function(data) {
				data = eval("(" + data + ")");
				if (data.status) {
					var msg = data.msg;
					var str = "";
					for(var i=0; i < msg.length; i++){
						var obj = msg[i];
						str += "<option value='"+obj.adtagcode+"'>"+obj.tagname+"</option>";
					}
					$("#select_tagname").append(str);
					//填充select
				}else{
					buttomDialog(data.msg);
				}
			}
		});
	}
	$("#select_tagname").click(function(){
		var val = $("#select_tagname").val();
		var text = $("#select_tagname").find("option:selected").text(); 
		if(val != "" && val != undefined && val != null){
			$("#adtagcode").val(val);
			$("#tagname").val(text);
		}
	});
</script>