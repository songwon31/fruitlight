$(init);

function init() {
	//금액 xxx,xxx원 적용
	initPriceFormat();
	
	//메인이미지 변경 동작
	$(".productItems li img").hover(changeMain);
	//찜 동작
	$(".product-wish-btn").click(changeWish);
	//옵션 선택 동작
	$(".product-option-btn").click(openOption);
	$(".product-option-list-item").click(chooseOption);
	
	//상품옵션수량 변경 동작
	$(".product-quantity-plus-btn").click(changeQuantityPlus);
	$(".product-quantity-minus-btn").click(changeQuantityMinus);
	$(".product-quantity-input").change(changeQuantityInput);
	//상품옵션 삭제 동작
	$(".productDelete").click(deleteOption);
	
	//상품리뷰 페이저 버튼
	$(".review-btn").click(changeReviewPage);
	
	//상품리뷰 검색 버튼
	$(".sdp-review-article-order-search-btn").click(searchReviewPage);
	
	//상품리뷰 베스트 순 정렬 버튼
	$("#bestReviewBtn").click(bestReviewPage);
	
	//상품리뷰 최신순 정렬 버튼
	$("#recentReviewBtn").click(recentReviewPage);
	
	//상품문의 페이저 버튼
	$(".inquiry-btn").click(changeInquiryPage);
	
	//장바구니 담기
	$(".product-cart-btn").click(addCart);
	//바로구매
	$(".product-buy-btn").click(buy);
	const catehandle1 = window.matchMedia(`(min-width: 1200px)`);
	if(catehandle1.matches === true){
	      $("#menu-btn1").removeClass("d-block");
	      $("#menu-btn2").removeClass("d-block");
	      $("#menu-btn1").addClass("d-none");
	      $("#menu-btn2").addClass("d-none");
	      $("#menus").css("transform","translateX(0px)");
	      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
	      $("#menu-btn2").css("backgroundImage","none");
	   }
}
//금액 xxx,xxx원 적용
function initPriceFormat() {
	$(".total-price").html(parseInt($(".total-price").html()).toLocaleString("ko-KR") + "원");
	$(".option-item-price").each((index, item) => {
		$(item).html(" : " + parseInt($(item).html().replace(/[^0-9]/g, "")).toLocaleString("ko-KR") + "원");
    });
	$(".product-option-originalPrice-txt").each((index, item) => {
		$(item).html(parseInt($(item).html().replace(/[^0-9]/g, "")).toLocaleString("ko-KR") + "원");
	});
}

//메인이미지 변경 동작
function changeMain() {
	var imgSrc = $(event.target).attr("src");
	$(".productMainImage").attr("src", imgSrc);
}

//찜 동작
function changeWish() {
	var wishBtn = $(event.target);
	
	if(wishBtn.val() == "on") {
		wishBtn.css("background", "url('//img1a.coupangcdn.com/image/dragonstone/sdp/PCSDP_imageasset_180417-min.png')");
		wishBtn.css("background-position", "-218px -209px");
		wishBtn.attr("value", "off");
	}
	else {
		wishBtn.css("background", "url('//img1a.coupangcdn.com/image/dragonstone/sdp/PCSDP_imageasset_180417-min.png')");
		wishBtn.css("background-position", "-262px -209px");
		wishBtn.attr("value", "on");
	}
}

//옵션 선택 동작
function openOption() {
	$(event.target).toggleClass("clicked");
	
	if($(".product-option-ico.open").css("display") == "none") {
		$(".product-option-ico.closed").css("display", "none");
		$(".product-option-ico.open").css("display", "inline-block");
	} else if($(".product-option-ico.closed").css("display") == "none") {
		$(".product-option-ico.closed").css("display", "inline-block");
		$(".product-option-ico.open").css("display", "none");
	}
	/*$(".product-option-ico").toggleClass("closed");*/
	$(".product-options-list").toggleClass("closed");
}
function chooseOption() {
	var pid = $(event.target).attr("id");
	if(pid != undefined) {
		$(".product-option-tableBody").children("." + pid).addClass("selected");
	} else {
		pid = $(event.target).parent().attr("id");
		$(".product-option-tableBody").children("." + pid).addClass("selected");
	}
	$(".product-options-list").toggleClass("closed");
}

