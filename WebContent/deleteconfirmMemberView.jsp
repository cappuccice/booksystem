<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>削除内容の確認</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!-- Bootstrap Javascript(jQuery含む) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>

	<h5>下記の会員情報を削除してもよろしいでしょうか？</h5>
	<form action="/library/DeleteMemberController"
		method="post">
<div class="container">
<table class="table">
<thead>
	<tr>
		<td>ユーザID</td>
		<td>名前</td>
		<td>住所</td>
		<td>電話番号</td>
		<td>メールアドレス</td>
	</tr>
</thead>
	<tbody>
				<tr>
					<td>${member.userId}</td>
					<td>${member.userName}</td>
					<td>${member.address}</td>
					<td>${member.tel}</td>
					<td>${member.email}</td>
				</tr>
	</tbody>
	</table>
	</div>
	<div class="col-5">
        <button type="submit" class="btn btn-outline-secondary btn-block">削除</button>
		<input type="hidden" name="id" value="${member.userId}">
		<input type="hidden" name="action" value="delete">
     </div>
	</form>

</body>
</html>
