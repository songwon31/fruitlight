<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=2.0">
    <title>배송지 선택 페이지</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addressBook_style.css">
    <script src="${pageContext.request.contextPath}/resources/javascript/addressBook.js"></script>
</head>
<body>
    <div>
        <header class="content-head">
            <h1 class="content-head-title">배송지 선택</h1>
        </header>
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
					       <a href="/fruitlight/addressBook/deleteAddressBook?addressNo=${item.addressNo}" class="address-card__button--edit">
					           <span class="addressbook__text">삭제</span>
					       </a>
						</div>
					</div>
            	</c:forEach>
				<form class="addressBookNewForm" method="get" action="/fruitlight/addressBook/newAddressBook">
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
</body>
</html>