<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchBook</title>
</head>
<body>
編集画面<br>
<hr>
<br>
<form action = "/library/confirmBookController" method="post">
ISBN:<input type="text" name = "update_isbn" value="${Book.isbn}"><br>
区分コード：<input type="text" name = "update_divCode" value="${Book.divCode}"><br>
タイトル：<input type="text" name = "update_title" value="${Book.title}"><br>
著者：<input type="text" name = "update_author" value="${Book.author}"><br>
出版社：<input type="text" name = "update_publisher" value="${Book.publisher}"><br>

<br>
<input type="submit" value="確認画面へ">
<input type="hidden" name="action" value="bookUpdate">
</form>
</body>
</html>