<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3chへようこそ</title>
</head>
<body>
<h1>３　ちゃ　ん　ね　る</h1>
<form action="/3ch/LoginServlet" method="post">
ユーザーID:<input type="text" name="userId"><br>
パスワード:<input type="password" name="pass"><br>
<div style="text-align:center;">
<input type="submit" value="ログイン">
</div>
</form>
<c:if test="${caution1!=null }">
<div style="color: red;">ユーザー名またはパスワードが間違っています</div>
</c:if>
</body>
</html>