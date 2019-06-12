<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.List" %>
	<%@page import="b.bean.RentalBookBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update done!</title>
</head>
<body>
下記の内容で貸出処理が完了しました。
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
	<a href="index.html">トップページへ戻る</a>
</body>
</html>