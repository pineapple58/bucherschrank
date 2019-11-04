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
<title>Insert title here</title>
</head>
<body>

	みまくんぺろぺろ こっちは貸し借りのみ

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
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>