<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>

   <form action="/bucherschrank/TopController" method="GET" name="form2">
   <input type="hidden" class="btn-border" value="Top" >
   <a href="javascript:form2.submit()">Top</a>
   </form>

   <form action="/bucherschrank/LoginAction" method="GET" name="form1">
   <input type="hidden" class="btn-border" value="ログイン" >
   <a href="javascript:form1.submit()">ログイン</a>
   </form>

      <form action="/bucherschrank/SignupAction" method="GET" name="form3">
   <input type="hidden" class="btn-border" value="新規登録" >
   <a href="javascript:form3.submit()">新規登録</a>
   </form>

</center>
</body>
</html>