<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>푸릇라이트 - 회원가입</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/joinForm_style.css">
    <script src="${pageContext.request.contextPath}/resources/javascript/joinForm.js"></script>

</head>
<body>
	<div class="container">
	    <header class="row" style="margin:100 auto;">
	        <h1 class="col" style="margin:0 auto;"><a href="main"><img src="${pageContext.request.contextPath}/resources/images/fruitlight_logo_new.png"></a></h1>
	    </header>
	    <div class="row" style="float: none;">
	    	<div class="col">
			    <section>
			        <form action="joinForm/askJoinForm" method="post" id="joinform" accept-charset="UTF-8">
			            <div class="form_title">회원정보를 입력해주세요</div>
			            <fieldset>
			                <legend class="skip">회원가입 양식</legend>
			                <ul>
			                    <li>
			                        <span class="id_bg"><!-- 배경이미지(이메일) --></span>
			                        <span style="width:100%"><input type="email" name="userId" id="user_id" placeholder="아이디(이메일)"></span>
			                    </li>
			                    <span id="uidNotInputErr" class="errorMsg">이메일을 입력하세요.</span>
			                    <span id="uidNotAvailableErr" class="errorMsg">이메일을 올바르게 입력해주세요.</span>
			                    <li>
			                        <span class="pw_bg"><!-- 배경이미지(비밀번호) --></span>
			                        <span style="width:100%"><input type="password" name="userPassword" id="user_pw" placeholder="비밀번호"></span>
			                    </li>
			                    <span id="user_pw_letter_combination" class="errorMsg">영문/숫자/특수문자 2가지 이상 조합 (8~20자)</span>
			                    <span id="user_pw_character_pattern" class="errorMsg">3개 이상 연속되거나 동일한 문자/숫자 제외</span>
			                    <span id="user_pw_duplicate_pattern" class="errorMsg">아이디(이메일) 제외</span>
			                    <span id="user_pw_success" class="errorMsg">사용가능한 비밀번호입니다</span>
			                    <li>
			                        <span class="pw_check_bg"><!-- 배경이미지(비밀번호 확인) --></span>
			                        <span style="width:100%"><input type="password" name="userPasswordCheck" id="user_pw_check" placeholder="비밀번호 확인"></span>
			                    </li>
			                    <span id="pw_no_match" class="errorMsg">새 비밀번호가 일치하지 않습니다.</span>
			                    <span id="pw_match" class="errorMsg">새 비밀번호가 일치합니다.</span>
			                    <li>
			                        <span class="name_bg"><!-- 배경이미지(성함) --></span>
			                        <span style="width:100%"><input type="text" name="userName" id="user_name" placeholder="이름"></span>
			                    </li>
			                    <span id="uname_no_match" class="errorMsg">이름을 정확히 입력하세요.</span>
			                    <span id="uname_wacky_match" class="errorMsg">이름을 정확히 입력하세요.</span>
			                    <li>
			                        <span class="tel_bg"><!-- 배경이미지(연락처) --></span>
			                        <span style="width:100%"><input type="tel" name="userTel" id="user_tel" placeholder="휴대폰 번호"></span>
			                    </li>
			                    <span id="phone_no_match" class="errorMsg">휴대폰 번호를 정확하게 입력하세요.</span>
			                </ul>
		                	<div class="agree_form">			
								<div class="controls">
									<div class="text" id="agreement_content_1">
										<p><span style="font-size:18px;"><strong>개인정보수집&nbsp;이용.동의</strong></span></p>
										<p><strong>수집하는 개인정보의 항목</strong></p>
										<ul>
											<li>회사는 회원가입, 상담, 콘텐츠구매, 서비스 신청 등을 위해 아래와 같은 개인정보를 수집하고 있습니다.
											<p>- 필수사항 : 아이디, 비밀번호, 이름, 휴대폰 번호</p>
											</li>
										</ul>
										<p><strong>자동수집하는 개인정보의 항목</strong></p>
										<ul>
											<li>서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.
											<p>- IP Address, 쿠키, 접속로그, 서비스 이용 기록, 불량 이용 기록, 결제기록, OS버전, 브라우저 모델명</p>
											</li>
										</ul>
									</div>
									<div class="confirm">			
										<label for="acceptAgreement">						
											<input type="checkbox" name="acceptAgreement" value="Y" id="acceptAgreement">
											[필수] 개인정보수집 이용.동의에 동의합니다.
										</label>
										<a href="javascript:checkAcceptAgreement();">[내용보기]</a>
									</div>
								</div>
							</div>
			                <div class="join_btn">
			                    <button type="submit" id="join_btn">회원 가입</button>
			                </div>
			            </fieldset>
			        </form>
			    </section>
	    	</div>
	    </div>
	    <footer>
	        &copy; Fruitlight Corp. All rights reserved.
	    </footer>
    </div>
</body>

</html>