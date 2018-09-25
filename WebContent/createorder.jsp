<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<title>添加商品</title>

</head>
<body>

	<img alt="what happen"
		src="https://ctwxl.com/images/m/fe7ab2383a3b4c66a0a63f5da92a8a67.jpg">
	<h1>创建订单</h1>
	<form action="${pageContext.request.contextPath }/create_createOrder.do"
		method="POST">
		<div class="sel">
			接待员： <input name="o_receptionist" type="text">
		</div>
	
		<div class="sel">
			折扣： <input name="o_discount" type="text">

		</div>

		<div class="sel">
			消费者： <input name="o_customer" type="text">
		</div>
		<div class="sel">
			数据： <input name="jsonArr" type="text">
		</div>
		<div class="sel">
		<input type="submit" value="添加" />
		</div>
	</form>

</body>
</html>