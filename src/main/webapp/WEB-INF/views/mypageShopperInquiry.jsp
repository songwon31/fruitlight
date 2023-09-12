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
		<title>마이페이지 - 상품 문의</title>
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
						<span>문의내역</span>
					</div>
					<!-- 문의 검색 -->
					<div class="inquiry-search">
						<form method="post"action="${pageContext.request.contextPath}/mypageShopperInquiry">
							<div class="inquiry-search-txt">
								<input type="text" id="inquirySearchKeyword" class="inquirySearchKeyword" name="searchKeyword" placeholder="상품명으로 검색할 수 있어요!">
							</div>
							<div class="inquiry-search-btn">
								<button id="headerSearchBtn" class="headerSearchBtn" type="submit">
									<img id="headerSearchBtnImage" class="headerSearchBtnImage" src="${pageContext.request.contextPath}/resources/images/search.png">	                 	
			                 	</button>
							</div>
						</form>
					</div>
					<!-- 상품문의내역이 없을 경우 -->
					<c:if test="${fn:length(productInquiryList) == 0}">
						<div class="inquiry-item-container">
							<div class="inquiry-none-items">
								<p>등록된 문의가 없습니다.</p>
							</div>
						</div>
					</c:if>
					<!-- 상품문의내역이 있을 경우 -->
	                <c:if test="${fn:length(productInquiryList) != 0}">
	                	<!-- 이전 이름(이름으로 그룹핑하기 위함) -->
		            	<c:set var="previousProductName" value="" />
						<c:forEach var="productInquiry" items="${productInquiryList}">
						    <c:if test="${productInquiry.PRODUCT_NAME != previousProductName}">
						        <c:if test="${!empty previousProductName}">
						        	<!-- 이전 이름과 현재 이름이 다르고, 이전 이름이 있을 경우 inquiry-item-container 닫음 -->
						            </div>
						        </c:if>
						        <div class="inquiry-item-container">
						            <div class="inquiry-item-product">
						                <a href="${pageContext.request.contextPath}/mypageShopperInquiry/goToDetailView?bno=${productInquiry.BOARD_NO}">${productInquiry.PRODUCT_NAME}</a>
						            </div>
						    </c:if>
						    <div class="inquiry-item">
								<span class="inquiry-item-question-label">질문</span>
								<div class="inquiry-item-question">
									<div class="inquiry-item-content">${productInquiry.INQUIRY_CONTENT}</div>
									<div class="inquiry-item-time"><fmt:formatDate value="${productInquiry.INQUIRY_DATE}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
								</div>
								<!-- 상품문의 답변 -->
								<c:if test="${productInquiry.EMPTANSWER == false}">
									<div class="inquiry-item-answer">
										<i></i>
										<span class="inquiry-item-answer-label">답변</span>
										<div class="inquiry-item-answer-wrap">
											<div class="inquiry-item-seller"><strong>[FRUITLIGHT]</strong></div>
											<div class="inquiry-item-answer-content">${productInquiry.ANSWER_CONTENT}</div>
											<div class="inquiry-item-answer-time"><fmt:formatDate value="${productInquiry.ANSWER_DATE}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
										</div>
									</div>
								</c:if>
								<!-- 문의글 수정 및 삭제버튼 -->
							    <div class="inquiry-delete-btn p-3 text-right">
									<%-- <c:if test="${productInquiry.EMPTANSWER == true}">
								        <a href="${pageContext.request.contextPath}/mypageShopperInquiry/deleteInquiry?ino=${productInquiry.INQUIRY_NO}" class="btn btn-sm btn-outline-success">수정</a>
								    </c:if> --%>
							        <a href="${pageContext.request.contextPath}/mypageShopperInquiry/deleteInquiry?ino=${productInquiry.INQUIRY_NO}" class="btn btn-sm btn-outline-danger ml-1">삭제</a>
							    </div>
							</div>
						    <c:set var="previousProductName" value="${productInquiry.PRODUCT_NAME}" />
						</c:forEach>
						<c:if test="${!empty previousProductName}">
							<!-- 마지막 inquiry-item-container 닫음 -->
						    </div>
						</c:if>
						<div class="inquiry-page-btns">
							<c:if test="${productInquiryPager.searchKeyword == ''}">
								<c:if test="${productInquiryPager.groupNo > 1}">
									<a class="page-prev inquiry-btn" href="${pageContext.request.contextPath}/mypageShopperInquiry?pageNo=${productInquiryPager.startPagNo-1}"></a>
								</c:if>
									
								<c:forEach var="i" begin="${productInquiryPager.startPageNo}" end="${productInquiryPager.endPageNo}">
									<c:if test="${productInquiryPager.pageNo != i}">
										<a class="page-num inquiry-btn" href="${pageContext.request.contextPath}/mypageShopperInquiry?pageNo=${i}">${i}</a>
									</c:if>
									<c:if test="${productInquiryPager.pageNo == i}">
										<a class="page-num selected inquiry-btn" href="${pageContext.request.contextPath}/mypageShopperInquiry?pageNo=${i}">${i}</a>
									</c:if>
								</c:forEach>
									
								<c:if test="${productInquiryPager.groupNo < productInquiryPager.totalGroupNo}">
									<a class="page-next inquiry-btn" href="${pageContext.request.contextPath}/mypageShopperInquiry?pageNo=${productInquiryPager.endPageNo+1}"></a>
								</c:if>
							</c:if>
						</div>
					</c:if>
					<c:if test="${productInquiryPager.searchKeyword != ''}">
						<div class="text-right mr-4">
							<a class="btn btn-md btn-light p-2" href="${pageContext.request.contextPath}/mypageShopperInquiry">돌아가기</a>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>