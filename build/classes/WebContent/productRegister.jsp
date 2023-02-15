<%@ page
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="jums.ColorDataDTO" %>

<%
	HttpSession hs = request.getSession();
	ArrayList<ColorDataDTO> cdd = (ArrayList<ColorDataDTO>)hs.getAttribute("colorList");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商品登録</title>
	</head>
	<body>

        <h1>商品登録</h1>

		<form action = "Product_RegisterConfirm" method = "POST" enctype="multipart/form-data">

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>商品シリーズ名</td>
				<td><input type="text" name="masterName" style="width:100px;" value="" required></td>
			</tr>
			<tr>
				<td>定価</td>
				<td><input type="number" name="listPrice" style="width:100px;" value="" required>円</td>
			</tr>
			<tr>
				<td>原価</td>
				<td><input type="number" name="cost" style="width:100px;" value="" required>円</td>
			</tr>
			<tr>
				<td>商品説明</td>
				<td><textarea name = "productDescript" rows = "5" cols="30" required></textarea></td>
			</tr>
		</table>
		<br><br>

		<% for(int i=1; i<=3; i++){ %>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色<%=i%></td>
				<td><select name="productColor<%=i%>">
						<option value="">-選択する--</option>
						<option value="<%=cdd.get(0).getColorId()%>"><%= cdd.get(0).getColorCate()%>_<%= cdd.get(0).getColorName()%></option>
						<option value="<%=cdd.get(1).getColorId()%>"><%= cdd.get(1).getColorCate()%>_<%= cdd.get(1).getColorName()%></option>
						<option value="<%=cdd.get(2).getColorId()%>"><%= cdd.get(2).getColorCate()%>_<%= cdd.get(2).getColorName()%></option>
						<option value="<%=cdd.get(3).getColorId()%>"><%= cdd.get(3).getColorCate()%>_<%= cdd.get(3).getColorName()%></option>
						<option value="<%=cdd.get(4).getColorId()%>"><%= cdd.get(4).getColorCate()%>_<%= cdd.get(4).getColorName()%></option>
						<option value="<%=cdd.get(5).getColorId()%>"><%= cdd.get(5).getColorCate()%>_<%= cdd.get(5).getColorName()%></option>
						<option value="<%=cdd.get(6).getColorId()%>"><%= cdd.get(6).getColorCate()%>_<%= cdd.get(6).getColorName()%></option>
						<option value="<%=cdd.get(7).getColorId()%>"><%= cdd.get(7).getColorCate()%>_<%= cdd.get(7).getColorName()%></option>
						<option value="<%=cdd.get(8).getColorId()%>"><%= cdd.get(8).getColorCate()%>_<%= cdd.get(8).getColorName()%></option>
						<option value="<%=cdd.get(9).getColorId()%>"><%= cdd.get(9).getColorCate()%>_<%= cdd.get(9).getColorName()%></option>
					</select>
				</td>
			</tr>

			<tr>
				<td>サイズ・在庫</td>
				<td>取り扱うサイズを選択し、在庫数を入力してください。<br>
					※F:女性サイズ　M:男性サイズ
					<div>
						<input type="checkbox" name=checkbox<%=i%> value="FS">
						FS
						<input type="number" name="FS<%=i%>stock" size=5>
						<input type="checkbox" name=checkbox<%=i%> value="MS">
						MS
						<input type="number" name="MS<%=i%>stock" size=5>
						<br>
						<input type="checkbox" name=checkbox<%=i%> value="FM">
						FM
						<input type="number" name="FM<%=i%>stock" size=5>
						<input type="checkbox" name=checkbox<%=i%> value="MM">
						MM
						<input type="number" name="MM<%=i%>stock" size=5>
						<br>
						<input type="checkbox" name=checkbox<%=i%> value="FL">
						FL
						<input type="number" name="FL<%=i%>stock" size=5>
						<input type="checkbox" name=checkbox<%=i%> value="ML">
						ML
						<input type="number" name="ML<%=i%>stock" size=5>
						<br>
						<input type="checkbox" name=checkbox<%=i%> value="FXL">
						FXL
						<input type="number" name="FXL<%=i%>stock" size=5>
						<input type="checkbox" name=checkbox<%=i%> value="MXL">
						MXL
						<input type="number" name="MXL<%=i%>stock" size=5>
						<br>
					</div>
				</td>
			</tr>
		</table>
		<br><br>
<% } %>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<% for(int i=1; i<=5; i++){ %>
			<tr>
				<td>画像<%=i%></td>
				<td><input type="file" name="img<%=i%>"><br></td>
			</tr>
			<% } %>
		</table>
		<br><br>
		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>公開設定</td>
				<td>
				<div>
					<input type="radio" name="publish" value=0 checked="checked" >非公開
					<input type="radio" name="publish" value=1>公開
				</div>
				</td>
			</tr>
		</table>
		<br><br>
		<input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
		<input type="submit" value="確認画面へ">

        </form>

        <form action="Admin_Login" method="POST">
            <input type="submit" value="商品一覧へ">
        </form>

    </body>
</html>