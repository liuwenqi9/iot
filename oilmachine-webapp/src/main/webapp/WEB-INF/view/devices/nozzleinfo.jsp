<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:20px">
		<form class="form-horizontal" role="form" id="nozzleform">
			<input type="hidden" id="devicesid" name="devicesid" value="${Devices.devicesid }">
			    <div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">操作位号</label>
					<div class="col-sm-7">
						<input type="text" required id="areacode" name="areacode" placeholder="操作位号" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">枪号</label>
					<div class="col-sm-7">
						<input type="text" required id="nozzleno" name="nozzleno" placeholder="枪号" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
					</div>
				</div>
		</form>
	</div>
<script type="text/javascript">
$(document).ready(function() {
	$("#devicesid").val(DevicesId);
});
</script>