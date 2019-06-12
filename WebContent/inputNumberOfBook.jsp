<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Number of Books</title>
</head>
<body>

<!-- 追加分 -->
<c:forEach items="${error}" var="e">
<big><font color="red">${e.message}</font></big>
</c:forEach><br><br>
<!-- ここまで -->

下記の資料の冊数を追加します。

<table border="1">
<tr><td>ISBN番号</td><td>${book.get(0).getIsbn()}</td></tr>
<tr><td>区分</td><td>${book.get(0).getDivCode()}</td></tr>
<tr><td>タイトル</td><td>${book.get(0).getTitle()}</td></tr>
<tr><td>著者</td><td>${book.get(0).getAuthor()}</td></tr>
<tr><td>出版社</td><td>${publishInfo.get(0).getPublisherName()}</td></tr>
<!-- <tr><td>出版日</td><td>${Book.bookinfo_date}</td></tr> -->
<%-- <tr><td>ID</td><td>${bookId.get(0).getBookId()}</td></tr> --%>
<c:forEach var="bookId" items="${bookinfoId}">
<tr><td>ID</td><td>${bookId.bookId}</td></tr>
</c:forEach>
</table>


追加する冊数を入力してください。<br>
<form action="/library/ConfirmRegistBookController" method="post">
追加数：<input type="text" name="numberOfBook" size="7">冊
<input type="submit"value="入荷確認">
</form>

</body>
</html>