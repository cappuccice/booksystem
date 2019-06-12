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
<br>
どのIDを削除しますか。
<br>

<table border="1">
	<tr><td>ID</td></tr>
		<c:forEach items="${BookId}" var="bookid">
			<tr>
				<td>${bookid}</td>
				<td><form
						action="/library/selectBookController?action=bookDelete"
						method="post">
						<input type="submit" value="確認画面へ"><input type="hidden"
							name="deleteBookId" value="${bookid}">
					</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>