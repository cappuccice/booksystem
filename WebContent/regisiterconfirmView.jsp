<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm New Member</title>
</head>
<body>

下記の会員を登録します。
<table border="1">
<tr><td>名前</td><td>${NewMember.userName}</td></tr>
<tr><td>郵便番号</td><td>${NewMember.postal}</td></tr>
<tr><td>住所</td><td>${NewMember.address}</td></tr>
<tr><td>電話番号</td><td>${NewMember.tel}</td></tr>
<tr><td>メールアドレス</td><td>${NewMember.email}</td></tr>
<tr><td>生年月日</td><td>${NewMember.birthday}</td></tr>
</table>


以上の内容に間違いがなければ登録を確定してください。<br>
<form action="/library/CreateMemberControler" method="post">
<input type="submit"value="確定">
</form>
<br>
間違いがあれば戻ってやり直してください。
<form action="/library/BackToInputFormController" method="post">
<input type="submit"value="戻る">
</form>

</body>
</html>