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
<h1>マイページ</h1>

<p>お名前：<%=udd.getUser_name() %></p>
<p>メールアドレス：<%=udd.getUser_email() %></p>
<p>郵便番号：<%=udd.getUser_postid() %></p>
<p>住所：<%=udd.getUser_address() %></p>
<p>電話番号：<%=udd.getUser_tell() %></p>

<form action="User_UpdateAcount">
<input type="submit" value="変更する">
</form>

<form action="User_QuitService">
<input type="submit" value="退会する">
</form>
</body>
</html>