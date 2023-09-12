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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addressBook_style.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/header.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/mypageAddressBook.js"></script>
	</head>
	<body>
<%@ include file="/WEB-INF/views/headersimple.jsp" %>
		<div class="container">
			<div class="bodycontainer">
				<%@ include file="/WEB-INF/views/mypageleftside.jsp" %>
				<section class="content-body">
		            <div class="content-body-corset">
		            	<c:forEach var="item" items="${addrBookList}" varStatus="status">
			            	<div class="address-card">
			            		<input type="hidden" name="addressNo" value="${item.addressNo}">
			            		<div class="address-card__head">
									<div class="address-card__title">${item.shippingName}</div>
								</div>
								<div class="address-card__body">
									<div class="address-card__text address-card__text--address">${item.shippingAddress}</div>
									<div class="address-card__text address-card__text--cellphone">${item.receiverTel}</div>
									<div class="address-card__text address-card__text--delivery-preference">${item.shippingPreference}</div>
								</div>
								<div class="address-card__foot">
								   <div class="address-card__form--pick">
								       <input name="addressNo${status.count}" value="${item.addressNo}" type="hidden">
		 						       <input name="recipientName${status.count}" value="${item.shippingName}" type="hidden">
								       <input name="streetAddress${status.count}" value="${item.shippingAddress}" type="hidden">
								       <input name="recipientTel${status.count}" value="${item.receiverTel}" type="hidden">
								       <input name="recipientSummary${status.count}" value="${item.shippingPreference}" type="hidden">
								       <button class="addressBookFormSubmit" type="button" onclick="selectAddressBook(${status.count})">
								           <span class="addressbook__text">선택</span>
								       </button>
								   </div>
							       <a href="/fruitlight/mypageAddressBook/deleteAddressBook?addressNo=${item.addressNo}" class="address-card__button--edit">
							           <span class="addressbook__text">삭제</span>
							       </a>
								</div>
							</div>
		            	</c:forEach>
						<form class="addressBookNewForm" method="get" action="/fruitlight/mypageNewAddressBook">
						   <div class="addressbook__button-fixer">
						       <button type="submit" class="addressbook-new-button">
						           <i class="addressbook__icon--plus"></i>
						           <span class="addressbook__text ">배송지 추가</span>
						       </button>
						   </div>
						</form>
		            </div>
		        </section>
			</div>
		</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>