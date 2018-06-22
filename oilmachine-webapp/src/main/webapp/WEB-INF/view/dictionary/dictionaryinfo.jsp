<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:50px">
		<form class="form-horizontal" role="form" id="dictionaryform">
			<input type="hidden" id="dictionaryid" name="dictionaryid" value="${Dictionary.dictionaryid }">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">字典名<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" required id="dicName" name="dicName" placeholder="字典名" value="${Dictionary.dicName }" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">字典编码<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" required id="dicCode" name="dicCode" value="${Dictionary.dicCode }" placeholder="字典编码" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">是否缓存<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select id="iscache" name="iscache" class="form-control" required>
						<option value="">--请选择是否缓存--</option>
						<option value="1">缓存</option>
						<option value="0">不缓存</option>
					</select>
				</div>
			</div>
		</form>
	</div>
<script type="text/javascript">
$(document).ready(function(){
	var iscache = '${Dictionary.iscache}';
	$("option[value='"+iscache+"']").prop("selected", true);
});
</script>