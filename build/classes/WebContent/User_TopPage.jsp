<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="User_Header.jsp" %>
		Hello!FashionEC!!
	<form action="User_Login">
		<input type="submit" value="ログイン">
	</form>

	<form action="User_SearchResult">
		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>キーワード</td>
				<td>色</td>
				<td>サイズ</td>
				<td>価格</td>
			</tr>

			<tr>
				<td>
					<input type="text" name="keyword">
				</td>

				<td>
					<select>
						<option>----</option>
					</select>
				</td>
				<td>
					<select>
						<option>----</option>
					</select>
				</td>
				<td>
					<select>
						<option>----</option>
					</select>
				</td>
			</tr>
		</table>

		<input type="submit" value="検索">
	</form>
</body>
</html>