<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="User_NewAcountRegi">
		ユーザー名
		<input type="text" name="name" required>
		Email
		<input type="text" name="mail" required>
		パスワード
		<input type="text" name="pass" required>
		郵便番号
		<input type="number" name="post" required>
		住所
		<input type="text" name="address" required>
		電話番号
		<input type="text" name="tell" required>
		<input type="submit" value="新規会員登録">
	</form>
</body>
</html>