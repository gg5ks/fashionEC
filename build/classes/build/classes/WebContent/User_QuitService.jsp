<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>退会確認</h1>
<p>本当に退会しますか？</p>
<form action="User_QuitService">
<input type="submit" name="quit" value="退会する">
</form>

<form action="User_MyPage">
<input type="submit" value="戻る">
</form>
</body>
</html>