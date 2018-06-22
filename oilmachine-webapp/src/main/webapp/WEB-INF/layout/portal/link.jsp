<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/Contents/Style.css" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/JSClass/FusionCharts.js"></script>

<div id="chartdiv_bin" align="left"> </div>  
<script type="text/javascript">
	var chart = new FusionCharts("${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/Charts/Pie3D.swf", "ChartId", "365", "281", "0", "0");
	chart.setDataURL("${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/Gallery/Data/Pie3D.xml");		   
	chart.render("chartdiv_bin");
</script>