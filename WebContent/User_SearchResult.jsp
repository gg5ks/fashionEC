<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="jums.UserProductListBeans"
	import="java.util.*"
	import="jums.*"
%>
<%
	HttpSession hs = request.getSession();
		ArrayList<UserProductListBeans> PdList = (ArrayList<UserProductListBeans>)request.getAttribute("UPLB");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%if(PdList != null) {%>
	<% for(UserProductListBeans uplb:PdList){ %>

	<div style="border: solid 1px black; position: relative; width:30%; display:inline-block;">
		<a href="User_ProductDetail?id=<%=uplb.getMasterId() %>" style="position: absolute; width:100%; height:100%;"></a>
		<img src="img/<%=uplb.getMasterImg() %>" style="width:100px; height:100px;"><br>

		<p>商品名<%=uplb.getMasterName() %></p>

		<p>サイズ：
		<% ArrayList<String> size = uplb.getSize(); %>
		<% for(String s:size){ %>
			<%=s %>
		<%} %>
		</p>

		<p>カラー：
		<%ArrayList<Integer> colorid = uplb.getpColor(); %>
		<% for(int c:colorid){ %>
		<% ColorDataDTO Color = ColorDataDAO.getInstance().UserViewColor(c); %>
			<%=Color.getColorName() %>
		<% } %>
		</p>

		<p>金額：<%=uplb.getListPrice() %></p>

	</div>

	<%} %>
<%}else{ %>
	該当の商品はありません
<%} %>

</body>
</html>