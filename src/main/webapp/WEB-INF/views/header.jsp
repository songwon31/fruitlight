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
           	<a class="mr-2 mt-2 text-right" href="mypageOrdered?sid=${ShopperInfo.shopperNo}">
           		마이페이지
            </a>
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
	
	<div id="menu" class="menu">
		<div class="rowbtn2">
        	<a id="menu-btn2" class="menu-btn2" onclick="menuprev()"></a>
        </div>
		<div class="gnb_menu_box">
    		<ul id="menus" class="depth0 gnb_menu0" style="overflow: visible; height: 100%; width:950px">
    			<li>
		            <a href="list?search=못난이" class="searchLink" data-search="못난이">못난이 과일</a>
		        </li>
		        <li>
		            <a href="list?search=수박" class="searchLink" data-search="수박">수박</a>
		        </li>
		        <li>
		            <a href="list?search=참외" class="searchLink" data-search="참외">참외</a>
		        </li>
		        <li>
		            <a href="list?search=체리" class="searchLink" data-search="체리">체리</a>
		        </li>
		        <li>
		            <a href="list?search=아보카도" class="searchLink" data-search="아보카도">아보카도</a>
		        </li>
		        <li>
		            <a href="list?search=망고" class="searchLink" data-search="망고">망고</a>
		        </li>
		        <li>
		            <a href="list?search=바나나" class="searchLink" data-search="바나나">바나나</a>
		        </li>
		        <li>
		            <a href="list?search=오렌지" class="searchLink" data-search="오렌지">오렌지</a>
		        </li>
		     </ul>
		</div>
		<div class="rowbtn1">
        	<a id="menu-btn1" class="menu-btn1" onclick="menunext()"></a>
        </div>
	</div>	
</div>
