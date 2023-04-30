<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.io.*"  %>
<% String str;
   BufferedReader br = new BufferedReader(new FileReader("タイトル.txt"));%>
   <% String str1;
   BufferedReader br1 = new BufferedReader(new FileReader("サーチ.txt"));%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>３　ちゃ　ん　ね　る</title>
</head>
<body>
<a href="/3ch/LogoutServlet">ログアウト</a><br><br>
<h1>３　ちゃ　ん　ね　る</h1>
<p>ようこそ<c:out value="${userId}" />さん</p>
<br>
<form action="/3ch/ThreadServlet" method="post">
スレッド作成<br>
<input type="text" name="title">　<input type="submit" value="作成"><br><br>
</form>
<form action="/3ch/ThreadSerchSevlet" method="get">
スレッド検索<br>
<input type="text" name="title">　<input type="submit" value="検索"><br><br>
</form>
<% while(true){
	str1 = br1.readLine();
	if(str1==null)break;
	session.setAttribute("title",str1); %>
<a href = "/3ch/ThreadImportServlet?title=${title}"><%=str1 %></a>
<br>
<% } %>
スレッド一覧
<% while(true){
	str = br.readLine();
	if(str==null)break;
	session.setAttribute("title",str); %>
<a href = "/3ch/ThreadImportServlet?title=${title}"><%=str %></a>
<br>
<% } %>
</body>
</html>