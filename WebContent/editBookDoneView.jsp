<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update done!</title>
</head>
<body>
	<h3>下記の内容で更新を完了しました。</h3>
	<br>
	<br>
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
	<a href="index.html">トップページ</a><br>
</body>
</html>