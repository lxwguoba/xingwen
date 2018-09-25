<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询订单</title>
<link href="${pageContext.request.contextPath }/css/Style.css"
	type=text/css rel=stylesheet>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	//页面的加载
	$(function() {
		// 发送ajax的请求
		var url = "${pageContext.request.contextPath }/user_findAllUser.do";

		$.post(url, function(data) {
			// 遍历
			$(data).each(
					function(i, n) {
						$("#user_id").append(
								"<option value='"+n.u_id+"'>" + n.u_name
										+ "</option>");
					});
		}, "json");
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/upload_upheadimg.do"
		method="POST" enctype="multipart/form-data">

		<div class="sel">
			<h3>选择用户</h3>
			<select name="uid" style="WIDTH: 180px" id="user_id">
			</select>
		</div>
		
		<div class="sel">	
		<input type="file" name="upload" />
		</div>
		
		<div class="sel">
			<input type="submit" value="上传" />
		</div>
	</form>
</body>
</html>