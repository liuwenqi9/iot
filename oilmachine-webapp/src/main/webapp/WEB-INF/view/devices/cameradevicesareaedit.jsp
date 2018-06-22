<%@ page language="java" pageEncoding="UTF-8"%>
<div class="col-xs-12" class="center" style="width:100%;padding-top:20px">
		<form class="form-horizontal" role="form" id="devicesareaform">
			<input type="hidden" id="devicesareaid" name="devicesareaid" value="${DevicesArea.devicesareaid }">
			<input type="hidden" id="devicesid" name="oilid" value="${DevicesArea.oilid }">
			<div class="form-group" style="display: none;">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">加油机名称<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select required id="connameid" name="conname" onchange="initTypeCode();" class="form-control">
						<option value="${DevicesArea.oilid }">${DevicesArea.oilid }</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">区域编号（即屏幕操作位号）<span style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select id="areacodeid" name="areacode" class="form-control" required>
						<option value="${DevicesArea.areacode }">${DevicesArea.areacode }</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">左上X轴（米）</label>
				<div class="col-sm-7">
					<input type="text" required id="lefttopx" name="lefttopx" placeholder="左上X轴" value="${DevicesArea.lefttopx }" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">左上Y轴（米）</label>
				<div class="col-sm-7">
					<input type="text" required id="lefttopy" name="lefttopy" value="${DevicesArea.lefttopy }" placeholder="左上Y轴" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">右下X轴（米）</label>
				<div class="col-sm-7">
					<input type="text" required id="rightbottomx" name="rightbottomx" value="${DevicesArea.rightbottomx }" placeholder="右下X轴" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">右下Y轴（米）</label>
				<div class="col-sm-7">
					<input type="text" required id="rightbottomy" name="rightbottomy" value="${DevicesArea.rightbottomy }" placeholder="右下Y轴" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
				</div>
			</div>
		</form>
	</div>