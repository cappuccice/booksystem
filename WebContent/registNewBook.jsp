<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regist New Book</title>
</head>
<body>

<!-- 追加分 -->
<c:forEach items="${error}" var="e">
<big><font color="red">${e.message}</font></big><br>
</c:forEach><br><br>
<!-- ここまで -->


新規資料を追加します。<br>
資料情報を入力してください。<br>
<form action="/library/ConfirmNewBookController" method="post">
<table border="1">
<tr><td>ISBN番号</td><td>${isbn.ISBN}</td></tr>
<tr><td>区分</td><td><input type="text" name="divCode" size="15" value="${NewBook.divCode}"></td></tr>
<tr><td>タイトル</td><td><input type="text" name="title" size="15" value="${NewBook.title}"></td></tr>
<tr><td>著者</td><td><input type="text" name="author" size="15" value="${NewBook.author}"></td></tr>
<tr><td>出版社</td><td><input type="text" name="publisherName" size="15" value="${NewBook.publisherName}"></td></tr>
<!-- <tr><td>出版日</td><td><input type="text" name="publicationDate" size="15"></td></tr> -->
</table>
<br>
<input type="submit"value="確認画面へ進む">
</form>
</body>
</html>