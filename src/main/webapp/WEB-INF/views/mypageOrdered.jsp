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
		<title>마이페이지 - 주문내역</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypageOrdered.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/header.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/mypageOrdered.js"></script>
	</head>
	<body>
<%@ include file="/WEB-INF/views/headersimple.jsp" %>
		<div class="container">
			<div class="bodycontainer">
				<%@ include file="/WEB-INF/views/mypageleftside.jsp" %>
				<div class="content">
					<div class="mycoupang-main-container">
						<div class="mycoupang-main">
							<div class="mycoupang-main-title">
								<span>주문목록</span>
							</div>
							<div class="mycoupang-main-search">
								<div class="mycoupang-main-search-it">
									<div class="mycoupang-main-search-it-flex">
										<form>
											<div class="mycoupang-main-search-it-flexin1">
												<input type="text" id="orderSearchKeyword" class="orderSearchKeyword" name="searcho" placeholder="주문한 상품을 검색할 수 있어요!">
											</div>
											<div class="mycoupang-main-search-it-flexin2">
												<button id="headerSearchBtn" class="headerSearchBtn" type="submit">
													<img id="headerSearchBtnImage" class="headerSearchBtnImage" title="검색" src="${pageContext.request.contextPath}/resources/images/search.png">	                 	
							                 	</button>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="mycoupang-product-search">
							</div>
							<c:if test="${fn:length(mypageOrdered) == 0}">
								<div class="noexist">
									주문한 상품이 없습니다.
								</div>
							</c:if>
							<c:if test="${fn:length(mypageOrdered) != 0}">
								<div class="exist">
									<c:forEach var="mypageOrdered" items="${mypageOrdered}" varStatus="i">
									<div class="order-date-line date-${mypageOrdered.ORDER_DATE}">
										<div class="left" id="ordereddate">
											<fmt:formatDate value="${mypageOrdered.ORDER_DATE}" pattern="yyyy.MM.dd"/> 주문
										</div>
										<div class="right"></div>
									</div>
										<div class="order-product">
											<table>
												<tbody>
													<tr>
														<td class="order-product-left">
															<div class="top">
																<div class="left">
																	<span>배송 완료</span>
																	<span class="dot">
																		<span></span>
																	</span>
																</div>
															</div>
															<div class="bottom">
																<div>
																	<div style="display:none;"></div>
																	<div class="product-content">
																		<div class="bottom-flex">
																			<div class="image">
																				<a>
																					<img class="productImage" src="data:${mypageOrdered.MEDIA_DATA};base64, ${mypageOrdered.base64Img}"/>
																				</a>
																			</div>
																			<div class="content">
																				<div>
																					<a href="/fruitlight/main/SelectDetailView?pid=${mypageOrdered.PRODUCT_NO}">
																						<img height="16">
																						<span style="color:#111111";>${mypageOrdered.PRODUCT_NAME}</span>
																					</a>
																					<div>
																						<div class="price-ammount">
																							<span class="price">${mypageOrdered.DISCOUNT_PRICE}원 &nbsp;</span>
																							<span class="ammount">${mypageOrdered.STOCK}개</span>
																						</div>
																						<div class="gotocart">
																							<button>장바구니 담기</button>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</td>
														<td class="order-product-right">
															<div class="buttons">
																<button class="delisearch">배송조회</button>
																<button class="trade">교환, 반품 신청</button>
															</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</c:forEach>
								</div>
								<div class="inquiry-page-btns">
								  <c:if test="${OrderHistoryPager.totalGroupNo > 1}">
									  <c:if test="${OrderHistoryPager.groupNo > 1}">
										  <input type="hidden" value="${OrderHistoryPager.startPageNo-1}">
										  <a href="mypageOrdered?pageNo=${OrderHistoryPager.startPageNo - 1}">
											  <button class="page-prev inquiry-btn"></button>
										  </a>
									  </c:if>
								  </c:if>
								
								  <c:forEach var="i" begin="${OrderHistoryPager.startPageNo}" end="${OrderHistoryPager.endPageNo}">
								      <c:if test="${OrderHistoryPager.pageNo != i}">
									    <input type="hidden" value="${i}">
									    <a href="mypageOrdered?pageNo=${i}">
											<button class="page-num inquiry-btn">${i}</button>
									    </a>
									  </c:if>
									  <c:if test="${OrderHistoryPager.pageNo == i}">
										<input type="hidden" value="${i}">
										<a href="mypageOrdered?pageNo=${i}">
											<button class="page-num selected inquiry-btn">${i}</button>
										</a>
									  </c:if>
								  </c:forEach>
								  
								  <c:if test="${OrderHistoryPager.totalGroupNo > 1}">
									  <c:if test="${OrderHistoryPager.groupNo < OrderHistoryPager.totalGroupNo}">
										  <input type="hidden" value="${OrderHistoryPager.endPageNo+1}">
										  <a href="mypageOrdered?pageNo=${OrderHistoryPager.endPageNo + 1}">
											  <button class="page-next inquiry-btn"></button>
										  </a>
									  </c:if>
								  </c:if>
	                            </div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>