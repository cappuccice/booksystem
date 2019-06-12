<%@page import="java.util.List"%>
<%@page import="b.bean.RentalBookBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="b.bean.RentalBookBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">
<tr><td>冊数</td><td>IDコード</td></tr>
<c:forEach items="${idNum.bookStateId}" var="id" varStatus="st">
<tr>
<td>${st.count}</td><td>${id}</td>
</tr>
</c:forEach>
</table>
の返却でよろしいですか。
<form action="/library/DoneReturn" method="post">
	<input type="submit" value="確定">
</form>

</body>
</html>