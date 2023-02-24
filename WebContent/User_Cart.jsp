<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
	import="jums.*"
	import="java.util.*"
%>
<%
	HttpSession hs = request.getSession();
	int priceTtl = 0;
	int price = 0;
	int tax = 0;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>買い物カゴ</title>
	</head>
	<body>

		<h4>カート</h4>

		<% if (//カート配列サイズが0の時){ %>
		<h6>カートには何も入っていません。</h6>
		<%} %>

		<div style="margin-left:auto;margin-right: auto;margin-top: 10px;width: 100%;">
	        <div style=width:50%;margin-left:5%;float:left>
			<% for (int i=0; i<//カート配列サイズ; i++){ %>
		        <div style=display:flex;>
			        <div>
			        	<img src="<%= //商品の表示する画像(0番目)%>">
			        </div>
			        <div style=margin-left:10%;margin-top:5%;>
			        	商品名：<%=//商品の名前%><br>
			        	カラー：<%=//色カテゴリー＆色名前%><br>
			        	サイズ：<%=//商品のサイズ%><br>
			        	数量：
			        	<select>
			        	<%for(//在庫上限数＋最大値(&&i<5とか)){ %>
						<option value=<%=t %><% if(//for値と登録値がイコール) {out.print("selected = \"selected\"");}%>><%=t %></option>
						<%} %>
						</select><br>
						小計 :\ <%=//商品の価格(ProductsMaster)*option tのvalue%>円
							<div>

							<a href=User_CartDelete"?cart_item_id=<%= productidの番号%>>削除</a>
			       		</div>
			     	</div>
		     	</div>
			<%} %>
     		</div>

			<% if (//カート配列サイズが0ではない時){ %>
			<div class="konyu">
	     		<div>
					<% if (request.getAttribute("delete")!=null&&request.getAttribute("delete").equals("YES")){ %>
						<h6 style=color:red;>買い物カゴから1点削除しました
						</h6>
					<%} %>
					<h6 style=margin-top:50px;margin-bottom:40px;>
					アイテム数：
					<% //カート商品数;%>
					</h6>
					<h6 style=margin-top:50px;margin-bottom:40px;>
					合計金額：
					<% for (int i=0; //カート商品数; i++){
						price = Integer.parseInt(//各カート商品の金額);
						priceTtl += price;} out.print(priceTtl);%>円
					</h6>
					<h6 style=margin-top:50px;margin-bottom:40px;>
					内消費税：
					<% tax = priceTtl * 0.1;
						out.print(tax);%>円
					</h6>

      			<form action = "" method = POST>
       				<div class="submitBtn">
						<input type="hidden" name="ac"  value="">
				        <input type="submit" class="btnSubmit" name="add" value="購入手続きへ">
			        </div>
				</form>
			<%} %>
  				</div>
	     	</div>
		</div>

	</body>
</html>