//상품수량 변경 동작
function changeQuantityPlus() {
	//현재 수량
	var productQuantityInput = $(event.target).parent().prev();
	var quantityCurrent = productQuantityInput.val();
	
	if(quantityCurrent == 1) {
		$(event.target).next().prop("disabled", false);
		$(event.target).next().attr("disabled", false);
	}
	productQuantityInput.prop("value", ++quantityCurrent);
	productQuantityInput.attr("value", quantityCurrent);
	
	var optionTableRow = $(event.target).parent().parent().parent().parent().parent();
	
	//상품가격 변경 동작
	changePrice(optionTableRow);
}
function changeQuantityMinus() {
	//현재 수량
	var productQuantityInput = $(event.target).parent().prev();
	var quantityCurrent = productQuantityInput.val();
	
	productQuantityInput.prop("value", --quantityCurrent);
	productQuantityInput.attr("value", quantityCurrent);
	if(quantityCurrent == 1) {
		$(event.target).prop("disabled", true);
		$(event.target).attr("disabled", true);
	}
	
	var optionTableRow = $(event.target).parent().parent().parent().parent().parent();
	
	//상품가격 변경 동작
	changePrice(optionTableRow);
}
function changeQuantityInput() {
	//현재 수량
	var quantityCurrent = $(event.target).val();
	var quantityMin = $(event.target).attr("min");
	
	if(quantityCurrent == "" || quantityCurrent <= quantityMin) {
		quantityCurrent = quantityMin;
		$(event.target).next().children(".product-quantity-minus-btn").prop("disabled", true);
		$(event.target).next().children(".product-quantity-minus-btn").attr("disabled", true);
	}
	else if(quantityCurrent > 1) {
		$(event.target).next().children(".product-quantity-minus-btn:disabled").prop("disabled", false);
		$(event.target).next().children(".product-quantity-minus-btn:disabled").attr("disabled", false);
	}
	
	$(event.target).prop("value", quantityCurrent);
	$(event.target).attr("value", quantityCurrent);
	
	var optionTableRow = $(event.target).parent().parent().parent().parent();
	
	//상품가격 변경 동작
	changePrice(optionTableRow);
}
//상품가격 변경 동작
function changePrice(optionTableRow) {
	var unitPrice = optionTableRow.find(".product-option-originalPrice").val();
	var quantityCurrent = parseInt(optionTableRow.find(".product-quantity-input").val());
	var quantityMax = parseInt(optionTableRow.find(".product-quantity-input").attr("max"));
	
	if(quantityCurrent > quantityMax) {
		optionTableRow.find(".product-quantity-input").prop("value", quantityMax);
		optionTableRow.find(".product-quantity-input").attr("value", quantityMax);
		quantityCurrent = quantityMax;
	}
	
	var newPrice = quantityCurrent * unitPrice;
	
	optionTableRow.find(".product-option-originalPrice-txt").html(newPrice.toLocaleString("ko-KR") + "원");
}

//상품옵션 삭제 동작
function deleteOption() {
	$(event.target).parent().parent().removeClass("selected");
}

