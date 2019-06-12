<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報の編集</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!-- Bootstrap Javascript(jQuery含む) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>
<h3>編集画面</h3>
会員情報を編集してください。
<hr>
<!-- 追加 -->
<c:forEach items="${error}" var="e">
<big><font color="red">${e.message}</font></big><br>
</c:forEach><br><br>
<!-- ここまで -->
<br>
<div class="row">
	<div class="col-md">
		<form action = "/library/ConfirmMemberController" method="post">
			<div class="form-group">
				<label>名前:</label>
				<input type="text" class="form-control input-sm" name = "update_userName" value="${member.userName}"><br>
				<label>住所：</label>
				<input type="text" class="form-control input-sm" name = "update_address" value="${member.address}"><br>
				<label>電話番号：</label>
				<input type="text" class="form-control input-sm"  name = "update_tel" value="${member.tel}"><br>
				<label>メールアドレス：</label>
				<input type="text" class="form-control input-sm" name = "update_email" value="${member.email}"><br>
				<label>生年月日：</label>
				<input type="text" class="form-control input-sm" name = "update_birthday" value="${member.birthday}"><br>
			</div>
<br>
<div class="col-10">
	<button type="submit" class="btn btn-outline-secondary btn-block">確認画面へ</button>
	<input type="hidden" name="action" value="update">
	<input type="hidden" name="id" value="${id}">
</div>
</form>
<hr>
</body>
</html>