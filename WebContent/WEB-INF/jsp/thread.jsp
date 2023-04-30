<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*" %>
<% session = request.getSession();
   String title = (String) session.getAttribute("title");
   BufferedReader br = new BufferedReader(new FileReader(title+".txt"));
   String str;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3chへようこそ</title>
</head>
<body>
<a href="/3ch/LogoutServlet">ログアウト</a><br><br>
<h1>３　ちゃ　ん　ね　る</h1>
<p><c:out value="${userId}" />さんがログイン中</p>
<br>
<c:out value="${title}" />の掲示板<br>
<form action="/3ch/MutterServlet" method="post">
<textarea name="comment" id="" cols="30" rows="10"></textarea>　<input type="submit" value="投稿"><br>
<br>
</form>
<% while((str=br.readLine())!=null){ %>
<%= str %>
<br>
<% } %>
<br><br>
<form action="/3ch/LoginServlet" method="post">
<input type="submit" value="トップへ" class="button">
</form>
</body>
</html>