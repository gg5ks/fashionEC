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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<% for(UserProductListBeans uplb:PdList){ %>
	<div style="border: solid 1px black;">
		<form action="User_ProductDetail?id=<%=uplb.getMasterId() %>" method="post"><input type="submit"></form>
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