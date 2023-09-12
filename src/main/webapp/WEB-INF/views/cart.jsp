<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon" />
		<title>푸릇라이트 - 장바구니</title>
		
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<script src="${pageContext.request.contextPath}/resources/javascript/orderheader.js"></script>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cart.css"/>
		<script src="${pageContext.request.contextPath}/resources/javascript/cart.js"></script>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/headersimple.jsp" %>
		<div class="wrap">
			<section class="container mb-5">
				<div class="orderTitle row">
		            <h3 class="title col-xl-9 col-lg-8 col-md-7 col-sm col">장바구니</h3>
		            <span class="steps col-xl-3 col-lg-4 col-md-5 col-sm col"><em>장바구니 ></em> 주문결제 > 주문완료</span>
		         </div>
				<!-- 장바구니에 담은 상품이 없을 경우 -->
				<c:if test="${fn:length(listProduct) == 0}">
					<div class="cartNoItem text-center">
						<p>장바구니에 담긴 상품이 없습니다.</p>
						<a href="${pageContext.request.contextPath}">홈으로 가기</a>
					</div>
				</c:if>
				<c:if test="${fn:length(listProduct) != 0}">
					<div class="cartContent">
						<table class="table table-sm cartTable">
							<colgroup>
								<col width="5%">
								<col width="8%">
								<col width="*">
								<col width="18%">
								<col width="10%">
								<col width="10%">
							</colgroup>
							<thead>
								<tr>
									<th scope="col" class="cartTableCol1">
										<label>
											<input type="checkbox" value="allcheck" class="cboxAll">
			  								<span>전체선택</span>
		  								</label>
									</th>
									<th scope="colgroup" colspan="2">상품정보</th>
									<th scope="col">상품옵션</th>
									<th scope="col">상품금액</th>
									<th scope="col">배송비</th>
								</tr>
							</thead>
							<tbody class="cartTableBody">
								<c:forEach var="cartProduct" items="${listProduct}" varStatus="status">
									<tr class="cartItem">
						            	<td class="cartItem_check">
						            		<input type="checkbox" class="cbox" value="${cartProduct.PRODUCT_NO}"/>
						            	</td>
						            	<td class="cartItem_img"><img src="data:${cartProduct.MEDIA_DATA};base64, ${cartProduct.base64Img}" width="100%"/></td>
						            	<td class="cartItem_product">
						            		<div class="cartItem_product">
						            			<div class="text-left">
						            				<a href="cart/goToDetailView?pno=${cartProduct.PRODUCT_NO}">
							             				${cartProduct.PRODUCT_NAME}, 
							            				<span class="product_option">${cartProduct.PRODUCT_OPTION}</span>
							            				<input type="hidden" class="product-name" value="${cartProduct.PRODUCT_NAME}"/>
							            			</a>
						            			</div>
						            		</div>
						            	</td>
						            	<td class="cartItemOption">
				            				<span class="productPrice">${cartProduct.DISCOUNT_PRICE}</span>원
		            						<input class="productStock" type="number" min="1" max="${cartProduct.PRODUCT_STOCK}" id="stock" name="stock" value="${cartProduct.CART_PRODUCT_STOCK}"/>
		            						<input type="hidden" id="pno" name="pno" value="${cartProduct.PRODUCT_NO}"/>
		            						<input class="quantityChange d-none" type="button" value="수량변경"/>
				            				<a type="button" class="productDelete" href="${pageContext.request.contextPath}/cart/delete?pno=${cartProduct.PRODUCT_NO}"></a>
						            	</td>
						            	<td class="cartItemPrice">
						            		<span class="cartItemProductPrice">${cartProduct.DISCOUNT_PRICE * cartProduct.CART_PRODUCT_STOCK}원</span>
						            	</td>
						            	<c:if test="${status.first}">
						            		<td rowspan="${fn:length(listProduct)}">
							            		<div class="shippingFreeRule font-weight-light"></div>
							            		<div class="shippingPrice"></div>
							            	</td>
						            	</c:if>
						            </tr>
						        </c:forEach>
							</tbody>
						</table>
						<!-- 전체 선택 -->
						<div class="cartSelect p-2">
							<label>
			                    <input type="checkbox" class="cboxAll"> <span>전체선택</span>
			                    <span>( <em id="checkCount">0</em> / <span id="productCount">0</span> )</span>
			                </label>
			               	<button class="checkedDelete">선택삭제</button>
	        			</div>
	                    <!-- 할인쿠폰 -->
	                    <c:if test="${fn:length(listCoupon) != 0}">
		                    <div class="cartCoupon">
		                    	<div class="coupon_title">할인쿠폰 적용</div>
		                    	<div class="coupon_list">
		                    		<c:forEach var="coupon" items="${listCoupon}">
			                    		<dl class="coupon_item row py-1">
								    		<dt class="col-2">
								    			<label>
								    				<input type="checkbox" class="cboxCoupon" value="${coupon.COUPON_NO}">
								    				<span><span class="couponAmount ml-1">${coupon.DISCOUNT_PRICE}</span><span class="couponType">${coupon.COUPON_TYPE}</span></span>
								    			</label>
								    		</dt>
								    		<dd class="col p-0">
								    			<c:if test="${coupon.COUPON_NAME == null}">
								    				<c:if test="${coupon.COUPON_KIND.equals('배송비')}">
										    			<strong>${coupon.COUPON_KIND} <span class="discountPrice">${coupon.DISCOUNT_PRICE}</span>${coupon.COUPON_TYPE} 할인쿠폰</strong>
								    				</c:if>
								    				<c:if test="${coupon.COUPON_KIND.equals('상품')}">
										    			<strong><span class="discountPrice">${coupon.DISCOUNT_PRICE}</span>${coupon.COUPON_TYPE} 할인쿠폰</strong>
								    				</c:if>
								    			</c:if>
								    			<c:if test="${coupon.COUPON_NAME != null}">
								    				<strong>${coupon.COUPON_NAME} 할인쿠폰</strong>
								    			</c:if>
								    			
								    			<c:if test="${coupon.DISCOUNT_RULE == 0}">
									    			<em>금액제한없음</em>
								    			</c:if>
								    			<c:if test="${coupon.DISCOUNT_RULE != 0}">
									    			<em class="discountRule">${coupon.DISCOUNT_RULE}원 이상 구매 시</em>
								    			</c:if>
								    		</dd>
								    	</dl>
							    	</c:forEach>
		                    	</div>
		                    </div>
		                </c:if>
						<!-- 총 구매가격 -->
						<div class="cartFinalPrice">
							<span>총 상품가격 <span class="finalProductPrice font-weight-bold">0</span>원</span>
							<span class="cartFinalDelivery">
								<img src="${pageContext.request.contextPath}/resources/images/plus.gif" class="mx-2">
								<span>총 배송비 <span class="finalDeliveryPrice font-weight-bold">0</span>원</span>
							</span>
							<span class="cartFinalDiscount d-none">
								<img src="${pageContext.request.contextPath}/resources/images/minus.gif" class="mx-2">
								<span>총 할인 <span class="finalDiscountPrice font-weight-bold text-danger">0</span>원</span>
							</span>
							<span class="cartFinalTotal">
								<img src="${pageContext.request.contextPath}/resources/images/equal.gif" class="mx-2">
								<span>총 주문금액 <span class="finalTotalPrice font-weight-bold">0원</span></span>
							</span>
						</div>
						<!-- 구매버튼 -->
						<div class="orderBtns text-center">
							<a class="shopping_btn" href="${pageContext.request.contextPath}">계속 쇼핑하기</a>
							<span class="buyBtn">구매하기</span>
						</div>
					</div>
				</c:if>
			</section>
		</div>
	</body>
</html>