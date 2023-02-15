<%@ page
        import="javax.servlet.http.HttpSession"
		import="jums.ProductDataBeans"
		import="java.util.ArrayList" %>

<%
	HttpSession hs = request.getSession();
	ProductDataBeans pdb = (ProductDataBeans)hs.getAttribute("registerPro");
	ArrayList<ProductDataBeans> pbdList1 = (ArrayList<ProductDataBeans>)hs.getAttribute("productList1");
	ArrayList<ProductDataBeans> pbdList2 = (ArrayList<ProductDataBeans>)hs.getAttribute("productList2");
	ArrayList<ProductDataBeans> pbdList3 = (ArrayList<ProductDataBeans>)hs.getAttribute("productList3");
	ArrayList<String> imgList =(ArrayList<String>)hs.getAttribute("imgList");
	System.out.println(pbdList1.get(0).getSize());

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商品登録確認</title>
	</head>
	<body>

        <h1>商品登録確認</h1>

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
				<td><%=pbdList1.get(0).getPColor()%>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>
					<div>
					<% for(int i=0; i<pbdList1.size(); i++){ %>
						<%=pbdList1.get(i).getSize()%>
						<%=pbdList1.get(i).getStock()%> <br>
					<% } %>
					</div>
				</td>
			</tr>
		</table>

		<br><br>
		<% if  (pbdList2 !=null) {%>
		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色2</td>
				<td><%=pbdList2.get(0).getPColor()%>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>
				<% for(int i=0; i<pbdList2.size(); i++){ %>
					<%=pbdList2.get(i).getSize()%>
					<%=pbdList2.get(i).getStock()%><br>
				<% } %>
				</td>
			</tr>
		</table>

		<br><br>
		<% } %>
		<% if  (pbdList3 !=null) {%>
		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>色3</td>
				<td><%=pbdList2.get(0).getPColor()%>
				</td>
			</tr>
			<tr>
				<td>サイズ・在庫</td>
				<td>
				<% for(int i=0; i<pbdList3.size(); i++){ %>
					<%=pbdList3.get(i).getSize()%>
					<%=pbdList3.get(i).getStock()%><br>
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
					<% for(int i=0; i<imgList.size(); i++){ %>
						<img src="img/<%=imgList.get(i) %>" style="width:100px; height:100px;"><br>
					<% } %>
					</div>
				</td>
			</tr>
		</table>
		<br><br>

		<table border="1" style="border-collapse: collapse;text-align:center;">
			<tr>
				<td>公開設定</td>
				<td><% if (pdb.getPublish()==1) {
					out.print("公開");
				}else {
					out.print("非公開");
				}%>
				</td>
			</tr>
		</table>

		<input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
		<input type="submit" value="登録する">

        </form>
        <form action="Product_Register" method="POST">
            <input type="submit" value="修正する">
        </form>

    </body>
</html>