<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete book</title>
</head>
<body>
<h3>下記の内容を削除してよろしいですか？</h3>

<table border="1">
<tr><td>ID</td></tr>
<tr><td>${BookId}</td></tr>
</table>
<br><br>
<table border="1">
<tr><td>ISBN</td><td>区分コード</td><td>タイトル</td><td>著者</td><td>出版社</td>
<tr><td>${SearchedBook.isbn}</td><td>${SearchedBook.divCode}</td><td>${SearchedBook.title}</td><td>${SearchedBook.author}</td><td>${SearchedBook.publisher}</td>
</table>
<br><br>
<form action="/library/deleteBookController?action=bookDelete" method="post">
<input type="submit" value="削除する">
<input type="hidden" name="id" value="${BookId}">
</form>
</body>
</html>