<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>図書管理システム</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<!-- Bootstrap Javascript(jQuery含む) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>

<!-- 追加分 -->
<c:forEach items="${error}" var="e">
<big><font color="red">${e.message}</font></big><br>
</c:forEach><br><br>
<!-- ここまで -->

<div class="border col-12">
        <br>
        <h3>会員検索</h3>
       	 検索するキーワードを入力してください
        <br>
        <div class="row">
            <div class="col-md">
                <form action="/library/SearchMemberController" method="post">
                    <div class="form-group">
                        <label>ユーザID：</label>
                        <input type="text" class="form-control input-sm" name="userId" size="15">
                        <label>名前：</label>
                        <input type="text" class="form-control input-sm" name="userName" size="15">
                        <label>住所：</label>
                        <input type="text" class="form-control input-sm" name="address" size="15">
                        <label>電話番号：</label>
                        <input type="text" class="form-control input-sm" name="tel" size="15">
                        <label>メールアドレス：</label>
                        <input type="text" class="form-control input-sm" name="email" size="15">
                    </div>
		            <div class="col-10">
		                <button type="submit" class="btn btn-outline-secondary btn-block">検索開始</button>
		                <input type="hidden" name="action" value="search">

		            </div>
           		</form>
       		</div>
        <br>
      </div>
  </div>

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
		<c:forEach items="${Member}" var="member">
				<tr>
					<td>${member.userId}</td>
					<td>${member.userName}</td>
					<td>${member.address}</td>
					<td>${member.tel}</td>
					<td>${member.email}</td>
					<td><form
							action="/library/ConfirmMemberController?action=userDelete"
							method="post">
							<div class="col-30">
							<button type="submit" class="btn btn-outline-secondary btn-block">削除</button>
							<input type="hidden" name="id" value="${member.userId}">
							</div>
						</form></td>
					<td><form action="/library/showMemberInputFormController?action=update"
							method="post">
							<div class="col-30">
							<button type="submit" class="btn btn-outline-secondary btn-block">更新</button>
							<input type="hidden" name="id" value="${member.userId}">
							</div>
						</form></td>
				</tr>
			</c:forEach>
	</tbody>
	</table>
</div>

<!--
	会員検索
	<br> 検索するキーワードを入力してください

	<form action="/library/SearchMemberController" method="post">
		ID:<input type="text" name="userId"><br> 名前:<input
			type="text" name="userName"><br> 住所:<input type="text"
			name="address"><br> 電話番号:<input type="text" name="tel"><br>
		メールアドレス:<input type="text" name="email"><br> <input
			type="submit" value="検索"><br> <input type="hidden"
			name="action" value="search">
	</form>
	<hr>
	検索結果
	<br>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>名前</td>
			<td>住所</td>
			<td>電話番号</td>
			<td>メールアドレス</td>
			<c:forEach items="${Member}" var="member">
				<tr>
					<td>${member.userId}</td>
					<td>${member.userName}</td>
					<td>${member.address}</td>
					<td>${member.tel}</td>
					<td>${member.email}</td>
					<td><form
							action="/library/ConfirmMemberController?action=userDelete"
							method="post">
							<input type="submit" value="削除">
							<input type="hidden" name="deleteuserID" value="${member.userId}">
						</form></td>
					<td><form action="/library/showUserInputFormController?action=userUpdate"
							method="post">
							<input type="submit" value="更新">
							<input type="hidden" name="action" value="${member.userId}">
						</form></td>
				</tr>
			</c:forEach>
	</table>
	-->
</body>
</html>
