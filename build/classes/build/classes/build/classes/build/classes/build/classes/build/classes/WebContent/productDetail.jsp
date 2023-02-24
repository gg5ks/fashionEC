<%@ page
        import="javax.servlet.http.HttpSession"
		import="jums.ProductMasterDTO"
		import="java.util.ArrayList"
        import="jums.ColorDataDTO"%>

<%
	HttpSession hs = request.getSession();
	ProductMasterDTO pmd = (ProductMasterDTO)hs.getAttribute("resultMaster");
	ArrayList<ColorDataDTO> cdd = (ArrayList<ColorDataDTO>)hs.getAttribute("colorList");
	ArrayList<Integer> colorIds = (ArrayList<Integer>)hs.getAttribute("colorNum");
	ArrayList<Integer> colors = (ArrayList<Integer>)hs.getAttribute("singleColors");
	ArrayList<String> sizes1 = (ArrayList<String>)hs.getAttribute("sizes1");
	ArrayList<String> sizes2 = (ArrayList<String>)hs.getAttribute("sizes2");
	ArrayList<String> sizes3 = (ArrayList<String>)hs.getAttribute("sizes3");
	ArrayList<Integer> stocks1 = (ArrayList<Integer>)hs.getAttribute("stocks1");
	ArrayList<Integer> stocks2 = (ArrayList<Integer>)hs.getAttribute("stocks2");
	ArrayList<Integer> stocks3 = (ArrayList<Integer>)hs.getAttribute("stocks3");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録完了</title>
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
    <div class="split-item split-right"style="display:table-cell;position: relative; width: 70%;">
        <div class="split-right__inner">

            <h1>商品詳細</h1>
            <% Boolean deleteChk = pmd.getDeleteProduct();
            if (deleteChk){%>
            	<h3 style="color:red;">削除された商品です</h3>
            <%}%>
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
				<td><%= pmd.getListPrice()%>円</td>
			</tr>
			<tr>
				<td>原価</td>
				<td><%= pmd.getCost()%>円</td>
			</tr>
			<tr>
				<td>商品説明</td>
				<td><%= pmd.getProductDescript()%></td>
			</tr>
		</table>
		<br><br>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色1</td>
				<td><% int colorPrint1 = colors.get(0);
				System.out.println(colorPrint1);
								int colorIndex1 = colorIds.indexOf(colorPrint1);
								System.out.println(colorIndex1);
								int colorCate1 = cdd.get(colorIndex1).getColorCate();
								String colorName1 = cdd.get(colorIndex1).getColorName();
							out.print(colorCate1 + "_" + colorName1); %>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>
					<div>
					<% for(int i=0; i<sizes1.size(); i++){ %>
						<%=sizes1.get(i)%>
						<%=stocks1.get(i)%><br>
					<% } %>
					</div>
				</td>
			</tr>
		</table>

		<br><br>
		<% if  (sizes2 !=null) {%>
		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色2</td>
				<td><% int colorPrint2 = colors.get(1);
								int colorIndex2 = colorIds.indexOf(colorPrint2);
								int colorCate2 = cdd.get(colorIndex2).getColorCate();
								String colorName2 = cdd.get(colorIndex2).getColorName();
							out.print(colorCate2 + "_" + colorName2); %>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>
					<% for(int i=0; i<sizes2.size(); i++){ %>
						<%=sizes2.get(i)%>
						<%=stocks2.get(i)%> <br>
					<% } %>
				</td>
			</tr>
		</table>

		<br><br>
		<% } %>
		<% if  (sizes3 !=null) {%>
		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色3</td>
				<td><% int colorPrint3 = colors.get(2);
								int colorIndex3 = colorIds.indexOf(colorPrint3);
								int colorCate3 = cdd.get(colorIndex3).getColorCate();
								String colorName3 = cdd.get(colorIndex3).getColorName();
							out.print(colorCate3 + "_" + colorName3); %>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>
					<% for(int i=0; i<sizes3.size(); i++){ %>
						<%=sizes3.get(i)%>
						<%=stocks3.get(i)%> <br>
					<% } %>
				</td>
			</tr>
		</table>
		<% } %>
		<br><br>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>画像</td>
				<td>
					<div style="display:flex;">
						<img src="img/<%=pmd.getImg1() %>" style="width:100px; height:100px;"><br>
						<%if (pmd.getImg2() != null){ %>
						<img src="img/<%=pmd.getImg2() %>" style="width:100px; height:100px;"><br>
						<% } %>
						<%if (pmd.getImg3() != null){ %>
						<img src="img/<%=pmd.getImg3() %>" style="width:100px; height:100px;"><br>
						<% } %>
						<%if (pmd.getImg4() != null){ %>
						<img src="img/<%=pmd.getImg4() %>" style="width:100px; height:100px;"><br>
						<% } %>
						<%if (pmd.getImg5() != null){ %>
						<img src="img/<%=pmd.getImg5() %>" style="width:100px; height:100px;"><br>
						<% } %>
					</div>
				</td>
			</tr>
		</table>
		<br><br>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>公開設定</td>
				<td><% boolean checkP = pmd.getPublish();
								if (checkP){
								out.print("公開");
							}else {
								out.print("非公開");
							}%>
				</td>
			</tr>
		</table>
		<br><br>

        <% if (deleteChk){
        }else {%>
		<form action = "Product_DeleteConfirm" method = POST>
			<input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
			<input type="submit" value="削除する">
		</form>
		<form action = "Product_Update" method = POST>
			<input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
			<input type="submit" value="変更する">
		</form>
		<%} %>
        </div>
    </div>
</div>
</body>
</html>