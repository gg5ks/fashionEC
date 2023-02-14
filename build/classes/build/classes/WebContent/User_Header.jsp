<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	HttpSession hs = request.getSession();
	boolean MyPageRoute = false;
	if(session.getAttribute("UserExist") != null){
		MyPageRoute = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<header>
<a href="User_TopPage.jsp">ホーム</a>
<form action="https://docs.google.com/forms/d/e/1FAIpQLSfUAK7RZ-ci003xmyYiw4UUHjLTzDmrD0HFQke6StGAPrYcFw/viewform?usp=sf_link">
<input type="submit" value="問い合わせ">
</form>

<form action="">
<input type="submit" value="検索">
</form>

<form action="">
<input type="submit" value="注文履歴">
</form>

<form action="">
<input type="submit" value="カート">
</form>

<%if(MyPageRoute){ %>
<form action="User_MyPage">
	<input type="submit" value="マイページ">
</form>
<%}else{ %>
<form action="User_Login">
	<input type="submit" value="ログイン">
</form>
<%} %>
</header>
</body>
</html>