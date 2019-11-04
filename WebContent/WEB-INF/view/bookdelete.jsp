<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="java.io.*, java.util.*"%>
<%@ page import="model.Book"%>
<%@ page import="model.LoginForm"%>
<%@ page import="model.UserList"%>
<%
	LoginForm loginform = (LoginForm) session.getAttribute("loginform");
%>

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

</body>
</html>