<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="java.io.*, java.util.*"%>
<%@ page import="model.Book"%>
<%@ page import="model.LoginForm"%>
<% LoginForm loginform = (LoginForm)session.getAttribute("loginform"); %>

<%
	List<Book> bookList = (List<Book>) session.getAttribute("bookList");
	List<Book> rentalBookList = (List<Book>) session.getAttribute("rentalBookList");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/bucherschrank/css/top.css">
<link rel="stylesheet" href="https://unpkg.com/picnic">
<script type="text/javascript" src="/bucherschrank/js/test.js"></script>
<title>Insert title here</title>
</head>
<body>

	adminページ こっちに本の登録削除変更検索全ての機能
	<br>
	<form action="/bucherschrank/LogoutAction" method="GET" name="form1">
		<input type="hidden" class="btn-border" value="ログアウト"> <a
			href="javascript:form1.submit()">ログアウト</a>
	</form>
	<br>
	<form action="/bucherschrank/AddBookAction" method="GET" name="form2">
		<input type="hidden" class="btn-border" value="蔵書登録"> <a
			href="javascript:form2.submit()">蔵書登録</a>
	</form>

	<br>
	<br>

	<div class="content">
		<h2 class="test">test</h2>
		<table class="primary">
			<tr>
				<th>ユーザーの本棚</th>
				<th></th>
			</tr>
			<%
				for (Book book : rentalBookList) {
			%>
			<tr>
				<td><%=book.getTitle()%></td>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<br>
		<table class="primary">
			<tr>
				<th>蔵書一覧</th>
				<th></th>
			</tr>
			<%
				for (Book book : bookList) {
			%>
			<tr>
				<td><%=book.getTitle()%></td>
				<td>
				<form action="/bucherschrank/RentBookAction" method="POST" >
				<input type="submit" class="warning" name="<%=book.getBookId()%>" value="借りる">
				</form>
				<form action="/bucherschrank/DeleteBookAction" method="GET" >
				<input type="submit" class="warning" name="<%=book.getBookId()%>" value="削除">
				</form>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>