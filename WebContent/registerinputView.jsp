<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

新規会員の登録を行います。<br>
会員情報を入力してください。<br>
<form action="/library/ConfirmNewMemberController" method="post">
<table border="1">
<tr><td>名前</td><td><input type="text" name="userName" size="33"></td></tr>
<tr><td>郵便番号</td><td><input type="text" name="postal" size="33"></td></tr>
<tr><td>住所</td><td><input type="text" name="address" size="33"></td></tr>
<tr><td>電話番号</td><td><input type="text" name="tel_1" size="5"> - <input type="text" name="tel_2" size="5"> - <input type="text" name="tel_3" size="5"></td></tr>
<tr><td>メールアドレス</td><td><input type="text" name="email_1" size="12">@<input type="text" name="email_2" size="12"></td></tr>
<tr><td>生年月日</td>
	<td><input type="text" name="year" size="6">年
	<select name="month">
	<option value="">-</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	</select>月
	<select name="day">
	<option value="">-</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	<option value="11">11</option>
	<option value="12">12</option>
	<option value="13">13</option>
	<option value="14">14</option>
	<option value="15">15</option>
	<option value="16">16</option>
	<option value="17">17</option>
	<option value="18">18</option>
	<option value="19">19</option>
	<option value="20">20</option>
	<option value="21">21</option>
	<option value="22">22</option>
	<option value="23">23</option>
	<option value="24">24</option>
	<option value="25">25</option>
	<option value="26">26</option>
	<option value="27">27</option>
	<option value="28">28</option>
	<option value="29">29</option>
	<option value="30">30</option>
	<option value="31">31</option>
	</select>日
	</td></tr>
</table>
<br>
<input type="submit"value="確認画面へ進む">
</form>
</body>
</html>