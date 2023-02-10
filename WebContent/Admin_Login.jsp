<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession hs = request.getSession();
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="Admin_Product_Index" method="post">
		<p>メールアドレス：</p>
			<input type="text" name="mail">
		<p>パスワード：</p>
			<input type="text" name="pass">
		<br><br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>