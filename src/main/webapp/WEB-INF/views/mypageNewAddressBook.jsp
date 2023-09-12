<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko_KR">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageNewAddressBook.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageleftside.css">
	    <title>배송지 선택 페이지</title>
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	    <script src="${pageContext.request.contextPath}/resources/javascript/header.js"></script>
	    <script src="${pageContext.request.contextPath}/resources/javascript/newAddressBook.js"></script>
	</head>
	<body>
<%@ include file="/WEB-INF/views/headersimple.jsp" %>
	    <div class="container">
	    	<%@ include file="/WEB-INF/views/mypageleftside.jsp" %>
		    
		    <div class="content-head content-head--fixed">
		    	<h1 class="content-head__title">배송지 추가</h1>
				<div class="content-body__corset">
				    <form action="mypageAddAddressBook" method="post" class="_addressBookSaveForm" accept-charset="UTF-8">
				    	<input type="hidden" name="shopperNo" value="${ShopperInfo.shopperNo}">
				    
				    	<!-- 받는 사람 입력 요소 -->
					    <div class="icon-text-field__frame-box _addressBookRecipientRoot" style="height:51px">
						    <div class="icon-text-field__icon-container" style="height:50px">
						        <div class="icon-text-field__icon-box icon-text-field__icon-box--fix" style="height:49px">
						            <i class="icon-text-field__icon--person"></i>
						        </div>
						        <div class="icon-text-field__input-container" style="height:50px">
						            <label for="addressbookRecipient" class="icon-text-field__input-area" style="height:50px">
						                <input type="text" class="icon-text-field__input _addressBookRecipientInput" id="addressbookRecipient" name="shippingName" maxlength="40" placeholder="받는 사람" value="" style="height:49px">
						            </label>
						        </div>
						    </div>
						</div>
						
						<!-- 받을 주소 입력 요소 -->
						<div class="icon-text-field__frame-box _addressBookAddressErrorStatus" style="height:100px">
						    <div class="icon-text-field__icon-container" style="height:100px">
						        <div class="icon-text-field__icon-box icon-text-field__icon-box--fix" style="height:98px">
						            <i class="icon-text-field__icon--map-pin"></i>
						        </div>
						        <div class="icon-text-field__input-container" style="height:100px">
						        	<button id="addressbookRecieveAddr" onclick="sample6_execDaumPostcode()" type="button" role="button" class="icon-text-field__button">
				                    	<span class="icon-text-field__text icon-text-field__text--button-label">받을 주소 검색</span>
				                    </button>
						            <label for="addressbookRecipientLocation" class="icon-text-field__input-area" style="height:50px">
						                <input type="text" class="icon-text-field__input _addressBookRecipientInput" id="addressbookRecipientLocation" name="shippingAddress" placeholder="받을 주소" value="" style="height:49px">
						            </label>
						        </div>
						    </div>
						</div>
						
						<!-- 연락처 입력 요소 -->
						<div class="icon-text-field icon-text-field--input-util _addressBookCellphoneAddonStatus" style="height:50px">
						    <div class="icon-text-field__frame-box _addressBookCellphoneErrorStatus" style="height:50px">
						        <div class="icon-text-field__icon-container" style="height:50px">
						            <div class="icon-text-field__icon-box icon-text-field__icon-box--fix" style="height:48px">
						                <i class="icon-text-field__icon--cellphone"></i>
						            </div>
						            <div class="icon-text-field__input-container" style="height:50px">
						                <label for="addressbookCellphone" class="icon-text-field__input-area" style="height:50px">
						                    <input type="tel" class="icon-text-field__input _addressBookCellphoneInput" id="addressbookCellphone" name="receiverTel" placeholder="연락처" value=""style="height:48px">
						                </label>
						            </div>
						        </div>
						    </div>
						</div>
						
						<!-- 배송 요청사항 입력 요소 -->
					    <div class="icon-text-field__frame-box _addressBookDeliveryPreferencesErrorStatus" style="height:50px">
					        <div class="icon-text-field__icon-container" style="height:50px">
					            <div class="icon-text-field__icon-box icon-text-field__icon-box--fix" style="height:48px">
					                <i class="icon-text-field__icon--speech-bubble"></i>
					            </div>
					            <div class="icon-text-field__button-container" style="height:50px">
				                    <button id="askDeliveryPreference" onclick="openDeliveryPreferencesPage()" type="button" role="button" class="icon-text-field__button icon-text-field__button--icon-container _addressBookDeliveryPreferencesTrigger">
				                    	<span class="icon-text-field__text icon-text-field__text--button-label _addressBookDeliveryPreferencesDefaultSummary">배송 요청사항</span>
				                    </button>
				                    <label id="getDeliveryPreference" for="addressbookPreference" class="icon-text-field__input-area" style="display: none; height:50px">
						                    <input type="text" class="icon-text-field__input _addressBookCellphoneInput" id="addressbookPreference" name="shippingPreference" value="">
						            </label>
					            </div>
					        </div>
					    </div>
						
						<!-- 저장 버튼 -->
					    <div class="addressbook__button-fixer">
					        <button type="submit" class="addressbook__button--save _addressBookFormSubmit">
					            <span class="addressbook__text">저장</span>
					        </button>
					    </div>
					</form>
				</div>
				<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<script>
				    function sample6_execDaumPostcode() {
				        new daum.Postcode({
				            oncomplete: function(data) {
				                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				
				                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
				                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				                var addr = ''; // 주소 변수
				                var extraAddr = ''; // 참고항목 변수
				
				                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				                    addr = data.roadAddress;
				                } else { // 사용자가 지번 주소를 선택했을 경우(J)
				                    addr = data.jibunAddress;
				                }
				
				                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				                if(data.userSelectedType === 'R'){
				                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
				                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
				                        extraAddr += data.bname;
				                    }
				                    // 건물명이 있고, 공동주택일 경우 추가한다.
				                    if(data.buildingName !== '' && data.apartment === 'Y'){
				                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				                    }
				                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				                    if(extraAddr !== ''){
				                        extraAddr = ' (' + extraAddr + ')';
				                    }
				                }
				
				                // 우편번호와 주소 정보를 해당 필드에 넣는다.
				                $('input[name=shippingAddress]').val(addr);
				            }
				        }).open();
				    }
				</script>
			
			</div>
		
		
		</div>
	</body>
</html>