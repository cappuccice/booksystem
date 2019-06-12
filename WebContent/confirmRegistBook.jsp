<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Regist Book</title>
</head>
<body>

下記の資料を${NumberOfBook.numberOfBook}冊追加します。

<table border="1">
<tr><td>ISBN番号</td><td>${book.get(0).getIsbn()}</td></tr>
<tr><td>区分</td><td>${book.get(0).getDivCode()}</td></tr>
<tr><td>タイトル</td><td>${book.get(0).getTitle()}</td></tr>
<tr><td>著者</td><td>${book.get(0).getAuthor()}</td></tr>
<tr><td>出版社</td><td>${publishInfo.get(0).getPublisherName()}</td></tr>
<!-- <tr><td>出版日</td><td>${Book.bookinfo_date}</td></tr> -->
<%-- <tr><td>ID</td><td>${bookId.get(0).getBookId()}</td></tr> --%>
</table>



以上の内容に間違いがなければ処理を確定してください。<br>
<form action="/library/doneRegistBookController" method="post">
<input type="submit"value="確定">
</form>
<br>
間違いがあれば戻ってやり直してください。
<form action="/library/BackToInputNumberOfBook" method="post">
<input type="submit"value="戻る">
</form>

</body>
</html>