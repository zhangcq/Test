<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>衡阳智慧物流系统</title>
<base href="/graduate/">
</head> 
   
 <body class="sticky-header left-side-collapsed">
    <table style="border: 1px solid black;margin: 0 auto;" cellpadding="10">
		<caption>衡阳物流园区调度单</caption>
		<tbody>
			<tr>
				<td>调度单号</td>
				<td width="200px;">${record.dispatchRecordId }</td>
				<td>订单号</td>
				<td width="200px;">${record.tradeRecordId }</td>
			</tr>
			<tr>
				<td>货主</td>
				<td>${record.thingOwner }</td>
				<td>货物类型</td>
				<td>${record.thingType }</td>
			</tr>
			<tr>
				<td>货物名称</td>
				<td>${record.thingName }</td>
				<td>车主</td>
				<td>${record.carOwner }</td>
			</tr>
			<tr>
				<td>运输公司</td>
				<td>${record.companyName }</td>
				<td>车类型</td>
				<td>${record.carType }</td>
			</tr>
			<tr>
				<td>车牌号</td>
				<td>${record.carNum }</td>
				<td>发货时间</td>
				<td>${record.sendTime }</td>
			</tr>
			<tr>
				<td>发货地</td>
				<td>${record.departure }</td>
				<td>目的地</td>
				<td>${record.destination }</td>
			</tr>
		</tbody>
	</table>
<script src="js/jquery-1.10.2.min.js"></script>  
<script type="text/javascript">
	$(function(){
		window.print();
	});
</script>
</body>
</html>