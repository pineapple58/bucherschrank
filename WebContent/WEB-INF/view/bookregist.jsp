<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.*, java.util.*"%>
<%@ page import="model.UserList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HashMap<Integer, String> userList = (HashMap<Integer, String>) request.getAttribute("userList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/bucherschrank/AddBookAction" method="POST">
		<div>
			<p>蔵書登録</p>
		</div>
		<div>
			EmpId: <select name="empId">
					<c:forEach items="${userList}" var="userList">
						<option value="${userList.key}">${userList.value}</option>
					</c:forEach>
			</select>

		</div>
		<div>
			Title:<input type="text" name="title">
		</div>
		<div>
			Summary:<input type="text" name="summary">
		</div>
		<div>
			ImageUrl:<input type="text" name="imageUrl">
		</div>
		<div>
			Price:<input type="number" name="price">
		</div>
		<div>
			<input type="submit" value="登録">
		</div>
	</form>

</body>
</html>