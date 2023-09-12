<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>푸릇라이트</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
   
    <script src="${pageContext.request.contextPath}/resources/javascript/orderheader.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detailView_style.css" />
	<script src="${pageContext.request.contextPath}/resources/javascript/detailView.js"></script>
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp" %>
   <div class="container">
      <div class="contents">
         <input class="product-id" type="hidden" value="1">
         <div class="top-product">
            <div class="top-product-main">
               <div class="product-image">
                  	 <ul class="productItems">
        		         <c:forEach var="productImage" items="${productImageList}">
		                     <li><img
		                           src="data:${productImage.mediaData};base64, ${productImage.base64Img}"
		                           id="${productImage.mediaName}"
		                           width="48px">
		                     </li>
		                 </c:forEach>
	                  </ul>
                  <img class="productMainImage" src="data:${productBoard.mediaData};base64, ${productBoard.base64Img}"/>
               </div>
               <!-- 구매 선택 -->
               <div class="product-buy">
                  <!-- 상품 이름 -->
                  <div class="product-buy-header">
                     <div class="product-buy-header_left">
                        <h2>${productBoard.productName}</h2>
                        <div class="prod-buy-header__info">
                           <span class="prod-buy-header__productreview" style="display:block;">
                              <a href="#product_review-form">
                                 <span class="rating-star-container" style="float:left;">
                                    <span class="rating-star-num" style="width: 90.0%;"></span>
                                 </span>
                                 <span class="count">${ReviewPager.totalRows}개 상품평</span>
                              </a>
                           </span>
                        </div>
                     </div>
                     <div class="product-buy-header_right">
                        <button value="off" class="product-wish-btn"></button>
                        <button class="product-share-btn"></button>
                     </div>
                  </div>
                  <!-- 상품 가격 -->
                  <div class="product-price-container">
                     <div class="product-price">
                        <!-- 할인율 및 원래가격 -->
                        <c:if test="${productBoard.discountRate != 0}">
	                        <div class="product-origin-price">
	                           <span class="discount-rate">${productBoard.discountRate}%</span>
	                           <span class="origin-price"><fmt:formatNumber value="${productBoard.productPrice}" pattern="#,###"/>원</span>
	                        </div>
	                    </c:if>
                        <!-- 총가격 -->
                        <div class="product-total-price">
                           <span class="total-price">${productBoard.discountPrice}</span>
                        </div>
                     </div>
                  </div>
                  <!-- 상품 옵션 -->
                  <div class="product-option-container mt-3">
                  	 <div class="product-option-btn-container">
                  	 	<div class="product-option-btn">
                           <span class="product-option-title">
                               <strong>= 옵션 : 가격 =</strong>
                           </span>
                           <span class="product-option-ico closed" style="background-image: url(${pageContext.request.contextPath}/resources/images/option_drop_down.png)"></span>
                           <span class="product-option-ico open" style="background-image: url(${pageContext.request.contextPath}/resources/images/option_drop_up.png); display: none;"></span>
                     	</div>
                  	 </div>
	                     <ul class="product-options-list closed">
                  	 		<c:forEach var="optionProduct" items="${productOptionList}">
		                     	<li class="product-option-list-item">
			                      <div id="${optionProduct.PRODUCT_NO}">
			                      	<c:if test="${optionProduct.PRODUCT_OPTION == product.PRODUCT_OPTION}">
			                      		<span class="option-item-name">${optionProduct.PRODUCT_OPTION}</span><span class="option-item-price" hidden> : ${optionProduct.DISCOUNT_PRICE}</span>
			                      	</c:if>
			                      	<c:if test="${optionProduct.PRODUCT_OPTION != product.PRODUCT_OPTION}">
			                      		<span class="option-item-name">${optionProduct.PRODUCT_OPTION}</span><span class="option-item-price"> : ${optionProduct.DISCOUNT_PRICE}</span>
			                      	</c:if>
			                      </div>
			                  	</li>
		              		</c:forEach>
		                  </ul>
                  </div>
                  <div class="product-option">
                      <table class="product-option-table">
                          <colgroup>
                              <col width="*">
                              <col width="5%">
                              <col width="20%">
                              <col width="5%">
                          </colgroup>
                          <!-- <thead>
                              <tr>
                                  <th scope="col">옵션이름</th>
								  <th scope="col">옵션수량</th>
								  <th scope="col">옵션금액</th>
								  <th scope="col">삭제버튼</th>
                              </tr>
                          </thead> -->
                          <tbody class="product-option-tableBody">
                              <c:forEach var="optionProduct" items="${productOptionList}">
                              	<tr class="product-option-tableRow ${optionProduct.PRODUCT_NO}">
                                  <td class="product-option-table-name">
                                  	  <input type="hidden" class="product-option-pid" id="${optionProduct.PRODUCT_NO}" value="${optionProduct.PRODUCT_NO}"/>
                                  	  <input type="hidden" class="product-option-pname" id="${optionProduct.PRODUCT_OPTION}" value="${optionProduct.PRODUCT_NAME}"/>
                                  	  <input type="hidden" class="product-option-option" id="${optionProduct.PRODUCT_OPTION}" value="${optionProduct.PRODUCT_OPTION}"/>
                                      ${optionProduct.PRODUCT_OPTION}
                                  </td>
                                  <td class="product-option-table-quantity">
                                      <div class="product-quantity-container">
				                         <div class="product-quantity">
				                            <input class="product-quantity-input" type="number" value="1" min="1" max="${optionProduct.PRODUCT_STOCK}" name="stock"/>
				                            <div class="product-quantity-btns">
				                               <button class="product-quantity-plus-btn" type="button"></button>
				                               <button class="product-quantity-minus-btn" type="button" disabled="disabled"></button>
				                            </div>
				                         </div>
				                      </div>
                                  </td>
                                  <td class="product-option-table-price">
                                  	  <input type="hidden" class="product-option-originalPrice" value="${optionProduct.DISCOUNT_PRICE}"/>
                                      <span class="product-option-originalPrice-txt">${optionProduct.DISCOUNT_PRICE}</span>
                                  </td>
                                  <td class="product-option-table-delete">
                                      <a class="productDelete"></a>
                                  </td>
                              	</tr>
                              </c:forEach>
                          </tbody>
                      </table>
                  </div>
                  <div class="product-buy-footer">
                     <!-- 장바구니/구매하기 -->
                     <div class="product-buy-btns">
                     	<input type="hidden" id="shopperInfo" value="${ShopperInfo}">
                        <button class="product-cart-btn">
                           	장바구니 담기
                        </button>
                        <button class="product-buy-btn">
                           <span>바로구매</span>
                        </button>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="bottom">
            <!-- 상품내용 목차 -->
            <div id="detail_product_form" class="detaile_product tab-dock-top">
               <ul class="detail_product_form_title">
                  <li name="detail" class="active">상품 상세</li>
                  <li name="review"><a href="#product_review-form" style="color: #555;">상품평</a></li>
                  <li name="qna"><a href="#prduct_qna_form" style="color: #555;">상품 문의</a></li>
                  <li name="etc"><a href="#product-etc-inquery" style="color: #555;">배송/교환/반품 안내</a></li>
               </ul>
               <ul class="detail_product_form_contents">
                  <!-- 상품 상세 -->
                  <li name="detail_product_contents">
                     <!-- 상품 상세 내용 -->
                     <div>
                        <div class="product_essential_info">
                           <p class="table_title">필수 표기정보</p>
                           <c:if test="${foodRequiredInfo != null}">
	                           <div class="table_frame">
	                              <div class="table_row">
	                                 <div class="table_column">품목 또는 명칭</div>
	                                 <div id="fresh_food_title" class="table_content">${foodRequiredInfo.item}</div>
	                                 <div class="table_column">포장단위별 내용물의 용량(중량),수량,크기</div>
	                                 <div id="fresh_food_weight" class="table_content">${foodRequiredInfo.weight}</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">생산자(수입자)</div>
	                                 <div id="fresh_food_manufacturer" class="table_content">${foodRequiredInfo.producer}</div>
	                                 <div class="table_column">원산지</div>
	                                 <div id="fresh_food_origin" class="table_content">${foodRequiredInfo.origin}</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">제조연월일, 소비기한 또는 품질유지기한</div>
	                                 <div id="fresh_food_manufacturing_date" class="table_content">${foodRequiredInfo.productionDate}</div>
	                                 <div class="table_column">세부 품목군별 표시사항</div>
	                                 <div id="fresh_food_detail_group" class="table_content">${foodRequiredInfo.detail}</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">수입식품 문구 여부</div>
	                                 <div id="fresh_food_imported_food_statement" class="table_content">${foodRequiredInfo.importedFoodStatement}</div>
	                                 <div class="table_column">상품구성</div>
	                                 <div id="fresh_food_composition" class="table_content">${foodRequiredInfo.composition}</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">보관방법,취급방법</div>
	                                 <div id="fresh_food_storage_type"class="table_content">${foodRequiredInfo.storageType}</div>
	                                 <div class="table_column">소비자안전을 위한 주의사항</div>
	                                 <div id="fresh_food_precautions"  class="table_content">${foodRequiredInfo.precaution}</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">소비자상담관련 전화번호</div>
	                                 <div id="fresh_food_consumer_consultationc_contact" class="table_content">${foodRequiredInfo.csContact}</div>
	                                 <div class="table_column"></div>
	                                 <div class="table_content"></div>
	                              </div>
	                           </div>
                           </c:if>
                           <c:if test="${foodRequiredInfo == null}">
	                           <div class="table_frame">
	                              <div class="table_row">
	                                 <div class="table_column">품목 또는 명칭</div>
	                                 <div id="fresh_food_title" class="table_content">-</div>
	                                 <div class="table_column">포장단위별 내용물의 용량(중량),수량,크기</div>
	                                 <div id="fresh_food_weight" class="table_content">-</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">생산자(수입자)</div>
	                                 <div id="fresh_food_manufacturer" class="table_content">-</div>
	                                 <div class="table_column">원산지</div>
	                                 <div id="fresh_food_origin" class="table_content">-</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">제조연월일, 소비기한 또는 품질유지기한</div>
	                                 <div id="fresh_food_manufacturing_date" class="table_content">-</div>
	                                 <div class="table_column">세부 품목군별 표시사항</div>
	                                 <div id="fresh_food_detail_group" class="table_content">-</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">수입식품 문구 여부</div>
	                                 <div id="fresh_food_imported_food_statement" class="table_content">-</div>
	                                 <div class="table_column">상품구성</div>
	                                 <div id="fresh_food_composition" class="table_content">-</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">보관방법,취급방법</div>
	                                 <div id="fresh_food_storage_type"class="table_content">-</div>
	                                 <div class="table_column">소비자안전을 위한 주의사항</div>
	                                 <div id="fresh_food_precautions"  class="table_content">-</div>
	                              </div>
	                              <div class="table_row">
	                                 <div class="table_column">소비자상담관련 전화번호</div>
	                                 <div id="fresh_food_consumer_consultationc_contact" class="table_content"></div>
	                                 <div class="table_column"></div>
	                                 <div class="table_content"></div>
	                              </div>
	                           </div>
                           </c:if>
                        </div>
                        <div class="product_detail_content">
                           <div class="product_detail_content_inside">
                               <c:if test="${productContentList != null}">
		                           <c:forEach var="Content" items="${productContentList}">
		                               <img src="data:${Content.mediaData};base64, ${Content.base64Img}">
		                           </c:forEach>
	                           </c:if>
                           </div>
                        </div>
                     </div>
                  </li>

                  <!-- 상품평 -->
                  <li id="product_review-form" class="product-review-content">
                     <div class="sdp-review">
                        <div class="sdp-review-guide">상품평 운영원칙</div>
                        <h4 class="sdp-review-title">상품평</h4>
                        <div>
                           <!-- 별점 -->
                           <div class="sdp-review-total-star">
                              <div class="sdp-review-total-star-info">
                              
                              	 <c:if test="${ReviewInfo == null}">
	                              	<div class="sdp-review-total-star-info-gray">
	                                    <div class="sdp-review-total-star-info-orange" style="width: 0px;"></div>
	                                 </div>
	                                 <div class="sdp-review-total-star-info-count">0</div>
			                     </c:if>
			                     <c:if test="${ReviewInfo != null}">
	                              	<div class="sdp-review-total-star-info-gray">
	                                    <div class="sdp-review-total-star-info-orange" style="width: ${ReviewInfo.starRateAvg}%;"></div>
	                                 </div>
	                                 <div class="sdp-review-total-star-info-count">${ReviewInfo.totalReviewScore}</div>
			                     </c:if>
                 			  </div>
                           </div>
                        </div>

                        <div style="margin-top:30px;">
                           <!-- 리뷰 정렬 바 -->
                           <div class="sdp-review-article-order">
                              <div class="sdp-review-article-order-sort">

                                 <button id="bestReviewBtn" class="sdp-review-article-order-sort-best-btn" onclick="bestReviewPage()">베스트순</button>

                                 <div class="sdp-review-article-order-sort-bar">|</div>

                                 <button id="recentReviewBtn" class="sdp-review-article-order-sort-newest-btn">최신순</button>
                              </div>
                              <div class="sdp-review-article-order-search">
                                 <input class="sdp-review-article-order-search-input" type="text"
                                    placeholder="상품평을 검색해보세요." maxlength="30">
                                 <div class="sdp-review-article-order-search-btn">
                                    <img class="sdp-review-article-order-search-btn-img"
                                       src="//img1a.coupangcdn.com/image/productreview/web/pdp/article/search-btn_v1.png">
                                 </div>
                              </div>
                              <div class="sdp-review-article-order-star">
                                 <div class="sdp-review-article-order-star-all">
                                    <div style="display: inline-block;">
                                       <div class="all-content">모든 별점 보기</div>
                                       <c:if test="${ReviewInfo == null}">
                                           <div class="all-count">0</div>
                                       </c:if>
                                       <c:if test="${ReviewInfo != null}">
                                           <div class="all-count">${ReviewInfo.totalReviewScore}</div>
                                       </c:if>
                                       <img class="all-arrow-down"
                                          src="//img1a.coupangcdn.com/image/productreview/web/pdp/article/star-select-down_v1.png"
                                          style="display: inline-block;">
                                    </div>
                                 </div>
                              </div>
                           </div>

                           <!-- 리뷰 상세 글 -->
                           <div id="review-detail-list">
                              <c:if test="${fn:length(ReviewList) == 0 }">
                              	<div class="review-none-items">
                           	  	  	등록된 리뷰가 없습니다.
                           	   	</div>
                              </c:if>
                              <c:if test="${fn:length(ReviewList) != 0}">
                              	<c:forEach var="Review" items="${ReviewList}">
	                              	<article class="sdp-review-article-list">
	                                 <div class="list-info">
	                                    <div class="list-info-user">
	                                       <span class="list-info-user-name">${Review.shopperName}&nbsp;</span>
	                                    </div>
	                                    <div class="list-info-product-info">
	                                       <div class="star-gray">
	                                          <div class="star-orange" style="width: ${Review.starRate}%;"></div>
	                                       </div>
	                                       <div class="reg-date"><fmt:formatDate value="${Review.writeDate}" pattern="yyyy.MM.dd"/></div>
	                                    </div>
	                                    <div class="list-info-product-info-name">${Review.productName}</div>
	                                 </div>
	
	                                 <div class="list-review">
	                                    <div class="list-review-content">
	                                       	${Review.content}
	                                    </div>
	                                 </div>
	 
	                                 <div class="list-help">
	                                    <div id="helpPoint"class="list-help-count"><strong id="helpPointval">${Review.helpPoint}</strong>명에게 도움 됨</div>
	                                    <button class="list-help-btn" onclick="addHelpPoint(${Review.reviewNo})">도움이돼요</button>
	                                    <button class="list-help-report-btn">신고하기</button>
	                                    <div class="sdp-review__clear"></div>
	                                 </div>
	                              </article>
                              	</c:forEach>
                              	
                              	<div class="review-page-btns">
								  <c:if test="${ReviewPager.totalGroupNo > 1}">
									  <c:if test="${ReviewPager.groupNo > 1}">
										  <input type="hidden" value="${ReviewPager.startPageNo-1}">
										  <button class="page-prev review-btn"></button>
									  </c:if>
								  </c:if>
								
								  <c:forEach var="i" begin="${ReviewPager.startPageNo}" end="${ReviewPager.endPageNo}">
								      <c:if test="${ReviewPager.pageNo != i}">
									    <input type="hidden" value="${i}">
										<button class="page-num review-btn">${i}</button>
									  </c:if>
									  <c:if test="${ReviewPager.pageNo == i}">
										<input type="hidden" value="${i}">
										<button class="page-num selected review-btn">${i}</button>
									  </c:if>
								  </c:forEach>
								  
								  <c:if test="${ReviewPager.totalGroupNo > 1}">
									  <c:if test="${ReviewPager.groupNo < ReviewPager.totalGroupNo}">
										  <input type="hidden" value="${ReviewPager.endPageNo+1}">
										  <button class="page-next review-btn"></button>
									  </c:if>
								  </c:if>
	                            </div>
                              </c:if>
                           </div>
                        </div>
                     </div>
                  </li>

                  <!-- 상품 문의 [작업자 : 은지] -->
                  <li id="prduct_qna_form" class="product-inquiry">
                     <div class="product-inquiry-list">
                        <div class="inquiry-title">
                           <h4>상품문의</h4>
                           <a href="#">문의하기</a>
                        </div>
                        <div class="inquiry-notice">
                           <ul>
                              <li>상품문의 및 후기게시판을 통해 취소나 환불, 반품 등은 처리되지 않습니다.</li>
                              <li><strong>가격, 판매자, 교환/환불 및 배송 등 해당 상품 자체와 관련 없는 문의는 고객센터 내 1:1 문의하기</strong>를 이용해주세요.
                              </li>
                              <li><strong>"해당 상품 자체"와 관계없는 글, 양도, 광고성, 욕설, 비방, 도배 등의 글은 예고 없이 이동, 노출제한, 삭제 등의 조치가 취해질 수
                                    있습니다.</strong></li>
                              <li>공개 게시판이므로 전화번호, 메일 주소 등 고객님의 소중한 개인정보는 절대 남기지 말아주세요.</li>
                           </ul>
                        </div>
                        <div class="inquiry-item-container">
                           <c:if test="${fn:length(productInquiryList) == 0}">
                           	   <div class="inquiry-none-items">
                           	  	  <p>등록된 문의가 없습니다.</p>
                           	   </div>
                           </c:if>
                           <c:if test="${fn:length(productInquiryList) != 0}">
	                           <div class="inquiry-items">
	                              <c:forEach var="productInquiry" items="${productInquiryList}">
	                              	 <div class="inquiry-item">
		                                 <span class="inquiry-item-question-label">질문</span>
		                                 <div class="inquiry-item-question">
			                                <div class="inquiry-item-shopper"><strong>${productInquiry.SHOPPER_NAME}</strong></div>
		                                    <div class="inquiry-item-content">${productInquiry.INQUIRY_CONTENT}</div>
		                                    <div class="inquiry-item-time"><fmt:formatDate value="${productInquiry.INQUIRY_DATE}" pattern="yyyy/MM/dd HH:mm:ss"/></div>
		                                 </div>
		                             
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
	                              	 </div>
	                              </c:forEach>
	                           </div>
	                           <div class="inquiry-page-btns">
								  <c:if test="${productInquiryPager.totalGroupNo > 1}">
									  <c:if test="${productInquiryPager.groupNo > 1}">
										  <input type="hidden" value="${productInquiryPager.startPageNo-1}">
										  <button class="page-prev inquiry-btn"></button>
									  </c:if>
								  </c:if>
								
								  <c:forEach var="i" begin="${productInquiryPager.startPageNo}" end="${productInquiryPager.endPageNo}">
								      <c:if test="${productInquiryPager.pageNo != i}">
									    <input type="hidden" value="${i}">
										<button class="page-num inquiry-btn">${i}</button>
									  </c:if>
									  <c:if test="${productInquiryPager.pageNo == i}">
										<input type="hidden" value="${i}">
										<button class="page-num selected inquiry-btn">${i}</button>
									  </c:if>
								  </c:forEach>
								  
								  <c:if test="${productInquiryPager.totalGroupNo > 1}">
									  <c:if test="${productInquiryPager.groupNo < productInquiryPager.totalGroupNo}">
										  <input type="hidden" value="${productInquiryPager.endPageNo+1}">
										  <button class="page-next inquiry-btn"></button>
									  </c:if>
								  </c:if>
	                           </div>
	                    	</c:if>
                        </div>
                        <div class="inquiry-report">
                           <p>판매 부적격 상품 또는 허위과장광고 및 지식재산권을 침해하는 상품의 경우 신고하여 주시기 바랍니다.</p>
                           <a href="#">신고하기</a>
                        </div>
                     </div>
                  </li>
                  
                  <!-- 배송 문의-->
                  <!-- 상품 etc -->
                  <li class="product-etc" id="product-etc-inquery">
                     <h5>배송정보</h5>
                     <div class="product-etc-delivery">
                        <div class="delivery-item-first">
                           <div class="delivery-item-first_left">
                              <div class="delivery-item">
                                 <div class="delivery-item-col">
                                    <span>배송방법</span>
                                 </div>
                                 <div class="delivery-item-content">
                                    신선/냉장/냉동
                                 </div>
                              </div>
                              <div class="delivery-item">
                                 <div class="delivery-item-col">
                                    <span>묶음배송 여부</span>
                                 </div>
                                 <div class="delivery-item-content">
                                    가능
                                 </div>
                              </div>
                           </div>
                           <div class="delivery-item-first_right">
                              <div class="delivery-item">
                                 <div class="delivery-item-col">
                                    <spangn>배송비</span>
                                 </div>
                                 <div class="delivery-item-content">
                                    <ul>
                                       <li>3,000원</li>
                                       <li>- 30,000원 이상 구매 시 무료배송</li>
                                       <li>- 해당 서비스 가능 지역에 한함</li>
                                    </ul>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="delivery-item">
                           <div class="delivery-item-col">
                              <span>배송기간</span>
                           </div>
                           <div class="delivery-item-content">
                              <ul>
                                 <li>- 서비스 이용 지역별 상이</li>
                                 <li>&nbsp;&nbsp;&nbsp;(단, 주문 시간별 도착 예정 시간은 지역 및 상황에 따라 변동될 수 있어, 정확한 정보는 결제 완료 시 안내되는
                                    문구를 꼭 확인 부탁드립니다)</li>
                                 <li>- 천재지변, 물량 수급 변동 등 예외적인 사유 발생 시, 다소 지연될 수 있는 점 양해 부탁드립니다.</li>
                              </ul>
                           </div>
                        </div>
                     </div>
                     <h5>교환/반품 안내</h5>
                     <ul class="return-notice">
                        <li>ㆍ교환/반품에 관한 일반적인 사항은 판매자가 제시사항보다 관계법령이 우선합니다.</li>
                        <li>다만, 판매자의 제시사항이 관계법령보다 소비자에게 유리한 경우에는 판매자 제시사항이 적용됩니다.</li>
                     </ul>
                     <div class="product-etc-return">
                        <div class="return-item">
                           <div class="return-item-col">
                              <span>교환/반품 비용</span>
                           </div>
                           <div class="return-item-content">
                              <ul>
                                 <li>1) [총 주문금액] - [반품 상품금액] = 19,800원 미만인 경우 반품비 5,000원</li>
                                 <li>2) [총 주문금액] - [반품 상품금액] = 19,800원 이상인 경우 반품비 2,500원</li>
                              </ul>
                           </div>
                        </div>
                        <div class="return-item">
                           <div class="return-item-col">
                              <span>교환/반품 신청 기준일</span>
                           </div>
                           <div class="return-item-content">
                              <ul>
                                 <li>ㆍ배송시작 후에는 취소가 불가하며, 배송완료 후 반품을 진행하실 수 있습니다. 단, 신선/냉장/냉동 상품의 단순변심의</li>
                                 <li>&nbsp;&nbsp;&nbsp;경우 재판매가 불가한 상품의 특성 상 단순변심에 의한 반품이 제한됩니다.</li>
                                 <li>ㆍ상품의 내용이 표시·광고의 내용과 다른 경우에는 상품을 수령한 날부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터
                                    <br /> 30일 이내에 청약철회 가능
                                 </li>
                              </ul>
                           </div>
                        </div>
                     </div>
                     <h5>교환/반품 제한사항</h5>
                     <ul class="limit-list">
                        <li>ㆍ주문/제작 상품의 경우, 상품의 제작이 이미 진행된 경우</li>
                        <li>ㆍ상품 포장을 개봉하여 사용 또는 설치 완료되어 상품의 가치가 훼손된 경우 (단, 내용 확인을 위한 포장 개봉의 경우는 예외)</li>
                        <li>ㆍ고객의 사용, 시간경과, 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우</li>
                        <li>ㆍ세트상품 일부 사용, 구성품을 분실하였거나 취급 부주의로 인한 파손/고장/오염으로 재판매 불가한 경우</li>
                        <li>ㆍ모니터 해상도의 차이로 인해 색상이나 이미지가 실제와 달라, 고객이 단순 변심으로 교환/반품을 무료로 요청하는 경우</li>
                        <li>ㆍ제조사의 사정 (신모델 출시 등) 및 부품 가격 변동 등에 의해 무료 교환/반품으로 요청하는 경우</li>
                     </ul>
                     <h5>판매자 정보</h5>
                     <div class="product-etc-seller">
                        <div class="seller-item">
                           <div class="seller-item-col">
                              <span>판매자</span>
                           </div>
                           <div class="seller-item-content">
                              푸릇라이트 1588-8282
                           </div>
                        </div>
                     </div>
                     <p class="product-etc-notice">미성년자가 체결한 계약은 법정대리인이 동의하지 않는 경우 본인 또는 법정대리인이 취소할 수 있습니다.</p>
                  </li>
               </ul>
            </div>

         </div>
      </div>

      <footer class="footer-frame">
      </footer>
   </div>
</body>

</html>