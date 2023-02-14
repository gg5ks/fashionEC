<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jums.UserDataDTO" %>
<%
	HttpSession hs = request.getSession();
	UserDataDTO udd = (UserDataDTO)hs.getAttribute("UserExist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="User_UpdateAcount">
		ユーザー名
		<input type="text" name="name" value=<%=udd.getUser_name() %> required>
		Email
		<input type="text" name="mail" value=<%=udd.getUser_email() %> required>
		パスワード
		<input type="text" name="pass" value=<%=udd.getUser_password() %> required>
		郵便番号
		<input type="number" name="post" value=<%=udd.getUser_postid() %> required>
		住所
		<input type="text" name="address" value=<%=udd.getUser_address() %> required>
		電話番号
		<input type="text" name="tell" value=<%=udd.getUser_tell() %> required>
		<input type="submit" name="UpD" value="変更する">
	</form>
</body>
</html>