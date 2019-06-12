<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete book</title>
</head>
<body>
	<h3>下記の内容で更新してよろしいですか？</h3>

	<form action="/library/updateBookController?action=bookUpdate"
		method="post">
		<table border="1">
			<tr>
				<td>ISBN</td>
				<td>区分コード</td>
				<td>タイトル</td>
				<td>著者</td>
				<td>出版社</td>
			<tr>
				<td>${book.isbn}</td>
				<td>${book.divCode}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.publisher}</td>
		</table>
		<br>
		<br> <input type="submit" value="更新する">
	</form>
	<br>
	<form action = "/library/BackToInputFormController" method="post">
		<input type="submit" value="キャンセル">
		<input type="hidden" name="action" value="bookUpdate">
	</form>
</body>
</html>