<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
		<title>마이페이지 - 내 쿠폰함</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageleftside.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageShopperInquiry.css">
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
					<div class="title">
						<span>내 쿠폰함</span>
					</div>
					<!-- 상품문의내역이 있을 경우 -->
	                <div class="inquiry-item-container">
                		<c:forEach var="coupon" items="${listCoupon}">
	                		<div class="inquiry-item p-3">
	                    		<dl class="row p-1 mb-0">
						    		<dt class="col-3">
						    			${coupon.DISCOUNT_PRICE}${coupon.COUPON_TYPE} 할인쿠폰
						    		</dt>
						    		<dd class="col-7">
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
						    		<c:if test="${coupon.USED == false}">
							    		<dd class="col-2 text-right text-success">
							    			미사용
							    		</dd>
						    		</c:if>
						    		<c:if test="${coupon.USED == true}">
							    		<dd class="col-2 text-right text-danger">
							    			사용완료
							    		</dd>
						    		</c:if>
						    	</dl>
	                		</div>
				    	</c:forEach>
	                </div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>