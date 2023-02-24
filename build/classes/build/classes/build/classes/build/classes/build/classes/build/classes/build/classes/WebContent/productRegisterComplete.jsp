<%@ page
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"%>

<%
	HttpSession hs = request.getSession();%>

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
    <div class="split-item split-right"style="display:table-cell;position: relative; background-color:blue;width: 70%;">
        <div class="split-right__inner">

            <h1>商品検索</h1>



        </div>
    </div>
</div>
</body>
</html>