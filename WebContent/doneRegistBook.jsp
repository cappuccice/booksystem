<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Done Regist Book</title>
</head>
<body>

下記の資料${numberOfBook.getNumberOfBook()}冊にIDを登録しました。
<table border="1">
<tr><td>ISBN番号</td><td>${book.get(0).getIsbn()}</td></tr>
<tr><td>区分</td><td>${book.get(0).getDivCode()}</td></tr>
<tr><td>タイトル</td><td>${book.get(0).getTitle()}</td></tr>
<tr><td>著者</td><td>${book.get(0).getAuthor()}</td></tr>
<tr><td>出版社</td><td>${publishInfo.get(0).getPublisherName()}</td></tr>
<!-- <tr><td>出版日</td><td>${Book.bookinfo_date}</td></tr> -->
<%-- <tr><td>ID</td><td>${bookId.get(0).getBookId()}</td></tr> --%>
</table><br>
今回登録されたIDは次の${numberOfBook.getNumberOfBook()}つです。
<table border="1">
<tr><td>ID</td></tr>
	<c:forEach items="${ID}" var="idlist">
		<tr><td>${idlist}</td></tr>
	</c:forEach>
</table>

<form action="/library/index.html" method="post">
<input type="submit"value="トップへ戻る">
</form>
</body>
</html>