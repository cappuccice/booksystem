<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h3>蔵書検索</h3>
       	 検索するキーワードを入力してください
        <br>
        <div class="row">
            <div class="col-md">
                <form action="/library/searchBookController" method="post">
                    <div class="form-group">
                        <label>ISBN：</label>
                        <input type="text" class="form-control input-sm" name="isbn" size="15">
                        <label>区分コード：</label>
                        <input type="text" class="form-control input-sm" name="divCode" size="15">
                        <label>タイトル：</label>
                        <input type="text" class="form-control input-sm" name="title" size="15">
                        <label>著者：</label>
                        <input type="text" class="form-control input-sm" name="author" size="15">
                        <label>出版社コード：</label>
                        <input type="text" class="form-control input-sm" name="publisher" size="15">
                    </div>
		            <div class="col-5">
		                <button type="submit" class="btn btn-outline-secondary btn-block">検索開始</button>
		                <input type="hidden" name="action" value="bookSearch">

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
		<td>ISBN</td>
		<td>区分コード</td>
		<td>タイトル</td>
		<td>著者</td>
		<td>出版社コード</td>
	</tr>
</thead>
	<tbody>
		<c:forEach items="${Book}" var="book">
			<tr><td>${book.isbn}</td><td>${book.divCode}</td><td>${book.title}</td><td>${book.author}</td><td>${book.publisher}</td>
			<td><form action="/library/confirmBookController?action=bookDelete" method="post">
			<button type="submit" class="btn btn-outline-secondary btn-block">削除</button>
			<input type="hidden" name="deleteISBN" value="${book.isbn}">
			</form></td>
			<td><form action="/library/showBookInputFormController?action=bookUpdate" method="post">
			<button type="submit" class="btn btn-outline-secondary btn-block">更新</button>
			<input type="hidden" name="updateISBN" value="${book.isbn}">
			</form></td></tr>
		</c:forEach>
	</tbody>
	</table>
</div>
<!--
検索結果
<br>
	<table border="1">

		<c:forEach items="${Book}" var="book">
			<tr><td>${book.isbn}</td><td>${book.divCode}</td><td>${book.title}</td><td>${book.author}</td><td>${book.publisher}</td>
			<td><form action="/library/confirmBookController?action=bookDelete" method="post"><input type="submit" value="削除"><input type="hidden" name="deleteISBN" value="${book.isbn}"></form></td>
			<td><form action="/library/showBookInputFormController?action=bookUpdate" method="post"><input type="submit" value="更新"><input type="hidden" name="updateISBN" value="${book.isbn}"></form></td></tr>
		</c:forEach>
	</table>  -->
<!--
蔵書検索
<br>
検索するキーワードを入力してください

<form action = "/library/searchBookController" method="post">
ISBN：<input type="text" name = "isbn"><br>
区分コード：<input type="text" name = "divCode"><br>
タイトル：<input type="text" name = "title"><br>
著者：<input type="text" name = "author"><br>
出版社コード：<input type="text" name = "publisher"><br>
<br>
<input type="submit" value="検索開始">
<input type="hidden" name="action" value="bookSearch">
</form>
<hr>
検索結果
<br>
	<table border="1">
		<tr><td>ISBN</td><td>区分コード</td><td>タイトル</td><td>著者</td><td>出版社コード</td>
		<c:forEach items="${Book}" var="book">
			<tr><td>${book.isbn}</td><td>${book.divCode}</td><td>${book.title}</td><td>${book.author}</td><td>${book.publisher}</td>
			<td><form action="/library/confirmBookController?action=bookDelete" method="post"><input type="submit" value="削除"><input type="hidden" name="deleteISBN" value="${book.isbn}"></form></td>
			<td><form action="/library/showBookInputFormController?action=bookUpdate" method="post"><input type="submit" value="更新"><input type="hidden" name="updateISBN" value="${book.isbn}"></form></td></tr>
		</c:forEach>
	</table>

	-->
</body>
</html>