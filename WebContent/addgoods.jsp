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
	<h1>添加商品</h1>
	<form action="${pageContext.request.contextPath }/add_addGoods.do"
		method="POST">
		<div class="sel">
			<select name="category.cateID" style="WIDTH: 180px" id="levelId">
				<option>--请选择--</option>
				<c:forEach items="${list }" var="cat">
					<option value="${cat.cateID}">${cat.cateName}</option>
				</c:forEach>
			</select>
		</div>

		<div class="sel">
			商品名称： <input name="g_name" type="text">
		</div>

		<div class="sel">
			商品价格： <input name="g_price" type="text">

		</div>

		<div class="sel">
			商品库存： <input name="stock" type="text">
		</div>

		<div class="sel">
			商品图片地址： <input name="imgurl" type="text">
		</div>

		
		<div class="sel">
		<input type="submit" value="添加" />
		</div>

	</form>

</body>
</html>