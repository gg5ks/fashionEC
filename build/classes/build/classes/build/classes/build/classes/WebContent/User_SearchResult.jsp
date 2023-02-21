<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="jums.UserProductListBeans"
	import="java.util.*"
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


	<% for(UserProductListBeans uplb:PdList){ %>
	<div style="border: solid 1px black;">
		<form action="User_ProductDetail?id=<%=uplb.getMasterId() %>" method="get"><input type="submit"></form>
		<p><%=uplb.getMasterName() %></p>

		<p><%=uplb.getListPrice() %></p>

		<p><%=uplb.getMasterId() %></p>

		<p><%=uplb.getMasterImg() %></p>

		<p>
		<% ArrayList<Integer> color = uplb.getpColor(); %>
		<% for(int c:color){ %>
			<%=c %>
		<% } %>
		</p>

		<p>
		<% ArrayList<String> size = uplb.getSize(); %>
		<% for(String s:size){ %>
			<%=s %>
		<%} %>
		</p>
	</div>
	<%} %>

</body>
</html>