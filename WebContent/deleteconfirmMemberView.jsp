<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

	<h3>下記の会員情報を削除してもよろしいでしょうか？</h3>
	<h3>会員情報</h3>
	<form action="/library/DeleteMemberController"
		method="post">
		<table border="1">
			<tr>
				<td>会員ID</td>
				<td>${member.userId}</td>
			</tr>
			<tr>
				<td>名前</td>
				<td>${member.userName}</td>
			</tr>
			<tr>
				<td>住所</td>
				<td>${member.address}</td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td>${member.tel}</td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td>${member.email}</td>
			</tr>
		</table>
		<br> <input type="submit" value="削除する">
		<input type="hidden" name="id" value="${member.userId}">
		<input type="hidden" name="action" value="delete">
	</form>




</body>
</html>
