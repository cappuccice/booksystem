<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Done Regist New Member</title>
</head>
<body>

下記の会員を登録しました。
<table border="1">
<c:forEach items="${userId}" var="idlist">
<tr><td>ユーザID</td><td>${idlist}</td></tr>
</c:forEach>
<tr><td>名前</td><td>${NewMember.userName}</td></tr>
<tr><td>郵便番号</td><td>${NewMember.postal}</td></tr>
<tr><td>住所</td><td>${NewMember.address}</td></tr>
<tr><td>電話番号</td><td>${NewMember.tel}</td></tr>
<tr><td>メールアドレス</td><td>${NewMember.email}</td></tr>
<tr><td>生年月日</td><td>${NewMember.birthday}</td></tr>
</table>

<form action="/library/index.html" method="post">
<input type="submit"value="トップへ戻る">
</form>

</body>
</html>