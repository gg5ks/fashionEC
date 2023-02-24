<<<<<<< HEAD
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/User_ProductDetail.css">
</head>

<body>
<!-- 表示切替用JavaScript -->
<script type="text/javascript">
function tabChange(tc){
	const tabItem = document.querySelectorAll(".tab");
	const tabContent = document.querySelectorAll(".content");
	//console.log( tc );
	for (let i = 0; i < tabItem.length; i++) {
	    tabItem[i].classList.remove("active");
	}
	for (let i = 0; i < tabContent.length; i++) {
	  tabContent[i].classList.remove("active");
	}
	// クリックしたtabに.activeを追加
	tc.classList.add("active");
	//console.log(this.classList);
	const aryTabs = Array.prototype.slice.call(tabItem);

	// 配列に格納したキーワードと最初一致したインデックスを格納
	// <li class="tab-item active">About</li>の場合は「0」が返ってくる
	const index = aryTabs.indexOf(tc);

	// インデックスに対応したtabContentに.activeを追加
	tabContent[index].classList.add("active");
}

function sizeChange(sc){
	const tabItem = document.querySelectorAll(".size");
	const tabContent = document.querySelectorAll(".amount");
	//console.log( tc );
	for (let i = 0; i < tabItem.length; i++) {
	    tabItem[i].classList.remove("active");
	}
	for (let i = 0; i < tabContent.length; i++) {
	  tabContent[i].classList.remove("active");
	}
	// クリックしたtabに.activeを追加
	sc.classList.add("active");
	//console.log(this.classList);
	const aryTabs = Array.prototype.slice.call(tabItem);

	// 配列に格納したキーワードと最初一致したインデックスを格納
	// <li class="tab-item active">About</li>の場合は「0」が返ってくる
	const index = aryTabs.indexOf(sc);

	// インデックスに対応したtabContentに.activeを追加
	tabContent[index].classList.add("active");
}
</script>

<!-- 表示HTML -->
	<div>
		<h1>商品名<%=UPMD.getMasterName() %></h1>

		<% for(String img:UPMD.getImgList()){ %>
			<p><img src="img/<%=img %>" style="width:100px; height:100px;"></p>
		<% } %>
		<p><%=UPMD.getMasterDiscript() %></p>
	</div>
<!-- 選択用 -->
	<form>
	<div>
	<p>カラー</p>
	<%for(int i=0; i< UPMD.getColorIdList().size(); i++){ %>
			<%if(i == 0){%>
			<div class="tab active" onClick="tabChange(this)">CID:<%=UPMD.getColorIdList().get(i) %></div>
			<% }else{ %>
			<div class="tab" onClick="tabChange(this)">CID:<%=UPMD.getColorIdList().get(i) %></div>
			<% } %>


			<%if(i == 0){%>
			<div class="content active" style="border:solid 1px black;">
			<p>サイズ</p>

			<%for(int s=0; s<UPMD.getListSizeAmount().get(i).size(); s++){ %>

				<%if(s == 0){%>
				<div class="size active" onClick="sizeChange(this)">
					<p><%= UPMD.getListSizeAmount().get(i).get(s).getSize() %></p>
				</div>
				<%}else{ %>
				<div class="size" onClick="sizeChange(this)">
					<p><%= UPMD.getListSizeAmount().get(i).get(s).getSize() %></p>
				</div>
				<%} %>

				<%if(s == 0){%>
				<select class="amount active">
				<% ArrayList<Integer> amount = User_ProductHelper.getInstance().AmountPullDown(UPMD.getListSizeAmount().get(i).get(s).getStock()); %>
				<%for(int t:amount){ %>
					<option value=<%=t %>><%=t %></option>
				<%} %>
				</select>

				<%}else{ %>
				<select class="amount">
				<% ArrayList<Integer> amount = User_ProductHelper.getInstance().AmountPullDown(UPMD.getListSizeAmount().get(i).get(s).getStock()); %>
				<%for(int t:amount){ %>
					<option value=<%=t %>><%=t %></option>
				<%} %>
				</select>
				<%} %>
			<% } %>
			</div>

			<% } else { %>
			<div class="content" style="border:solid 1px black;">
			<p>サイズ</p>
			<%for(int s=0; s<UPMD.getListSizeAmount().get(i).size(); s++){ %>

				<p><%= UPMD.getListSizeAmount().get(i).get(s).getSize() %></p>
				<select>
				<% ArrayList<Integer> amount = User_ProductHelper.getInstance().AmountPullDown(UPMD.getListSizeAmount().get(i).get(s).getStock()); %>
				<%for(int t:amount){ %>
					<option value=<%=t %>><%=t %></option>
				<%} %>
				</select>
			<% } %>
			</div>
			<%} %>


	<% } %>
	</div>
	</form>

</body>
