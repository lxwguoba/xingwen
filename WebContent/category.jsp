<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分类</title>
</head>
<body>

	<img alt="what happen" src="https://ctwxl.com/images/m/fe7ab2383a3b4c66a0a63f5da92a8a67.jpg">
	<h1>添加分类</h1>
	<form action="${pageContext.request.contextPath }/cate_saveCate.do"
		method="POST" enctype="multipart/form-data">
		分类名称：<input name="cateName" type="text"> </br> 
		<input type="submit" value="添加" />
	</form>
</body>
</html>