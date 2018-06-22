<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/Contents/Style.css" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/JSClass/FusionCharts.js"></script>
<div align="center" id="chartdiv"> FusionCharts. </div>
<script type="text/javascript">
	var chart = new FusionCharts("${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/Charts/MSCombiDY2D.swf", "ChartId", "584", "281", "0", "0");
	chart.setDataURL("${pageContext.request.contextPath}/app/reports/chart/dashboard-blue/FusionCharts_Evaluation/Gallery/Data/Combi2DDY.xml");
	chart.render("chartdiv");
</script>
