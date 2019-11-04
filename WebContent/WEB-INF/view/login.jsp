<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
</head>
<body>
	<form action="/bucherschrank/LoginAction" method="POST">
		<div>
			<p>ログインフォーム</p>
		</div>
		<div>
			userName:<input type="text" name="userName">
		</div>
		<div>
			password:<input type="password" name="password">
		</div>
		<div>
			<input type="submit" value="login">
		</div>
	</form>
	<br>
	<br>

	<form action="/bucherschrank/SignupAction" method="GET" name="form1">
		<input type="hidden" class="btn-border" value="ログイン"> <a
			href="javascript:form1.submit()">ユーザー登録</a>

	</form>
</body>
</html>