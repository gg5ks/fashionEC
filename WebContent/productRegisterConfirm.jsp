<%@ page
        import="javax.servlet.http.HttpSession"
		import="jums.ProductDataBeans" %>

<%
	HttpSession hs = request.getSession();
	ProductDataBeans pdb = (ProductDataBeans)hs.getAttribute("registerPro");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商品登録確認</title>
	</head>
	<body>

        <h1>商品登録</h1>

		<form action = "Product_RegisterComplete" method = POST>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>商品シリーズ名</td>
				<td><%= pdb.getMasterName()%></td>
			</tr>
			<tr>
				<td>定価</td>
				<td><%= pdb.getListPrice()%>円</td>
			</tr>
			<tr>
				<td>原価</td>
				<td><%= pdb.getCost()%>円</td>
			</tr>
			<tr>
				<td>商品説明</td>
				<td><%= pdb.getProductDescript()%></td>
			</tr>
		</table>
		<br><br>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色1</td>
				<td><select name="色1リスト">
						<option value="">-選択する--</option>
						<option value="色1">色1</option>
						<option value="色2">色2</option>
						<option value="色3">色3</option>
						<option value="色4">色4</option>
						<option value="色5">色5</option>
						<option value="色6">色6</option>
						<option value="色7">色7</option>
						<option value="色8">色8</option>
						<option value="色9">色9</option>
						<option value="色10">色10</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>取り扱うサイズを選択し、在庫数を入力してください。<br>
					※F:女性サイズ　M:男性サイズ
					<div>
						<input type="checkbox" name="fs1">
						FS
						<input type="number" name="fs1stock" size=5>
						<input type="checkbox" name="ms1">
						MS
						<input type="number" name="ms1stock" size=5>
						<br>
						<input type="checkbox" name="fm1">
						FM
						<input type="number" name="fm1stock" size=5>
						<input type="checkbox" name="mm1">
						MM
						<input type="number" name="mm1stock" size=5>
						<br>
						<input type="checkbox" name="fl1">
						FL
						<input type="number" name="fl1stock" size=5>
						<input type="checkbox" name="ml1">
						ML
						<input type="number" name="ml1stock" size=5>
						<br>
						<input type="checkbox" name="fxl1">
						FXL
						<input type="number" name="fxl1stock" size=5>
						<input type="checkbox" name="mxl1">
						MXL
						<input type="number" name="mxl1stock" size=5>
						<br>
					</div>
				</td>
			</tr>
		</table>

		<br><br>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色2</td>
				<td><select name="色2リスト">
						<option value="">-選択する--</option>
						<option value="色1">色1</option>
						<option value="色2">色2</option>
						<option value="色3">色3</option>
						<option value="色4">色4</option>
						<option value="色5">色5</option>
						<option value="色6">色6</option>
						<option value="色7">色7</option>
						<option value="色8">色8</option>
						<option value="色9">色9</option>
						<option value="色10">色10</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>取り扱うサイズを選択し、在庫数を入力してください。<br>
					※F:女性サイズ　M:男性サイズ
					<div>
						<input type="checkbox" name="fs2">
						FS
						<input type="number" name="fs2stock" size=5>
						<input type="checkbox" name="ms2">
						MS
						<input type="number" name="ms2stock" size=5>
						<br>
						<input type="checkbox" name="fm2">
						FM
						<input type="number" name="fm2stock" size=5>
						<input type="checkbox" name="mm2">
						MM
						<input type="number" name="mm2stock" size=5>
						<br>
						<input type="checkbox" name="fl2">
						FL
						<input type="number" name="fl2stock" size=5>
						<input type="checkbox" name="ml2">
						ML
						<input type="number" name="ml2stock" size=5>
						<br>
						<input type="checkbox" name="fxl2">
						FXL
						<input type="number" name="fxl2stock" size=5>
						<input type="checkbox" name="mxl2">
						MXL
						<input type="number" name="mxl2stock" size=5>
						<br>
					</div>
				</td>
			</tr>
		</table>

		<br><br>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色3</td>
				<td><select name="色3リスト">
						<option value="">-選択する--</option>
						<option value="色1">色1</option>
						<option value="色2">色2</option>
						<option value="色3">色3</option>
						<option value="色4">色4</option>
						<option value="色5">色5</option>
						<option value="色6">色6</option>
						<option value="色7">色7</option>
						<option value="色8">色8</option>
						<option value="色9">色9</option>
						<option value="色10">色10</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>取り扱うサイズを選択し、在庫数を入力してください。<br>
					※F:女性サイズ　M:男性サイズ
					<div>
						<input type="checkbox" name="fs3">
						FS
						<input type="number" name="fs3stock" size=5>
						<input type="checkbox" name="ms3">
						MS
						<input type="number" name="ms3stock" size=5>
						<br>
						<input type="checkbox" name="fm3">
						FM
						<input type="number" name="fm3stock" size=5>
						<input type="checkbox" name="mm3">
						MM
						<input type="number" name="mm3stock" size=5>
						<br>
						<input type="checkbox" name="fl3">
						FL
						<input type="number" name="fl3stock" size=5>
						<input type="checkbox" name="ml3">
						ML
						<input type="number" name="ml3stock" size=5>
						<br>
						<input type="checkbox" name="fxl3">
						FXL
						<input type="number" name="fxl3stock" size=5>
						<input type="checkbox" name="mxl3">
						MXL
						<input type="number" name="mxl3stock" size=5>
						<br>
					</div>
				</td>
			</tr>
		</table>


		<input type="submit" value="登録する">

        </form>
        <form action="Product_Register" method="POST">
            <input type="submit" value="修正する">
        </form>

    </body>
</html>