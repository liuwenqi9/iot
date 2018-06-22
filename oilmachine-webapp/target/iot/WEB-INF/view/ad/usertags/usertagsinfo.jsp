<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:50px">
		<form class="form-horizontal" role="form" id="usertagsform">
			<input type="hidden" id="usertagsid" name="usertagsid" value="${UserTags.usertagsid }">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">特征名称<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" id="usertagsname" name="usertagsname" placeholder="特征名称" value="${UserTags.usertagsname }" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">特征字段<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" id="usertag" name="usertag" value="${UserTags.usertag }" placeholder="特征字段" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">特征值<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" id="tagvalue" name="tagvalue" value="${UserTags.tagvalue }" placeholder="特征值" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">特征数值类型<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select id="tagvaluetype" name="tagvaluetype" class="form-control" required>
						<option value="">--请选择类型--</option>
						<option value="0">数字枚举</option>
						<option value="1">字符枚举</option>
						<option value="2">数字范围</option>
					</select>
				</div>
			</div>
		</form>
	</div>
<script type="text/javascript">
$(document).ready(function() {
	var type = '${UserTags.tagvaluetype }';
	if(type != null && type != "" && type != undefined){
		$("option[value = '" + type + "']").prop("selected", true);
	}
});
</script>