//상품문의 페이저
function changeInquiryPage() {
	var toGoPage = $(event.target).prev().val();
	
	console.log(toGoPage);
	
	$.ajax({
		url: "/fruitlight/detailView/moveInquiryPage",
		method: "get",
		data: {
			pageNo:toGoPage
		},
		success: function(data) {
			let html = '';
			
			if(data.productInquiryList.length != 0) {
				html += '	<div class="inquiry-items">';

				$.each(data.productInquiryList, function(index, item) {
					html += '			<div class="inquiry-item">';
					html += '				<span class="inquiry-item-question-label">질문</span>';
					html += '				<div class="inquiry-item-question">';
					html += '					<div class="inquiry-item-shopper"><strong>' + item.shopper_NAME + '</strong></div>';
					html += '					<div class="inquiry-item-content">' + item.inquiry_CONTENT + '</div>';
					html += '					<div class="inquiry-item-time">' + item.strInquiryDate + '</div>';
					html += '				</div>';
					
					if(item.emptanswer == false) {
						html += '					<div class="inquiry-item-answer">';
						html += '						<i></i>';
						html += '						<span class="inquiry-item-answer-label">답변</span>';
						html += '						<div class="inquiry-item-answer-wrap">';
						html += '							<div class="inquiry-item-seller"><strong>[FRUITLIGHT]</strong></div>';
						html += '							<div class="inquiry-item-answer-content">' + item.answer_CONTENT + '</div>';
						html += '							<div class="inquiry-item-answer-time">' + item.strAnswerDate + '</div>';
						html += '						</div>';
						html += '					</div>';
					}
					html += '			</div>';
				});
				
				html += '	</div>';
				html += '	<div class="review-page-btns">';
				
				if(data.productInquiryPager.totalGroupNo > 1) {
					if(data.productInquiryPager.groupNo > 1) {
						console.log(data.productInquiryPager.startPageNo-1)
						var prevPage = data.productInquiryPager.startPageNo-1
						html += '				<input type="hidden" value="' + prevPage + '">';
						html += '				<button class="page-prev inquiry-btn"></button>';
					}
				}
				
				for(let i=data.productInquiryPager.startPageNo; i<=data.productInquiryPager.endPageNo; i++) {
					if(data.productInquiryPager.pageNo != i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num inquiry-btn">' + i + '</button>';
					}
					if(data.productInquiryPager.pageNo == i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num selected inquiry-btn">' + i + '</button>';
					}
				}
				
				if(data.productInquiryPager.totalGroupNo > 1) {
					if(data.productInquiryPager.groupNo < data.productInquiryPager.totalGroupNo) {
						console.log(data.productInquiryPager.endPageNo+1)
						var nextPage = data.productInquiryPager.endPageNo+1
						html += '				<input type="hidden" value="' + nextPage + '">';
						html += '				<button class="page-next inquiry-btn"></button>';
					}
				}
				
				html += '	</div>';

				$(".inquiry-item-container").html(html);
				
				//상품문의 페이저 버튼
				$(".inquiry-btn").click(changeInquiryPage);
			}
		}
	});
}


//리뷰 페이저
function changeReviewPage() {
	var toGoPage = $(event.target).prev().val();
	
	console.log(toGoPage);
	
	$.ajax({
		url: "/fruitlight/detailView/moveReviewPage",
		method: "get",
		data: {
			pageNo:toGoPage
		},
		success: function(data) {
			let html = '';
			
			if(data.ReviewList.length != 0) {

				$.each(data.ReviewList, function(index, item) {
					html += '		<article class="sdp-review-article-list">';
					html += '			<div class="list-info">';
					html += '				<div class="list-info-user">';
					html += '					<span class="list-info-user-name">'+ item.shopperName + '&nbsp;</span>';
					html += '				</div>';
					html += '				<div class="list-info-product-info">';
					html += '					<div class="star-gray">';
					html += '						<div class="star-orange" style="width: ' + item.starRate + '%;"></div>';
					html += '					</div>';
					html += '					<div class="reg-date"><fmt:formatDate value="' + item.writeDate + '" pattern="yyyy.MM.dd"/></div>';
					html += '				</div>';
					html += '				<div class="list-info-product-info-name">' + item.productName + '</div>';
					html += '			</div>';
					html += '			<div class="list-review">';
					html += '				<div class="list-review-content">' + item.content + '</div>';
					html += '			</div>';
					html += '			<div class="list-help">';
					html += '				<div id="helpPoint"class="list-help-count"><strong id="helpPointval">' + item.helpPoint + '</strong>명에게 도움 됨</div>';
					html += '				<button class="list-help-btn" onclick="addHelpPoint('+ item.reviewNo + ')">도움이돼요</button>';
					html += '				<button class="list-help-report-btn">신고하기</button>';
					html += '				<div class="sdp-review__clear"></div>';
					html += '			</div>';
					html += '		</article>';
					
				});
				
				html += '	<div class="review-page-btns">';
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo > 1) {
						console.log(data.ReviewPager.startPageNo-1)
						var prevPage = data.ReviewPager.startPageNo-1
						html += '				<input type="hidden" value="' + prevPage + '">';
						html += '				<button class="page-prev review-btn"></button>';
					}
				}
				
				for(let i=data.ReviewPager.startPageNo; i<=data.ReviewPager.endPageNo; i++) {
					if(data.ReviewPager.pageNo != i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num review-btn">' + i + '</button>';
					}
					if(data.ReviewPager.pageNo == i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num selected review-btn">' + i + '</button>';
					}
				}
				
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo < data.ReviewPager.totalGroupNo) {
						console.log(data.ReviewPager.endPageNo+1)
						var nextPage = data.ReviewPager.endPageNo+1
						html += '				<input type="hidden" value="' + nextPage + '">';
						html += '				<button class="page-next review-btn"></button>';
					}
				}
				
				html += '	</div>';

				$("#review-detail-list").html(html);
				
				//상품 리뷰 페이저 버튼
				$(".review-btn").click(changeReviewPage);
			}
		}
	});
}


