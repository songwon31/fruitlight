<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" type="image/x-icon">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css"/>
		<title>main </title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/header.js"></script>
		<script src="${pageContext.request.contextPath}/resources/javascript/main.js"></script>
	</head>
	<body>
<%@ include file="/WEB-INF/views/header.jsp" %>
	<div id="body-container">
   		<div id="mainproduct" class="carousel slide" data-ride="carousel" style="height: 10%;">
			<ul class="carousel-indicators">
			    <li data-target="#mainproduct" data-slide-to="0" class="active"></li>
			    <li data-target="#mainproduct" data-slide-to="1"></li>
			    <li data-target="#mainproduct" data-slide-to="2"></li>
			</ul>
			<div class="carousel-inner">
				<c:forEach var="product" items="${productlist}" varStatus="i">
					<div id="carouselMainItem${i.count}" class="carousel-item" style="height: 10%;">
						<a href="/fruitlight/main/SelectDetailView?pid=${product.PRODUCT_NO}">
					        <img src="data:${product.MEDIA_DATA};base64, ${product.base64Img}" width="1100px">
						</a>
				    </div>
				</c:forEach>
			</div>
			<a class="carousel-control-prev" href="#mainproduct" data-slide="prev">
			    <span class="carousel-control-prev-icon"></span>
			</a>
			<a class="carousel-control-next" href="#mainproduct" data-slide="next">
			    <span class="carousel-control-next-icon"></span>
			</a>
		</div>
	      	
	      	<div class="todayDiscoveryContainer">
	      		<div class="todayDiscoveryHottext pt-4">
   					<span class="px-2 font-weight-bold">오늘의 발견</span>
   				</div>
			      	<div id="todayDiscovery" class="todayDiscovery container">
			      		 <div class="row">
					     <c:forEach var="todaylist" items="${todaylists}">
				      		<div id="todayDiscoveryProduct" class="todayDiscoveryProduct col-md col-sm-12">
					      		<div>
					      			<div>
						      			<a href="/fruitlight/main/SelectDetailView?pid=${todaylist.PRODUCT_NO}">
						      				<img class="productImage" src="data:${todaylist.MEDIA_DATA};base64, ${todaylist.base64Img}"/>
						      			</a>
						      		</div>
						      		<div class="productNameHolder">
						      			<a id="productName" class="productName" href="detailView?pid=${todaylist.PRODUCT_NO}">${todaylist.PRODUCT_NAME}</a>
						      		</div>
						      		<div id="price" class="price">
										<c:if test="${todaylist.DISCOUNT_RATE != 0}">
											<div id="productPriceArea" class="productPriceArea">
												<span id="productDisrate" class="productDisrate">${todaylist.DISCOUNT_RATE}%</span>
												<del id="productDiscountPrice"class="productDiscountPrice"><fmt:formatNumber value="${todaylist.PRODUCT_PRICE}" pattern="#,###"/>원</del>
											</div>
										</c:if>
											<span id="productPrice" class="productPrice"><fmt:formatNumber value="${todaylist.DISCOUNT_PRICE}" pattern="#,###"/>원</span>
									</div>
								</div>
				      		</div>
		      			</c:forEach>
	      			</div>
		      	</div>
	      	</div>
			<div class="todaySellerContainer">
	      		<div class="todaySellerHottext pt-4">
   					<span class="px-2 font-weight-bold">오늘의 판매자 특가</span>
   				</div>
		      	<div id="todaySeller" class="todaySeller container">
		      		<div class="row"> 
			      		<c:forEach var="sellerlist" items="${sellerlists}">
				      		<div id="todaySellerProduct" class="todaySellerProduct col-md">
				      			<div>
				      				<a href="/fruitlight/main/SelectDetailView?pid=${sellerlist.PRODUCT_NO}">
						      			<img class="productImage" src="data:${sellerlist.MEDIA_DATA};base64, ${sellerlist.base64Img}"/>
				      				</a>
					      		</div>
					      		<c:if test="${sellerlist.DISCOUNT_RATE != 0}">
						      		<div class="productDiscountHolder">
						      		<em>
						      			지금 <span>${sellerlist.DISCOUNT_RATE}%</span> 할인중!
						      		</em>
						      		</div>
					      		</c:if>
					      		<div class="productNameHolder">
					      			<a href="detailView?pid=${sellerlist.PRODUCT_NO}"id="productName" class="productName">${sellerlist.PRODUCT_NAME}</a>
					      		</div>
					      		<div id="price" class="price">
										<span id="productPrice" class="productPrice"><fmt:formatNumber value="${sellerlist.DISCOUNT_PRICE}" pattern="#,###"/>원</span>
								</div>
				      		</div>
			      		</c:forEach>
			    	</div>
		    	</div>
		    </div>
   			<div id="cateAdvertise" class="cateAdvertise">
   				<p>HOT! TREND</p>
   				<span>카테고리 별</span>
   				<span style="color : #4285f4;">추천 광고상품</span>
   				<div id="cateAdvertiseCherry" class="cateAdvertiseCherry">
   					<dl>
   						<dt id="cateAdvertiseCherryTitle" class="cateAdvertiseCherryTitle">
   							<span>체리</span>
   							<a href="list?search=체리">&nbsp;바로가기 ></a>
   						</dt>
   						<dd id="cateAdvertiseCherryPromotion" class="cateAdvertiseCherryPromotion">
   							<div id="demo1" class="carousel slide" data-ride="carousel" style="height:300px;">
								<ul class="carousel-indicators">
							    	<li data-target="#demo1" data-slide-to="0" class="active"></li>
							    	<li data-target="#demo1" data-slide-to="1"></li>
							    	<li data-target="#demo1" data-slide-to="2"></li>
							  	</ul>
								<div class="carousel-inner" style="height:300px;">
							  		<c:forEach var="catemainlist" items="${catemainlists}" varStatus="i" begin="0" end="2">
									    <div id="carouselCate1MainItem${i.count}" class="carousel-item">
									    	<a href="/fruitlight/main/SelectDetailView?pid=${catemainlist.PRODUCT_NO}">
										    	<img src="data:${catemainlist.MEDIA_DATA};base64, ${catemainlist.base64Img}" width="500" height="500">
									    	</a>
									    	<div class="carousel-caption cherry">
									      		<h3>체리 특가!</h3>
									        	<p>신선하고 맛있는 체리 특가 판매중</p>
									      	</div>  
										</div>
							  		</c:forEach>
								</div>
								<a class="carousel-control-prev" href="#demo1" data-slide="prev">
									<span class="carousel-control-prev-icon"></span>
								</a>
								<a class="carousel-control-next" href="#demo1" data-slide="next">
									<span class="carousel-control-next-icon"></span>
								</a>
							</div>
   						</dd>
   						<dd id="cateAdvertiseCherryList" class="cateAdvertiseCherryList">
   							<div id="demo2" class="carousel slide" data-ride="carousel" style="height:300px;">
								<ul class="carousel-indicators">
					    	<li data-target="#demo2" data-slide-to="0" class="active bg-dark"></li>
					    	<li data-target="#demo2" data-slide-to="1" class="bg-dark"></li>
					    	<li data-target="#demo2" data-slide-to="2" class="bg-dark"></li>
					  	</ul>
					  	<div class="carousel-inner">
						    <div class="carousel-item active">
						    	<ul id="cateAdvertiseCherryListList1" class="cateAdvertiseCherryListList">
						    		<c:forEach var="catesublist" items="${catesublists}" begin="0" step="3" end="6">
							    		<li id="cateAdvertiseCherryListItem" class="cateAdvertiseCherryListItem">
							    			<a href="/fruitlight/main/SelectDetailView?pid=${catesublist.PRODUCT_NO}">
							    				<img src="data:${catesublist.MEDIA_DATA};base64, ${catesublist.base64Img}"/>
							    				<span id="hoverUnderline" class="hoverUnderline">${catesublist.PRODUCT_NAME}</span>
							    				<span>
							    					<strong><fmt:formatNumber value="${catesublist.PRODUCT_PRICE}" pattern="#,###"/></strong>원
							    				</span>	
							    			</a>
							    		</li>
						    		</c:forEach>
						    	</ul>
							</div>
							<div class="carousel-item">
								<ul id="cateAdvertiseCherryListList2" class="cateAdvertiseCherryListList">
						    		<c:forEach var="catesublist" items="${catesublists}" begin="4" end="6">
							    		<li id="cateAdvertiseCherryListItem" class="cateAdvertiseCherryListItem">
							    			<a href="/fruitlight/main/SelectDetailView?pid=${catesublist.PRODUCT_NO}">
							    				<img src="data:${catesublist.MEDIA_DATA};base64, ${catesublist.base64Img}"/>
							    				<span id="hoverUnderline" class="hoverUnderline">${catesublist.PRODUCT_NAME}</span>
							    				<span>
							    					<strong><fmt:formatNumber value="${catesublist.PRODUCT_PRICE}" pattern="#,###"/></strong>원
							    				</span>	
							    			</a>
							    		</li>
						    		</c:forEach>
						    	</ul>
						  	</div>
						  	<div class="carousel-item">
								<ul id="cateAdvertiseCherryListList3" class="cateAdvertiseCherryListList">
						    		<c:forEach var="catesublist" items="${catesublists}" begin="7" end="9">
							    		<li id="cateAdvertiseCherryListItem" class="cateAdvertiseCherryListItem">
							    			<a href="/fruitlight/main/SelectDetailView?pid=${catesublist.PRODUCT_NO}">
							    				<img src="data:${catesublist.MEDIA_DATA};base64, ${catesublist.base64Img}"/>
							    				<span id="hoverUnderline" class="hoverUnderline">${catesublist.PRODUCT_NAME}</span>
							    				<span>
							    					<strong><fmt:formatNumber value="${catesublist.PRODUCT_PRICE}" pattern="#,###"/></strong>원
							    				</span>	
							    			</a>
							    		</li>
						    		</c:forEach>
						    	</ul>
							</div>
						</div>
						<a class="carousel-control-prev" href="#demo2" data-slide="prev">
							<span class="carousel-control-prev-icon bg-dark"></span>
						</a>
						<a class="carousel-control-next" href="#demo2" data-slide="next">
							<span class="carousel-control-next-icon bg-dark"></span>
						</a>
					</div>
   						</dd>
   					</dl>
   				</div>
   				<div id="cateAdvertiseWatermelon" class="cateAdvertiseWatermelon">
   					<dl>
   						<dt id="cateAdvertiseWatermelonTitle" class="cateAdvertiseWatermelonTitle">
   							<span>수박</span>
   							<a href="list?search=수박">&nbsp;바로가기 ></a>
   						</dt>
   						<dd id="cateAdvertiseWatermelonPromotion" class="cateAdvertiseWatermelonPromotion">
   							<div id="demo3" class="carousel slide" data-ride="carousel" style="height:300px;">
								<ul class="carousel-indicators">
							    	<li data-target="#demo3" data-slide-to="0" class="active"></li>
							    	<li data-target="#demo3" data-slide-to="1"></li>
							    	<li data-target="#demo3" data-slide-to="2"></li>
							  	</ul>
								<div class="carousel-inner" style="height:300px;">
							  		<c:forEach var="catemainlist" items="${catemainlists}" varStatus="i" begin="3" end="5">
									    <div id="carouselCate2MainItem${i.count}" class="carousel-item">
									    	<a href="/fruitlight/main/SelectDetailView?pid=${catemainlist.PRODUCT_NO}">
										    	<img src="data:${catemainlist.MEDIA_DATA};base64, ${catemainlist.base64Img}" width="500" height="500">
									    	</a>
									    	<div class="carousel-caption watermelon">
									      		<h3>수박 특가!</h3>
									        	<p>여름철 더위를 날려줄 수박 판매!</p>
									      	</div>  
										</div>
							  		</c:forEach>
								</div>
								<a class="carousel-control-prev" href="#demo3" data-slide="prev">
									<span class="carousel-control-prev-icon"></span>
								</a>
								<a class="carousel-control-next" href="#demo3" data-slide="next">
									<span class="carousel-control-next-icon"></span>
								</a>
							</div>
   						</dd>
   						<dd id="cateAdvertiseWatermelonList" class="cateAdvertiseWatermelonList">
   							<div id="demo4" class="carousel slide" data-ride="carousel" style="height:300px;">
								<ul class="carousel-indicators">
					    	<li data-target="#demo4" data-slide-to="0" class="active bg-dark"></li>
					    	<li data-target="#demo4" data-slide-to="1" class="bg-dark"></li>
					    	<li data-target="#demo4" data-slide-to="2" class="bg-dark"></li>
					  	</ul>
					  	<div class="carousel-inner">
						    <div class="carousel-item active">
						    	<ul id="cateAdvertiseWatermelonListList1" class="cateAdvertiseWatermelonListList">
						    		<c:forEach var="catesublist" items="${catesublists}" begin="1" step="1" end="2">
							    		<li id="cateAdvertiseWatermelonListItem" class="cateAdvertiseWatermelonListItem">
							    			<a href="/fruitlight/main/SelectDetailView?pid=${catesublist.PRODUCT_NO}">
							    				<img src="data:${catesublist.MEDIA_DATA};base64, ${catesublist.base64Img}"/>
							    				<span id="hoverUnderline" class="hoverUnderline">${catesublist.PRODUCT_NAME}</span>
							    				<span>
							    					<strong><fmt:formatNumber value="${catesublist.PRODUCT_PRICE}" pattern="#,###"/></strong>원
							    				</span>	
							    			</a>
							    		</li>
						    		</c:forEach>
						    		<li id="cateAdvertiseWatermelonListItem" class="cateAdvertiseWatermelonListItem">
						    			<a href="/fruitlight/main/SelectDetailView?pid=${catesublists[10].PRODUCT_NO}">
						    				<img src="data:${catesublists[10].MEDIA_DATA};base64, ${catesublists[10].base64Img}"/>
						    				<span id="hoverUnderline" class="hoverUnderline">${catesublists[10].PRODUCT_NAME}</span>
						    				<span>
						    					<strong><fmt:formatNumber value="${catesublists[10].PRODUCT_PRICE}" pattern="#,###"/></strong>원
						    				</span>	
						    			</a>
						    		</li>
						    	</ul>
							</div>
							<div class="carousel-item">
								<ul id="cateAdvertiseWatermelonListList2" class="cateAdvertiseWatermelonListList">
						    		<c:forEach var="catesublist" items="${catesublists}" begin="11" end="13">
							    		<li id="cateAdvertiseWatermelonListItem" class="cateAdvertiseWatermelonListItem">
							    			<a href="/fruitlight/main/SelectDetailView?pid=${catesublist.PRODUCT_NO}">
							    				<img src="data:${catesublist.MEDIA_DATA};base64, ${catesublist.base64Img}"/>
							    				<span id="hoverUnderline" class="hoverUnderline">${catesublist.PRODUCT_NAME}</span>
							    				<span>
							    					<strong><fmt:formatNumber value="${catesublist.PRODUCT_PRICE}" pattern="#,###"/></strong>원
							    				</span>	
							    			</a>
							    		</li>
						    		</c:forEach>
						    	</ul>
						  	</div>
						  	<div class="carousel-item">
								<ul id="cateAdvertiseWatermelonListList3" class="cateAdvertiseWatermelonListList">
						    		<c:forEach var="catesublist" items="${catesublists}" begin="13" end="15">
							    		<li id="cateAdvertiseWatermelonListItem" class="cateAdvertiseWatermelonListItem">
							    			<a href="/fruitlight/main/SelectDetailView?pid=${catesublist.PRODUCT_NO}">
							    				<img src="data:${catesublist.MEDIA_DATA};base64, ${catesublist.base64Img}"/>
							    				<span id="hoverUnderline" class="hoverUnderline">${catesublist.PRODUCT_NAME}</span>
							    				<span>
							    					<strong><fmt:formatNumber value="${catesublist.PRODUCT_PRICE}" pattern="#,###"/></strong>원
							    				</span>	
							    			</a>
							    		</li>
						    		</c:forEach>
						    	</ul>
							</div>
						</div>
						<a class="carousel-control-prev" href="#demo4" data-slide="prev">
							<span class="carousel-control-prev-icon bg-dark"></span>
						</a>
						<a class="carousel-control-next" href="#demo4" data-slide="next">
							<span class="carousel-control-next-icon bg-dark"></span>
						</a>
					</div>
   						</dd>
   					</dl>
   				</div>
    		</div>
   		</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
	</body>
</html>