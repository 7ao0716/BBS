<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3chへようこそ</title>
</head>
<body>
<h1>３　ちゃ　ん　ね　る</h1>
<form action="/3ch/RegistrationServlet" method="post">
ユーザーID:<input type="text" name="userId">（英数字のみ）<br>
パスワード:<input type="password" name="pass"><br>
<div style="text-align:center;">
<input type="submit" value="登録">
</div>
</form>
</body>
</html>