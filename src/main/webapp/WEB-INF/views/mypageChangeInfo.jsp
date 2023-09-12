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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageChangeInfo.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/header.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/mypageChangeInfo.js"></script>
	</head>
	<body>
<%@ include file="/WEB-INF/views/headersimple.jsp" %>
		<div class="container">
			<div class="bodycontainer">
				<%@ include file="/WEB-INF/views/mypageleftside.jsp" %>
				<div class="content">
					<div class="mycoupang-main-container">
						<div class="mycoupang-main-title">
							<span>내 정보 변경</span>
						</div>
					</div>
					<c:if test="${resultCheckPw == null || resultCheckPw == false}">
						<div class="noPasswordInfo" id="noPasswordInfo">
						    <form action="/fruitlight/mypageChangeInfo?shopperNo=${ShopperInfo.shopperNo}" method="post">
						        <div class="passwordRequest">
						            <span>비밀번호 확인</span>
						            <input id="inputPassword" name="shopperPwd" type="password"/>
						            <button id="checkPasswordBtn" class="headerSearchBtn" type="submit">
						                <img id="headerSearchBtnImage" class="headerSearchBtnImage" title="검색" src="${pageContext.request.contextPath}/resources/images/search.png">
						            </button>
						        </div>
						    </form>
						</div>
					</c:if>
					<c:if test="${resultCheckPw != null && resultCheckPw == true}">
						<table class="changeInfo" id="changeInfoTable">
							<tbody>
								<tr>
									<th scope="row">아이디</th>
									<td>
										<div class="infoForm id">
											<span id="user_id">${mypageChangeInfo.shopperId}</span>
											<button id="emailChange" class="d-inline-block changeBtn" onclick="openEmailChange()">이메일 변경하기</button>
											<button id="emailCancel" class="d-none changeBtn" onclick="openEmailChangeCancel()">이메일 변경취소</button>
											<form id="changeIdForm"class="d-none changeForm" action="/fruitlight/mypageChangeInfo/updateId" method="post">
												<input type="email" name="shopperId">
												<button id="changeIdButton" class="changeBtn hidden" type="submit">변경하기</button>
											</form>
										</div>
									</td>
								</tr>
								<tr>
									<th scope="row">이름</th>
									<td class="infoForm name"> 
										<span>${mypageChangeInfo.shopperName}</span>
									</td>
								</tr>
								<tr>
									<th scope="row">휴대폰 번호</th>
									<td>
										<div class="infoForm tel">
											<span>${mypageChangeInfo.shopperTel}</span>
											<button id="telChange" class="d-inline-block changeBtn" onclick="openTelChange()">휴대폰 번호 변경하기</button>
											<button id="telCancel" class="d-none changeBtn" onclick="openTelChangeCancel()">휴대폰 번호 변경취소</button>
											<form method="post" id="changeTelForm" class="d-none changeForm" action="/fruitlight/mypageChangeInfo/updateTel">
												<input type="text" name="shopperTel" value="">
												<button id="changeTelBtn" class="changeBtn hidden" type="submit">번호 변경하기</button>
											</form>
										</div>
									</td>
								</tr>
								<tr>
									<th scope="row">비밀번호 변경</th>
									<td>
										<div class="pwForm">
											<form action="/fruitlight/mypageChangeInfo/updatePW" method="post">
												<div>
													<span style="padding-right: 30px;">현재 비밀번호</span>
													<input id="user_current_pw" type="password" value=""/>
													<input id="user_original_pw" type="hidden" value="${mypageChangeInfo.shopperPw}"/>
												</div>
												<div>
													<span id="user_pw_original_check" class="errorMsg">현재 비밀번호가 일치하지 않습니다.</span>
													<span id="user_pw_original_success" class="errorMsg">비밀번호가 일치합니다.</span>
												</div>
												<div>
													<span style="padding-right: 46px;">새 비밀번호</span>
													<input id="user_pw" type="password" name="updateShopperPw" value=""><br>
												</div>
												<div>
													<span id="user_pw_letter_combination" class="errorMsg">영문/숫자/특수문자 2가지 이상 조합 (8~20자)</span>
								                    <span id="user_pw_character_pattern" class="errorMsg">3개 이상 연속되거나 동일한 문자/숫자 제외</span>
								                    <span id="user_pw_duplicate_pattern" class="errorMsg">아이디(이메일) 제외</span>
								                    <span id="user_pw_success" class="errorMsg">사용가능한 비밀번호입니다</span>
												</div>
												<div>
													<span style="padding-right: 14px;">비밀번호 재입력</span>
													<input id="user_pw_check" type="password" value=""><br>
												</div>
												<div>
													<span id="pw_no_match" class="errorMsg">새 비밀번호가 일치하지 않습니다.</span>
				                    				<span id="pw_match" class="errorMsg">새 비밀번호가 일치합니다.</span>
												</div>
												<button id="btn-pwd" class="changeBtn" type="submit">비밀번호 변경</button>
											</form>
										</div>
									</td>
								</tr>
								<tr>
									<th scope="row">배송지</th>
									<td>
										<div class="infoForm DeliverAddress">
											<span>배송지 변경은 [배송지 선택/변경] 페이지로 이동합니다.</span>
											<button id="daChange" class="d-inline-block changeBtn" onclick="deliveryAddressBtn()">배송지 변경</button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>