<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎您的到来</title>
</head>
<body>

	<div>
		<ul>
			<li><a href="category.jsp">添加分类</a></li>
			<li><a
				href="${pageContext.request.contextPath }/cate_findAllCat.do">添加商品</a></li>
				<li><a
				href="createorder.jsp">创建订单</a></li>
				<li><a
				href="findByOrder.jsp">查询订单</a></li>
				<li><a
				href="upload.jsp">文件上传</a></li>
						<li><a
				href="login.jsp">登录</a></li>
		</ul>
	</div>

</body>
</html>