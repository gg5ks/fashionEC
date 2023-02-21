<%@ page
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="jums.ColorDataDTO"
        import="jums.ProductMasterDTO" %>

<%
	HttpSession hs = request.getSession();
	ArrayList<ColorDataDTO> cdd = (ArrayList<ColorDataDTO>)hs.getAttribute("colorList");
	ArrayList<ProductMasterDTO> pmd = (ArrayList<ProductMasterDTO>)hs.getAttribute("masterList");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品検索・一覧</title>
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

		            <h1>商品検索</h1>

		            <h3>絞り込み</h3>
					<form action = "AdminProductSearch" method = "POST">
		          		<table border="1" style="border-collapse: collapse;text-align:center;">
							<tr>
							<td>商品シリーズID</td>
							<td><select name="searchMaster">
									<option value=0>-選択する--</option>
									<% for(int i=0; i<pmd.size(); i++){ %>
									<option value="<%=pmd.get(i).getMasterId()%>"><%=pmd.get(i).getMasterId()%></option>
									<% } %>
								</select>
							</td>
							<td>商品シリーズ名</td>
							<td><input type="text" name="searchMasterName" style="width:100px;" value=""></td>
							</tr>

							<tr>
							<td>色</td>
							<td><select name="searchColor">
									<option value="">-選択する--</option>
									<% for(int i=0; i<cdd.size(); i++){ %>
									<option value="<%=cdd.get(i).getColorId()%>"><%= cdd.get(i).getColorCate()%>_<%=cdd.get(i).getColorName()%></option>
									<% } %>
								</select>
							</td>

							<td>サイズ</td>
							<td><select name="searchSize">
									<option value="">-選択する--</option>
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

							</tr>
						</table>
						<br><br>
						<input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
						<input type="submit" value="検索">
					</form>
		        </div>
		    </div>
		</div>


	</body>
</html>