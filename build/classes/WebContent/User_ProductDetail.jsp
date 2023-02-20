<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="jums.User_ProductDetailBeans"
	import="java.util.*"
	import="jums.ProductDataDTO"
%>
<%
	HttpSession hs = request.getSession();
	User_ProductDetailBeans UPMD = (User_ProductDetailBeans)request.getAttribute("UPDB");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1><%=UPMD.getMasterName() %></h1>

	<% for(String img:UPMD.getImgList()){ %>
	<p><%=img %></p>
	<% } %>
	<p><%=UPMD.getMasterDiscript() %></p>
	</div>


	<%for(int i=0; i< UPMD.getColorIdList().size(); i++){ %>
		<div>
			<p><%=UPMD.getColorIdList().get(i) %></p>
			<%for(int s=0; s< UPMD.getListSizeAmount().get(i).size(); s++){ %>
				<p><%=UPMD.getListSizeAmount().get(i).get(s).getPColor() %></p>
				<p><%=UPMD.getListSizeAmount().get(i).get(s).getSize() %></p>

			<% } %>
		</div>
	<%} %>

</body>
</html>