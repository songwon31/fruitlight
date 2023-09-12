<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>푸릇라이트 - 아이디(이메일) 찾기</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login_style.css">
</head>
<div class="container">
	<div class="form-box">
		<h2>이메일 찾기</h2>
		<form action="/fruitlight/login/findEmail/submit" method="post">
			<div class="form-group">
				<label for="usr">이름(실명):</label>
				<input type="text" class="form-control" id="usr" name="shopperName">
			</div>
			<div class="form-group">
				<label for="pwd">연락처:</label>
				<input type="tel" class="form-control" id="tel" name="shopperTel">
			</div>
			<button type="submit" class="btn findAccountBtn">아이디 찾기</button>
		</form>
	</div>
</div>

</body>
</html>
