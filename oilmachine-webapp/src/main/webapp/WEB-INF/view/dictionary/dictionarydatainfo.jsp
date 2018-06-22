<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:50px">
	<br>
		<form class="form-horizontal" role="form" id="dictionarydataform">
			<input type="hidden" id="dictId" name="dictId" value="${DictionaryData.dictId }">
			<input type="hidden" id="dictionarydataid" name="dictionarydataid" value="${DictionaryData.dictionarydataid }">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">项目编码<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" required id="itemCode" name="itemCode" value="${DictionaryData.itemCode }" placeholder="项目编码" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">项目值<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" required id="itemValue" name="itemValue" value="${DictionaryData.itemValue }" placeholder="项目编码" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">描述</label>
				<div class="col-sm-7">
					<input type="text" required id="itemName" name="itemName" placeholder="描述" value="${DictionaryData.itemName }" class="form-control" />
				</div>
			</div>
		</form>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#dictId").val(dictionary_id);
	});
</script>