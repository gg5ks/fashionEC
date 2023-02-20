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
					<select name="color">
						<option value="0">----</option>
						<option value="1">ホワイト</option>
						<option value="2">グレー</option>
						<option value="3">ブラック</option>
						<option value="4">レッド</option>
						<option value="5">オレンジ</option>
						<option value="6">ブラウン</option>
						<option value="7">イエロー</option>
						<option value="8">グリーン</option>
						<option value="9">ブルー</option>
						<option value="10">パープル</option>
					</select>

				</td>
				<td>
					<select name="size">
						<option value="">----</option>
						<option value="FS">FS</option>
						<option value="FM">FM</option>
						<option value="FL">FL</option>
						<option value="FXL">FXL</option>
						<option value="MS">MS</option>
						<option value="MM">MM</option>
						<option value="ML">ML</option>
						<option value="MXL">MXL</option>
					</select>
				</td>
				<td>
					<select name="price">
						<option value="0">----</option>
						<option value="1">～5000円</option>
						<option value="2">5001円～10000円</option>
						<option value="3">10001円～15000円</option>
						<option value="4">15001円～20000円</option>
						<option value="5">20001円～</option>
					</select>
				</td>
			</tr>
		</table>

		<input type="submit" value="検索">
	</form>
</body>
</html>