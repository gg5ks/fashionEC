<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean error_flag = false;
	if((String)request.getAttribute("error") != null){
		error_flag = true;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(error_flag){out.print("<p>ログインエラーが発生しました</p>");} %>
	<h1>ログイン</h1>
	<form action="User_Login_Judge" method="post">
		<p>メールアドレス：</p>
			<input type="text" name="mail">
		<p>パスワード：</p>
			<input type="text" name="pass">
		<br><br>
		<input type="submit" value="ログイン">
	</form>

	<form action="User_NewAcount">
		<input type="submit" value="新規会員登録はこちら！">
	</form>
</body>
</html>