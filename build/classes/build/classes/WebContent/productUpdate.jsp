<%@ page
        import="javax.servlet.http.HttpSession"
		import="jums.ProductMasterDTO"
		import="java.util.ArrayList"
        import="jums.ColorDataDTO"
        import="java.util.HashMap"
        import="java.util.Map" %>

<%
	HttpSession hs = request.getSession();
	ProductMasterDTO pmd = (ProductMasterDTO)hs.getAttribute("resultMaster");
	ArrayList<ColorDataDTO> cdd = (ArrayList<ColorDataDTO>)hs.getAttribute("colorList");
	ArrayList<Integer> colorIds = (ArrayList<Integer>)hs.getAttribute("colorNum");
	ArrayList<Integer> colors = (ArrayList<Integer>)hs.getAttribute("singleColors");
	ArrayList<String> sizes1 = (ArrayList<String>)hs.getAttribute("sizes1");
	ArrayList<String> sizes2 = (ArrayList<String>)hs.getAttribute("sizes2");
	ArrayList<String> sizes3 = (ArrayList<String>)hs.getAttribute("sizes3");
	Map<String,Integer> stocks1 = (Map<String,Integer>)hs.getAttribute("stocks1");
	Map<String,Integer> stocks2 = (Map<String,Integer>)hs.getAttribute("stocks2");
	Map<String,Integer> stocks3 = (Map<String,Integer>)hs.getAttribute("stocks3");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商品変更</title>
	</head>

	<body>
		<div class="split" style="display:table;">
			<div class="split-item split-left" style="display:table-cell;position: relative;width: 200px;">
				<div class="split-left__inner" style="position: fixed;">
		            <div>商品管理<br></div>
		            <div><a href="Admin_Product_Index?ac=<%= hs.getAttribute("ac")%>">商品検索</a><br></div>
		            <div><a href="Product_Register?ac=<%= hs.getAttribute("ac")%>">商品登録</a><br></div>
		            <div><a href="Order_List?ac=<%= hs.getAttribute("ac")%>">注文管理</a><br></div>
					<div><a href="Admin_Account_List?ac=<%= hs.getAttribute("ac")%>">アカウント管理</a><br></div>
					<div><a href="Admin_Login?Logout=yes">ログアウト</a></div>
        		</div>
			</div>
		    <div class="split-item split-right"style="display:table-cell;position: relative;width: 70%;">
		        <div class="split-right__inner">
			        <h1>商品変更</h1>

					<form action = "Product_Detail" method = "POST" enctype="multipart/form-data">

					<table border="1" style="border-collapse: collapse;text-align:center;">
						<tr>
							<td>商品シリーズID</td>
							<td><%= pmd.getMasterId()%></td>
						</tr>
						<tr>
							<td>商品シリーズ名</td>
							<td><%= pmd.getMasterName()%></td>
						</tr>
						<tr>
							<td>定価</td>
							<td><input type="number" name="listPrice" style="width:100px;" value="<%= pmd.getListPrice()%>" required>円</td>
						</tr>
						<tr>
							<td>原価</td>
							<td><input type="number" name="cost" style="width:100px;" value="<%= pmd.getCost()%>" required>円</td>
						</tr>
						<tr>
							<td>商品説明</td>
							<td><textarea name = "productDescript" rows = "5" cols="30" required><%= pmd.getProductDescript()%></textarea></td>
						</tr>
					</table>
					<br><br>
					<table border="1" style="border-collapse: collapse;text-align:center;">
						<tr>
							<td>色1</td>
							<td>
							<% int colorId1 = colors.get(0);%>
							<select name="productColor1">
							<option value="">-選択する--</option>
							<% for(int i=0; i<cdd.size(); i++){
								int colorOption = cdd.get(i).getColorId(); %>
								<option value="<%=colorOption%>"<% if(colorId1 == colorOption) {out.print("selected = \"selected\"");}%>><%= cdd.get(i).getColorCate()%>_<%= cdd.get(i).getColorName()%></option>
							<% } %>
							</select>
							</td>
						</tr>
						<tr>
							<td>サイズ・在庫</td>
							<td>取り扱うサイズを選択し、在庫数を入力してください。<br>
								※F:女性サイズ　M:男性サイズ
								<div>
									<input type="checkbox" name=checkbox1 value="FS"<% if(sizes1.contains("FS")) {out.print("checked = \"checked\"");}%>>
									FS
									<input type="number" name="FS1stock" size=5 value="<%=stocks1.get("FS")%>">
									<input type="checkbox" name=checkbox1 value="MS"<% if(sizes1.contains("MS")) {out.print("checked = \"checked\"");}%>>
									MS
									<input type="number" name="MS1stock" size=5 value="<%=stocks1.get("MS")%>">
									<br>
									<input type="checkbox" name=checkbox1 value="FM"<% if(sizes1.contains("FM")) {out.print("checked = \"checked\"");}%>>
									FM
									<input type="number" name="FM1stock" size=5 value="<%=stocks1.get("FM")%>">
									<input type="checkbox" name=checkbox1 value="MM"<% if(sizes1.contains("MM")) {out.print("checked = \"checked\"");}%>>
									MM
									<input type="number" name="MM1stock" size=5 value="<%=stocks1.get("MM")%>">
									<br>
									<input type="checkbox" name=checkbox1 value="FL"<% if(sizes1.contains("FL")) {out.print("checked = \"checked\"");}%>>
									FL
									<input type="number" name="FL1stock" size=5 value="<%=stocks1.get("FL")%>">
									<input type="checkbox" name=checkbox1 value="ML"<% if(sizes1.contains("ML")) {out.print("checked = \"checked\"");}%>>
									ML
									<input type="number" name="ML1stock" size=5 value="<%=stocks1.get("ML")%>">
									<br>
									<input type="checkbox" name=checkbox1 value="FXL"<% if(sizes1.contains("FXL")) {out.print("checked = \"checked\"");}%>>
									FXL
									<input type="number" name="FXL1stock" size=5 value="<%=stocks1.get("FXL")%>">
									<input type="checkbox" name=checkbox1 value="MXL"<% if(sizes1.contains("MXL")) {out.print("checked = \"checked\"");}%>>
									MXL
									<input type="number" name="MXL1stock" size=5 value="<%=stocks1.get("MXL")%>">
									<br>
								</div>
							</td>
						</tr>
					</table>
					<br><br>
					<table border="1" style="border-collapse: collapse;text-align:center;">
						<tr>
							<td>色2</td>
							<td>

							<% int colorId2 = 0;%>
							<% if  (sizes2 !=null) {
								colorId2 = colors.get(1);
							}%>

							<select name="productColor2">
							<option value="">-選択する--</option>
							<% for(int i=0; i<cdd.size(); i++){
								int colorOption = cdd.get(i).getColorId(); %>
								<option value="<%=colorOption%>"<% if(colorId2 == colorOption) {out.print("selected = \"selected\"");}%>><%= cdd.get(i).getColorCate()%>_<%= cdd.get(i).getColorName()%></option>
							<% } %>
							</select>
							</td>
						</tr>
						<tr>
							<td>サイズ・在庫</td>
							<td>取り扱うサイズを選択し、在庫数を入力してください。<br>
								※F:女性サイズ　M:男性サイズ
								<div>
									<input type="checkbox" name=checkbox2 value="FS"<% if(sizes2 !=null && sizes2.contains("FS")) {out.print("checked = \"checked\"");}%>>
									FS
									<input type="number" name="FS2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("FS");}%>">
									<input type="checkbox" name=checkbox2 value="MS"<% if(sizes2 !=null && sizes2.contains("MS")) {out.print("checked = \"checked\"");}%>>
									MS
									<input type="number" name="MS2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("MS");}%>">
									<br>
									<input type="checkbox" name=checkbox2 value="FM"<% if(sizes2 !=null && sizes2.contains("FM")) {out.print("checked = \"checked\"");}%>>
									FM
									<input type="number" name="FM2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("FM");}%>">
									<input type="checkbox" name=checkbox2 value="MM"<% if(sizes2 !=null && sizes2.contains("MM")) {out.print("checked = \"checked\"");}%>>
									MM
									<input type="number" name="MM2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("MM");}%>">
									<br>
									<input type="checkbox" name=checkbox2 value="FL"<% if(sizes2 !=null && sizes2.contains("FL")) {out.print("checked = \"checked\"");}%>>
									FL
									<input type="number" name="FL2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("FL");}%>">
									<input type="checkbox" name=checkbox2 value="ML"<% if(sizes2 !=null && sizes2.contains("ML")) {out.print("checked = \"checked\"");}%>>
									ML
									<input type="number" name="ML2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("ML");}%>">
									<br>
									<input type="checkbox" name=checkbox2 value="FXL"<% if(sizes2 !=null && sizes2.contains("FXL")) {out.print("checked = \"checked\"");}%>>
									FXL
									<input type="number" name="FXL2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("FXL");}%>">
									<input type="checkbox" name=checkbox2 value="MXL"<% if(sizes2 !=null && sizes2.contains("MXL")) {out.print("checked = \"checked\"");}%>>
									MXL
									<input type="number" name="MXL2stock" size=5 value="<% if(sizes2 !=null){stocks2.get("MXL");}%>">
									<br>
								</div>
							</td>
						</tr>
					</table>
					<br><br>
					<table border="1" style="border-collapse: collapse;text-align:center;">
						<tr>
							<td>色3</td>
							<td>
							<% int colorId3 = 0;%>
							<% if  (sizes3 !=null) {
								colorId3 = colors.get(2);
							}%>
							<select name="productColor3">
							<option value="">-選択する--</option>
							<% for(int i=0; i<cdd.size(); i++){
								int colorOption = cdd.get(i).getColorId(); %>
								<option value="<%=colorOption%>"<% if(colorId3 == colorOption) {out.print("selected = \"selected\"");}%>><%= cdd.get(i).getColorCate()%>_<%= cdd.get(i).getColorName()%></option>
							<% } %>
							</select>
							</td>
						</tr>
						<tr>
							<td>サイズ・在庫</td>
							<td>取り扱うサイズを選択し、在庫数を入力してください。<br>
								※F:女性サイズ　M:男性サイズ
								<div>
									<input type="checkbox" name=checkbox3 value="FS"<% if(sizes3 !=null && sizes3.contains("FS")) {out.print("checked = \"checked\"");}%>>
									FS
									<input type="number" name="FS3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("FS");}%>">
									<input type="checkbox" name=checkbox3 value="MS"<% if(sizes3 !=null && sizes3.contains("MS")) {out.print("checked = \"checked\"");}%>>
									MS
									<input type="number" name="MS3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("MS");}%>">
									<br>
									<input type="checkbox" name=checkbox3 value="FM"<% if(sizes3 !=null && sizes3.contains("FM")) {out.print("checked = \"checked\"");}%>>
									FM
									<input type="number" name="FM3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("FM");}%>">
									<input type="checkbox" name=checkbox3 value="MM"<% if(sizes3 !=null && sizes3.contains("MM")) {out.print("checked = \"checked\"");}%>>
									MM
									<input type="number" name="MM3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("MM");}%>">
									<br>
									<input type="checkbox" name=checkbox3 value="FL"<% if(sizes3 !=null && sizes3.contains("FL")) {out.print("checked = \"checked\"");}%>>
									FL
									<input type="number" name="FL3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("FL");}%>">
									<input type="checkbox" name=checkbox3 value="ML"<% if(sizes3 !=null && sizes3.contains("ML")) {out.print("checked = \"checked\"");}%>>
									ML
									<input type="number" name="ML3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("ML");}%>">
									<br>
									<input type="checkbox" name=checkbox3 value="FXL"<% if(sizes3 !=null && sizes3.contains("FXL")) {out.print("checked = \"checked\"");}%>>
									FXL
									<input type="number" name="FXL3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("FXL");}%>">
									<input type="checkbox" name=checkbox3 value="MXL"<% if(sizes3 !=null && sizes3.contains("MXL")) {out.print("checked = \"checked\"");}%>>
									MXL
									<input type="number" name="MXL3stock" size=5 value="<% if(sizes3 !=null){stocks3.get("MXL");}%>">
									<br>
								</div>
							</td>
						</tr>
					</table>
					<br><br>
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
							<% Boolean publishChk = pmd.getPublish(); %>
								<input type="radio" name="publish" value=0 <% if(!publishChk) {out.print("checked = \"checked\"");}%> >非公開
								<input type="radio" name="publish" value=1 <% if(publishChk) {out.print("checked = \"checked\"");}%> >公開
							</div>
							</td>
						</tr>
					</table>
					<br><br>
					<input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
					<input type="submit" value="確認画面へ">

			        </form>

			        <form action="Admin_Product_Index" method="POST">
			            <input type="submit" value="商品一覧へ">
			        </form>
				</div>
			</div>
		</div>
    </body>
</html>