//리뷰 검색 기능
function searchReviewPage() {
	let searchKeyword = $(".sdp-review-article-order-search-input").val();
	let toGoPage = $(".review-page-btns").children(".selected").prev().val();
	
	if(toGoPage == undefined){
		toGoPage = $(event.target).prev().val();
	}
	
	if (toGoPage === searchKeyword){
		toGoPage = "1";
	}
	
	if(toGoPage == undefined){
		toGoPage = "1";
	}
	
	console.log(searchKeyword);
	console.log(toGoPage);
	
	$.ajax({
		url: "/fruitlight/detailView/searchReviewPage",
		method: "get",
		data: {
			reviewSearchKeyword:searchKeyword, pageNo:toGoPage
		},
		success: function(data) {
			let html = '';
			
			if(data.ReviewList.length != 0) {

				$.each(data.ReviewList, function(index, item) {
					html += '		<article class="sdp-review-article-list">';
					html += '			<div class="list-info">';
					html += '				<div class="list-info-user">';
					html += '					<span class="list-info-user-name">'+ item.shopperName + '&nbsp;</span>';
					html += '				</div>';
					html += '				<div class="list-info-product-info">';
					html += '					<div class="star-gray">';
					html += '						<div class="star-orange" style="width: ' + item.starRate + '%;"></div>';
					html += '					</div>';
					html += '					<div class="reg-date"><fmt:formatDate value="' + item.writeDate + '" pattern="yyyy.MM.dd"/></div>';
					html += '				</div>';
					html += '				<div class="list-info-product-info-name">' + item.productName + '</div>';
					html += '			</div>';
					html += '			<div class="list-review">';
					html += '				<div class="list-review-content">' + item.content + '</div>';
					html += '			</div>';
					html += '			<div class="list-help">';
					html += '				<div id="helpPoint"class="list-help-count"><strong id="helpPointval">' + item.helpPoint + '</strong>명에게 도움 됨</div>';
					html += '				<button class="list-help-btn" onclick="addHelpPoint('+ item.reviewNo + ')">도움이돼요</button>';
					html += '				<button class="list-help-report-btn">신고하기</button>';
					html += '				<div class="sdp-review__clear"></div>';
					html += '			</div>';
					html += '		</article>';
					
				});
				
				html += '	<div class="inquiry-page-btns">';
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo > 1) {
						console.log(data.ReviewPager.startPageNo-1)
						var prevPage = data.ReviewPager.startPageNo-1
						html += '				<input type="hidden" value="' + prevPage + '">';
						html += '				<button class="page-prev review-btn"></button>';
					}
				}
				
				for(let i=data.ReviewPager.startPageNo; i<=data.ReviewPager.endPageNo; i++) {
					if(data.ReviewPager.pageNo != i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num review-btn">' + i + '</button>';
					}
					if(data.ReviewPager.pageNo == i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num selected review-btn">' + i + '</button>';
					}
				}
				
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo < data.ReviewPager.totalGroupNo) {
						console.log(data.ReviewPager.endPageNo+1)
						var nextPage = data.ReviewPager.endPageNo+1
						html += '				<input type="hidden" value="' + nextPage + '">';
						html += '				<button class="page-next review-btn"></button>';
					}
				}
				
				html += '	</div>';

				$("#review-detail-list").html(html);
				
				//상품 리뷰 페이저 버튼
				$(".sdp-review-article-order-search-btn").click(searchReviewPage);
				$(".review-btn").click(searchReviewPage);
			}
		}
	});
}


