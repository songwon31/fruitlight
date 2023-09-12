function menuprev(){
	$("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left-gray@2x.png)");
	$("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
	$("#menus").css("transform","translateX(0px)")
	$("#menu-btn2").attr("disabled",true);
	$("#menu-btn1").attr("disabled",false);
}
function menunext(){
	$("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right-gray@2x.png)");
	$("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left@2x.png)");
	$("#menus").css("transform","translateX(-190px)")
	$("#menu-btn1").attr("disabled",true);
	$("#menu-btn2").attr("disabled",false);
}

function yearselect1(){
	$(".mycoupang-main-year > div > div").removeClass("selected");
	$("#sel1").addClass("selected");
	$.getJSON("../ajax/mypage_content.txt",function(data){
		var html = "";
		var today = new Date();
		var sixm = new Date(today);
		var sixcm = sixm.setMonth(today.getMonth()-6);
		$.each(data, function(index, item){
			var sixn = new Date(item.orderdate);
			if(sixcm < sixn){
				html +=		'<div class="exist">';
				html += 		'<div class="order-date-line">';
				html += 			'<div class="left">'+ item.orderdate+'주문</div>';
				html +=				'<div class="right"><span>주문 상세보기</span></div>';
				html +=			'</div>';
				html +=			'<div class="order-product">';
				html +=				'<table>';
				html +=					'<tbody>';
				html +=						'<tr>';
				html +=							'<td class="order-product-left">';
				html +=								'<div class="top">';
				html +=									'<div class="left">';
				html +=										'<span>'+item.currentdeli+'</span>';
				html +=										'<span class="dot">';
				html +=											'<span></span>';
				html +=										'</span>';
				html +=										'<span class="arrivedate">'+item.arrivedate+'도착</span>';
				html +=									'</div>';
				html +=									'<div class="right">';
				html +=										'<button>';
				html +=											'<div></div>';
				html +=											'<div></div>';
				html +=											'<div></div>';
				html +=										'</button>';
				html +=									'</div>';
				html +=								'</div>'
				html +=								'<div class="bottom">';
				html +=									'<div>';
				html +=										'<div style="display:none;"></div>';
				html +=										'<div class="product-content">';
				html +=											'<div class="bottom-flex">';
				html +=												'<div class="image"><a><img/></a></div>';
				html +=												'<div class="content">';
				html +=													'<div>';
				html +=														'<a href="#">';
				html +=															'<img height="16" src="'+item.delikind+'">';
				html +=															'<span style="color:#111111";>'+item.name+'</span>';
				html +=														'</a>';
				html +=														'<div>';
				html +=															'<div class="price-ammount">';
				html +=																'<span class="price">'+item.price+'원&nbsp;</span>';
				html +=																'<span class="ammount">'+item.ammount+'개</span>';
				html +=															'</div>';
				html +=															'<div class="gotocart">';
				html +=																'<button>장바구니 담기</button>';
				html +=															'</div>';
				html +=														'</div>';
				html +=													'</div>';
				html +=												'</div>';
				html +=											'</div>';
				html +=										'</div>';
				html +=									'</div>';
				html +=								'</div>';
				html +=							'</td>';
				html +=							'<td class="order-product-right">';
				html +=								'<div class="buttons">';
				html +=									'<button class="delisearch">배송조회</button>';
				html +=									'<button class="trade">교환, 반품 신청</button>';
				html +=								'</div>';
				html +=							'</td>';
				html +=						'</tr>';
				html +=					'</tbody>';
				html +=				'</table>';
				html +=			'</div>';
				html += 	'</div>';
			} 
		});
		$.each(data, function(index, item){
			var sixn = new Date(item.orderdate);
			if(sixcm < sixn){
				html += 	'<div class="prev-next">';
				html +=			'<button>이전</button>';
				html +=			'<button>다음</button>';
				html += 	'</div>';
				html += '</div>';
			} else {
				return;
			}
		});
		$(".mycoupang-product-content").html(html);
		/*if($(".mycoupang-product-content").){
			$(".mycoupang-product-content").addClass("none");
			html +=	'<div>최근 6개월간 주문하신 내역이 없습니다.';
			html +=		'<span>2023년 주문 보기</span>';
			html +=	'</div>';
		}*/
	});
}

function yearselect2(){
	$(".mycoupang-main-year > div > div").removeClass("selected");
	$("#sel2").addClass("selected");
}

function yearselect3(){
	$(".mycoupang-main-year > div > div").removeClass("selected");
	$("#sel3").addClass("selected");
}

function yearselect4(){
	$(".mycoupang-main-year > div > div").removeClass("selected");
	$("#sel4").addClass("selected");
}

function yearselect5(){
	$(".mycoupang-main-year > div > div").removeClass("selected");
	$("#sel5").addClass("selected");
}

function yearselect6(){
	$(".mycoupang-main-year > div > div").removeClass("selected");
	$("#sel6").addClass("selected");
}

function yearselect7(){
	$(".mycoupang-main-year > div > div").removeClass("selected");
	$("#sel7").addClass("selected");
}

function searall(){
	$(".search-wrapper > div").removeClass("search-selected");
	$(".search-wrapper > div").addClass("search-default");
	$("#search1").removeClass("search-default");
	$("#search1").addClass("search-selected");
}
function seardeli(){
	$(".search-wrapper > div").removeClass("search-selected");
	$(".search-wrapper > div").addClass("search-default");
	$("#search2").removeClass("search-default");
	$("#search2").addClass("search-selected");
}
function seartour(){
	$(".search-wrapper > div").removeClass("search-selected");
	$(".search-wrapper > div").addClass("search-default");
	$("#search3").removeClass("search-default");
	$("#search3").addClass("search-selected");
}
function seartick(){
	$(".search-wrapper > div").removeClass("search-selected");
	$(".search-wrapper > div").addClass("search-default");
	$("#search4").removeClass("search-default");
	$("#search4").addClass("search-selected");
}


/*
 * productkind : 상품 유형
 * orderdate : 주문일
 * currentdeli : 배송 현황
 * arrivedate : 배송 도착일
 * delikind : 배송 종류(로켓 배송, 로켓 후레시 등등)
 * name : 상품 명
 * price : 가격
 * ammount : 주문 수량
 */