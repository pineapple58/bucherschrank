<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="java.io.*, java.util.*" %>
<%@ page import="model.Book"%>

<%
List<Book> bookList = (List<Book>)request.getAttribute("bookList");
List<Book> rentalBookList = (List<Book>)request.getAttribute("rentalBookList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/bucherschrank/css/top.css">
<link rel="stylesheet" href="https://unpkg.com/picnic">

<title>Topページ</title>
</head>
<body>

	<div class="head">
<jsp:include page="/WEB-INF/view/header.jsp" flush="true" />


		<ul>
			<li>
				表示は書籍名から画像に変更するか。。。お勧め本の設定とか、読んだ本のレビュー機能とか
			</li>
		</ul>
	</div>
	<div class="content">
		<h2 class="test" >Topページ(仮) 未実装</h2>
		<table class="primary">
			<tr>
				<th>ユーザーの本棚 (ログインユーザー毎に表示切替、返す押下で本棚へ戻す)</th>
				<th></th>
			</tr>
			<% for(Book book : rentalBookList) { %>
			<tr>
				<td><%= book.getTitle() %></td>
				<td><input type="submit" class="warning" value="返す"></td>
			</tr>
			<% } %>
		</table>
		<br><br>
		<table class="primary">
			<tr>
				<th>蔵書一覧 （借りる押下でユーザーの本棚へ追加処理、表示順は検討する）</th>
				<th></th>
			</tr>
			<% for(Book book : bookList) { %>
			<tr>
				<td><%= book.getTitle() %></td>
				<td><input type="submit" class="success" value="借りる"></td>
			</tr>
			<% } %>
		</table>
	</div>
</body>
</html>