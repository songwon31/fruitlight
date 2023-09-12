<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
		<title>마이페이지 - 내정보 변경</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageleftside.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageShopperDelete.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/header.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/mypageShopperDelete.js"></script>
	</head>
	<body>
<%@ include file="/WEB-INF/views/headersimple.jsp" %>
		<div class="container">
			<div class="bodycontainer">
				<%@ include file="/WEB-INF/views/mypageleftside.jsp" %>
				
				<h1>회원 탈퇴</h1>
				<form method="post" action="/fruitlight/mypageShopperDelete/deleteAgree">
					<div class="agree_form">			
						<div class="controls">
							<div class="text" id="agreement_content_1">
								<p><span class="delete_user_title">회원 탈퇴를 신청하기 전, 다음 내용을 꼭 확인해주세요!</span></p>
								<p><strong>고객 정보 및 개인형 서비스 이용 기록은 개인 정보보호 처리 방침 기준에 따라 삭제됩니다.</strong></p>
								<p><strong>회원 탈퇴 시 보유한 쿠폰 등 할인 혜택은 모두 삭제되며 재가입 시에도 제공되지 않습니다.</strong></p>
								<p><strong>회원 탈퇴 시 더 이상 푸릇라이트 이용이 불가능하며, 탈퇴 처리됩니다.</strong></p>
							</div>
							<div class="confirm">			
								<label for="accept_agreement_1">						
									<input type="checkbox" name="acceptAgreement" value="Y" id="acceptAgreement" style="margin-top: 20px;">
									<strong>안내 사항을 모두 확인하였으며, 이에 동의에 동의합니다.</strong>
								</label>
							</div>
						</div>
					</div>
	                <div class="join_btn">
	                    <button type="submit" id="join_btn">회원 탈퇴</button>
	                </div>
				</form>
			</div>
		</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>