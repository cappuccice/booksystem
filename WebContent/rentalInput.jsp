<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="border col-12">
        <br>
        <h3>貸出本のIDを入力してください。</h3>
        <br>
        <div class="row">
            <div class="col-md">
                <form action="/library/ConfirmRental" method="post">
                 	<div class="form-group">
                        <label>ユーザID：</label>
                        <input type="text" class="form-control" name="userId" size="15">
                    </div><div class="form-group">
                        <label>一冊目：</label>
                        <input type="text" class="form-control" name="ISBN1" size="15">
                    </div><div class="form-group">
                        <label>二冊目：</label>
                        <input type="text" class="form-control" name="ISBN2" size="15">
                    </div><div class="form-group">
                        <label>三冊目：</label>
                        <input type="text" class="form-control" name="ISBN3" size="15">
                    </div><div class="form-group">
                        <label>四冊目：</label>
                        <input type="text" class="form-control" name="ISBN4" size="15">
                    </div><div class="form-group">
                        <label>五冊目：</label>
                        <input type="text" class="form-control" name="ISBN5" size="15">
                    </div>

		            <div class="col-5">
		                <button type="submit" class="btn btn-outline-secondary btn-block">登録</button>
		            </div>
           		</form>
       		</div>
        <br>
      </div>
  </div>


</body>
</html>
