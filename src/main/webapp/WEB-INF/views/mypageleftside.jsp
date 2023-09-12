<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="leftside">
	<nav>
		<div class="mymenu">
			<div class="text-left pb-2">
				<h3>마이 페이지</h3>
			</div>
			<div class="mymenu-menu">
				<a class="mymenu-menu-title" href="mypageOrdered">주문 내역</a>
			</div>
			<div class="mymenu-menu">
				<a class="mymenu-menu-title" href="mypageShopperCoupon">내 쿠폰함</a>
			</div>
			<div class="mymenu-menu">
				<a class="mymenu-menu-title" href="mypageShopperInquiry?shopperNo=${ShopperInfo.shopperNo}">상품 문의</a>
			</div>
			<%-- <div class="mymenu-menu">
				<a class="mymenu-menu-title" href="mypageShopperReview?shopperNo=${ShopperInfo.shopperNo}">상품 후기</a>
			</div> --%>
			<div class="mymenu-menu">
				<a class="mymenu-menu-title" href="mypageChangeInfo?shopperNo=${ShopperInfo.shopperNo}">내 정보 변경</a>
			</div>
			<div class="mymenu-menu">
				<a class="mymenu-menu-title" href="mypageAddressBook">배송지 변경</a>
			</div>
			<div class="mymenu-menu" style="border-bottom: 0px;">
				<a class="mymenu-menu-title" href="mypageShopperDelete">회원 탈퇴</a>
			</div>
		</div>
	</nav>
</div>
