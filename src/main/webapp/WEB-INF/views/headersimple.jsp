<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container">
	<div id="header1" class="headertop d-block row">
		<div id="headerIcon" class="headerIcon">
			<c:if test="${ShopperInfo == null}">
				<a class="mr-2 mt-2 text-right" href="login">
					로그인
				</a>
			</c:if>
			<c:if test="${ShopperInfo != null}">
				<a class="mr-2 mt-2 text-right" href="logout">
					로그아웃
				</a>
			</c:if>
				<a class="mr-2 mt-2 text-right" href="cart">
					장바구니
				</a>
			<c:if test="${ShopperInfo != null}">
            	<a class="mr-2 mt-2 text-right" href="mypageOrdered?sid=${ShopperInfo.shopperNo}">
            		마이페이지
                </a>
            </c:if>				
		</div>
	</div>
	<div id="header2" class="headerlogowrapper">
		<div id="headerLogo" class="headerLogo">
			<a href="main">
				<img src="${pageContext.request.contextPath}/resources/images/fruitlight_logo_new.png" style="width:50%; margin: 0 auto"/>
				<span id="prevnext" style="display:none">1</span>			
			</a>
		</div>
	</div>
</div>