//리뷰 좋아요 많은 순 필터 검색 기능
function bestReviewPage() {
	$("#bestReviewBtn").attr("class","sdp-review-article-order-sort-best-btn");
	$("#recentReviewBtn").attr("class","sdp-review-article-order-sort-newest-btn");
	
	$.ajax({
		url: "/fruitlight/detailView/bestReviewPage",
		method: "get",
		data: {},
		success: function(data) {
			let html = '';
			
			if(data.ReviewList.length != 0) {

				$.each(data.ReviewList, function(index, item) {
					html += '		<article class="sdp-review-article-list">';
					html += '			<div class="list-info">';
					html += '				<div class="list-info-user">';
					html += '					<span class="list-info-user-name">'+ item.shopperName + '&nbsp;</span>';
					html += '				</div>';
					html += '				<div class="list-info-product-info">';
					html += '					<div class="star-gray">';
					html += '						<div class="star-orange" style="width: ' + item.starRate + '%;"></div>';
					html += '					</div>';
					html += '					<div class="reg-date"><fmt:formatDate value="' + item.writeDate + '" pattern="yyyy.MM.dd"/></div>';
					html += '				</div>';
					html += '				<div class="list-info-product-info-name">' + item.productName + '</div>';
					html += '			</div>';
					html += '			<div class="list-review">';
					html += '				<div class="list-review-content">' + item.content + '</div>';
					html += '			</div>';
					html += '			<div class="list-help">';
					html += '				<div id="helpPoint"class="list-help-count"><strong id="helpPointval">' + item.helpPoint + '</strong>명에게 도움 됨</div>';
					html += '				<button class="list-help-btn" onclick="addHelpPoint('+ item.reviewNo + ')">도움이돼요</button>';
					html += '				<button class="list-help-report-btn">신고하기</button>';
					html += '				<div class="sdp-review__clear"></div>';
					html += '			</div>';
					html += '		</article>';
					
				});
				
				html += '	<div class="review-page-btns">';
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo > 1) {
						console.log(data.ReviewPager.startPageNo-1)
						var prevPage = data.ReviewPager.startPageNo-1
						html += '				<input type="hidden" value="' + prevPage + '">';
						html += '				<button class="page-prev review-btn"></button>';
					}
				}
				
				for(let i=data.ReviewPager.startPageNo; i<=data.ReviewPager.endPageNo; i++) {
					if(data.ReviewPager.pageNo != i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num review-btn">' + i + '</button>';
					}
					if(data.ReviewPager.pageNo == i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num selected review-btn">' + i + '</button>';
					}
				}
				
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo < data.ReviewPager.totalGroupNo) {
						console.log(data.ReviewPager.endPageNo+1)
						var nextPage = data.ReviewPager.endPageNo+1
						html += '				<input type="hidden" value="' + nextPage + '">';
						html += '				<button class="page-next review-btn"></button>';
					}
				}
				
				html += '	</div>';

				$("#review-detail-list").html(html);
				$(".review-btn").click(changeReviewPage);
			}
		}
	});
}



//리뷰 최신순  필터 검색 기능
function recentReviewPage() {
	$("#bestReviewBtn").attr("class","sdp-review-article-order-sort-newest-btn");
	$("#recentReviewBtn").attr("class","sdp-review-article-order-sort-best-btn");
	
	
	$.ajax({
		url: "/fruitlight/detailView/recentReviewPage",
		method: "get",
		data: {},
		success: function(data) {
			let html = '';
			
			if(data.ReviewList.length != 0) {

				$.each(data.ReviewList, function(index, item) {
					html += '		<article class="sdp-review-article-list">';
					html += '			<div class="list-info">';
					html += '				<div class="list-info-user">';
					html += '					<span class="list-info-user-name">'+ item.shopperName + '&nbsp;</span>';
					html += '				</div>';
					html += '				<div class="list-info-product-info">';
					html += '					<div class="star-gray">';
					html += '						<div class="star-orange" style="width: ' + item.starRate + '%;"></div>';
					html += '					</div>';
					html += '					<div class="reg-date"><fmt:formatDate value="' + item.writeDate + '" pattern="yyyy.MM.dd"/></div>';
					html += '				</div>';
					html += '				<div class="list-info-product-info-name">' + item.productName + '</div>';
					html += '			</div>';
					html += '			<div class="list-review">';
					html += '				<div class="list-review-content">' + item.content + '</div>';
					html += '			</div>';
					html += '			<div class="list-help">';
					html += '				<div id="helpPoint"class="list-help-count"><strong id="helpPointval">' + item.helpPoint + '</strong>명에게 도움 됨</div>';
					html += '				<button class="list-help-btn" onclick="addHelpPoint('+ item.reviewNo + ')">도움이돼요</button>';
					html += '				<button class="list-help-report-btn">신고하기</button>';
					html += '				<div class="sdp-review__clear"></div>';
					html += '			</div>';
					html += '		</article>';
					
				});
				
				html += '	<div class="review-page-btns">';
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo > 1) {
						console.log(data.ReviewPager.startPageNo-1)
						var prevPage = data.ReviewPager.startPageNo-1
						html += '				<input type="hidden" value="' + prevPage + '">';
						html += '				<button class="page-prev review-btn"></button>';
					}
				}
				
				for(let i=data.ReviewPager.startPageNo; i<=data.ReviewPager.endPageNo; i++) {
					if(data.ReviewPager.pageNo != i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num review-btn">' + i + '</button>';
					}
					if(data.ReviewPager.pageNo == i) {
						html += '				<input type="hidden" value="' + i + '">';
						html += '				<button class="page-num selected review-btn">' + i + '</button>';
					}
				}
				
				if(data.ReviewPager.totalGroupNo > 1) {
					if(data.ReviewPager.groupNo < data.ReviewPager.totalGroupNo) {
						console.log(data.ReviewPager.endPageNo+1)
						var nextPage = data.ReviewPager.endPageNo+1
						html += '				<input type="hidden" value="' + nextPage + '">';
						html += '				<button class="page-next review-btn"></button>';
					}
				}
				
				html += '	</div>';

				$("#review-detail-list").html(html);
				$(".review-btn").click(changeReviewPage);
			}
		}
	});
}




