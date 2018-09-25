<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user_userLogin.do"
		method="POST" enctype="multipart/form-data">
		
		code：<input name="code" type="text"> </br> 
		
		nickName名称：<input name="u_name" type="text"> </br> 
		
		u_phone：<input name="u_phone" type="text"> </br> 

		u_address：<input name="u_address" type="text"> </br> 

		u_gender：<input name="u_gender" type="text"> </br> 
		u_image_url：<input name="u_image_url" type="text"> </br> 
		<input type="submit" value="添加" />
		
	</form>
</body>
</html>