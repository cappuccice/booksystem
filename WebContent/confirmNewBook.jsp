<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm New Book</title>
</head>
<body>

下記の資料を登録します。
<table border="1">
<tr><td>ISBN番号</td><td>${isbn.ISBN}</td></tr>
<tr><td>区分</td><td>${NewBook.divCode}</td></tr>
<tr><td>タイトル</td><td>${NewBook.title}</td></tr>
<tr><td>著者</td><td>${NewBook.author}</td></tr>
<tr><td>出版社</td><td>${NewBook.publisherName}</td></tr>
<%-- <tr><td>出版日</td><td>${NewBook.publicationDate}</td></tr> --%>
</table>


以上の内容に間違いがなければ登録を確定してください。<br>
<form action="/library/DoneNewBookController" method="post">
<input type="submit"value="確定">
</form>
<br>
間違いがあれば戻ってやり直してください。
<form action="/library/BackToRegistNewBook" method="post">
<input type="submit"value="戻る">
</form>

</body>
</html>