<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="jums.*"
	import="java.util.*"
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
		<h1>商品名<%=UPMD.getMasterName() %></h1>

		<% for(String img:UPMD.getImgList()){ %>
			<p><img src="img/<%=img %>" style="width:100px; height:100px;"></p>
		<% } %>
		<p><%=UPMD.getMasterDiscript() %></p>
	</div>

	<form>
	<%for(int i=0; i< UPMD.getColorIdList().size(); i++){ %>
		<div style="border:solid 1px black;">
			<p>カラー:<%=UPMD.getColorIdList().get(i) %></p>
			<p>サイズ</p>
			<%for(int s=0; s<UPMD.getListSizeAmount().get(i).size(); s++){ %>
				<p><%= UPMD.getListSizeAmount().get(i).get(s).getSize() %></p>
				<select>
				<% ArrayList<Integer> amount = User_ProductHelper.getInstance().AmountPullDown(UPMD.getListSizeAmount().get(i).get(s).getStock()); %>
				<%for(int t:amount) %>
					<option value=<%=t %>><%=t %></option>
				<%} %>
				</select>
			<% } %>
		</div>
	<% } %>
	</form>

</body>
</html>