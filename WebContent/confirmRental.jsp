<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="b.bean.RentalBookBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete book</title>
</head>
<body>
	<h3>下記の内容で貸出登録してよろしいですか？</h3>

<form action="/library/DoneRental" method="post">
<br>
<%
	b.bean.RentalBookBean Infos = (b.bean.RentalBookBean)session.getAttribute("rentalInfos");
List<String> bookStateId;
String userId;
bookStateId = Infos.getBookStateId();
userId = Infos.getUserId();
%>
会員ID：
<%=userId%>
<br><br>
貸出図書：
<%=bookStateId.get(0)%>
<%=bookStateId.get(1)%>
<%=bookStateId.get(2)%>
<%=bookStateId.get(3)%>
<%=bookStateId.get(4)%>
<br><br>
<input type="submit" value="登録する">
</form>
</body>
</html>