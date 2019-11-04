<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/bucherschrank/SignupAction" method="POST">
		<div>
			<p>新規登録</p>
		</div>
		<div>
			empId:<input type="number" name="empId">
		</div>
		<div>
			userName:<input type="text" name="userName">
		</div>
		<div>
			password:<input type="password" name="password">
		</div>
		<div>
			mailAdress:<input type="text" name="adress">
		</div>
		<div>
			<input type="submit" value="登録">
		</div>
	</form>
</body>
</html>