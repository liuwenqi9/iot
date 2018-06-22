<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ewallet_ui" prefix="ew"%>

<script type="text/javascript">
	$(document).ready(function() {
		initBuInfoDetail();
	});
	
	function initBuInfoDetail(){
		var adtype = '${adInfoDetail.adtype}';
		if(adtype != null && adtype != "" && adtype != undefined){
			$("select[id='adtype'] option").each(function(i,val){
				if($(this).val() == adtype){
					$(this).attr("selected",true);
				}
			});
		}
	}
	
		
</script>
<div class="col-xs-12" class="center" style="width:100%;padding-top:50px">
		<form class="form-horizontal" method="post" role="form" id="adinfodetailform" enctype="multipart/form-data" action="${pageContext.request.contextPath}/adinfodetail/add.do">
			<input type="hidden" value="${adInfoDetail.adinfodetailid}" id="adinfodetailid" name="adinfodetailid" />
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">文件名称<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input type="text" required id="filename" name="filename" value="${adInfoDetail.filename}" placeholder="文件名称" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">文件类型<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<select id="adtype" name="adtype" class="form-control" required>
						<option value="">--请选择文件类型--</option>
						<option value="0">视频</option>
						<option value="1">图片</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">文件上传<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input  type="file" required id="file_name" name="file_name" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-1-1">文件排序<span  style='color:#ff0000'>*</span></label>
				<div class="col-sm-7">
					<input  type="text" required id="sorts" name="sorts" value="${adInfoDetail.sorts}" placeholder="文件排序" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" class="form-control" />
				</div>
			</div>
		</form>
	</div>