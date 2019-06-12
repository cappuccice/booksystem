<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm New Book</title>
</head>
<body>

下記の資料を登録しました。
<table border="1">
<tr><td>ISBN番号</td><td>${isbn.ISBN}</td></tr>
<tr><td>区分</td><td>${NewBook.divCode}</td></tr>
<tr><td>タイトル</td><td>${NewBook.title}</td></tr>
<tr><td>著者</td><td>${NewBook.author}</td></tr>
<tr><td>出版社</td><td>${NewBook.publisherName}</td></tr>
<%-- <tr><td>出版日</td><td>${NewBook.publicationDate}</td></tr> --%>
</table>


続けて入荷冊数の登録をしてください。<br>
<form action="/library/RegistNumberOfNewBook" method="post">
<input type="submit"value="続けて入荷処理を行う">
</form>

</body>
</html>