//장바구니 담기
function addCart() {
	var selectedItems = $(".product-option-tableRow.selected");
	if(selectedItems.length == 0) {
		alert("옵션을 선택해주세요.");
	} else {
		var pnos = [];
		var stocks = [];
		selectedItems.each(function(index, item) {
			let selectedItemPno = $(item).find(".product-option-pid").val();
			let selectedItemStock = $(item).find(".product-quantity-input").val();
			pnos.push(selectedItemPno);
			stocks.push(selectedItemStock);
		});
		$.ajax({
			url: "/fruitlight/detailView/addCartProduct",
			method: "post",
			traditional: true,
			data: {
				pnos:pnos,
				stocks:stocks
			},
			success: function(data) {
			}
		});
		
		if($("#shopperInfo").val() == "") {
			if(confirm("로그인을 해주세요")) {
				location.href = "login";
			}
		} else {
			if(confirm("선택하신 상품이 장바구니에 담겼습니다.\n장바구니로 이동하시겠습니까?")) {
				location.href = "cart";
			}
		}
	}
}
//바로구매
function buy() {
	var selectedItems = $(".product-option-tableRow.selected");
	if(selectedItems.length == 0) {
		alert("옵션을 선택해주세요.");
	} else {
		var pnos = [];
		var pnames = [];
		var options = [];
		var stocks = [];
		var prices = [];
		var totalPrice = 0;
		selectedItems.each(function(index, item) {
			let selectedItemPno = $(item).find(".product-option-pid").val();
			let selectedItemPname = $(item).find(".product-option-pname").val();
			let selectedItemOption = $(item).find(".product-option-option").val();
			let selectedItemStock = $(item).find(".product-quantity-input").val();
			let selectedItemPrice = parseInt($(item).find(".product-option-originalPrice").val()) * selectedItemStock;
			totalPrice += selectedItemPrice;
			
			pnos.push(selectedItemPno);
			pnames.push(selectedItemPname);
			options.push(selectedItemOption);
			stocks.push(selectedItemStock);
			prices.push(selectedItemPrice);
		});
		
		var shippingPrice = 0;
		if(totalPrice > 30000) {
			shippingPrice = 0;
		} else {
			shippingPrice = 3000;
		}
		
		var orderPrice = totalPrice + shippingPrice;
		
		location.href = "detailView/buyDirect?"
			+ "pnos=" + encodeURIComponent(pnos.join(','))
			+ "&pnames=" + encodeURIComponent(pnames.join(','))
			+ "&options=" + encodeURIComponent(options.join(','))
			+ "&stocks=" + encodeURIComponent(stocks.join(','))
			+ "&prices=" + encodeURIComponent(prices.join(','))
			+ "&totalPrice=" + encodeURIComponent(totalPrice)
			+ "&shippingPrice=" + encodeURIComponent(shippingPrice)
			+ "&orderPrice=" + encodeURIComponent(orderPrice);
			
	}
}

function addHelpPoint(reviewNo) {
	let helpPointValue = $(event.target).parent().find("#helpPointval").html();
	let eventHandler = $(event.target).parent().find("#helpPointval");
	
	
	$.ajax({
        type:"get",
        url:"/fruitlight/detailView/addHelpPoint",
        data:{ReviewNo:reviewNo},
        success: function(data) {
        	
        	helpPointValue = Number(helpPointValue) + 1;
        	eventHandler.html(helpPointValue);
        }
    })
}
