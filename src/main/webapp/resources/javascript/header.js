window.onload = init;

function init(){
   if(catehandle1.matches === true){
      $("#menu-btn1").removeClass("d-block");
      $("#menu-btn2").removeClass("d-block");
      $("#menu-btn1").addClass("d-none");
      $("#menu-btn2").addClass("d-none");
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   }
   
   $("#carouselMainItem1").addClass("active");
   $("#carouselCate1MainItem1").addClass("active");
   $("#carouselCate2MainItem1").addClass("active");
   
   const changeHandler1 = (cateAdvertiseHide) => {
	   if(cateAdvertiseHide.matches === true){
	      $("#cateAdvertise").addClass("disabled-div");
	      $("#cateAdvertise").removeClass("d-block");
	      $("#cateAdvertise").addClass("d-none");
	   } else {
	      $("#cateAdvertise").removeClass("disabled-div");
	      $("#cateAdvertise").removeClass("d-none");
	      $("#cateAdvertise").addClass("d-block");
	   }
	}

	const changeHandler2 = (cateMainBannerHide) => {
	   if(cateMainBannerHide.matches === true){
	      $("#mainproduct").addClass("disabled-div");
	      $("#mainproduct").removeClass("d-block");
	      $("#mainproduct").addClass("d-none");
	   } else {
	      $("#mainproduct").removeClass("disabled-div");
	      $("#mainproduct").removeClass("d-none");
	      $("#mainproduct").addClass("d-block");
	   }
	}

	cateAdvertiseHide.addEventListener("change", changeHandler1);
	cateMainBannerHide.addEventListener("change", changeHandler2);
}
const cateAdvertiseHide = window.matchMedia(`(max-width: 1100px)`);
const cateMainBannerHide = window.matchMedia(`(max-width: 768px)`);

const catehandle1 = window.matchMedia(`(min-width: 1200px)`);
const catehandle2 = window.matchMedia(`(max-width: 1200px)`);
const catehandle3 = window.matchMedia(`(max-width: 992px)`);
const catehandle4 = window.matchMedia(`(max-width: 768px)`);
const catehandle5 = window.matchMedia(`(max-width: 575px)`);

//헤더 메뉴 옆으로 넘기기

function menuprev(){
   if(catehandle2.matches === true){
      $("#menu-btn2").css("backgroundImage","none");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menus").css("transform","translateX(0px)");
   }
   if(catehandle3.matches === true) {
      $("#menu-btn2").css("backgroundImage","none");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menus").css("transform","translateX(0px)");
   }
   if(catehandle4.matches === true) {
      $("#menu-btn2").css("backgroundImage","none");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menus").css("transform","translateX(0px)");
   }
   if(catehandle5.matches === true) {
	  let btn = $("#prevnext").html(); 
	  if(btn === "2"){
		  $("#prevnext").html("1");
		  $("#menu-btn2").css("backgroundImage","none");
		  $("#menus").css("transform","translateX(0px)");
	  } else if(btn === "3"){
		  $("#prevnext").html("2");
		  $("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left@2x.png)");
		  $("#menus").css("transform","translateX(-280px)");
	  }
   }
}
function menunext(){
   if(catehandle2.matches === true){
      $("#menu-btn1").css("backgroundImage","none");
      $("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left@2x.png)");
      $("#menus").css("transform","translateX(-150px)");
   }
   if(catehandle3.matches === true) {
      $("#menu-btn1").css("backgroundImage","none");
      $("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left@2x.png)");
      $("#menus").css("transform","translateX(-323px)");
   }
   if(catehandle4.matches === true) {
      $("#menu-btn1").css("backgroundImage","none");
      $("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left@2x.png)");
      $("#menus").css("transform","translateX(-480px)");
   }
   if(catehandle5.matches === true) {
	  let btn = $("#prevnext").html(); 
	  if(btn === "1"){
		  $("#prevnext").html("2");
		  $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
		  $("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left@2x.png)");
		  $("#menus").css("transform","translateX(-280px)");
	  } else if(btn === "2"){
		  $("#prevnext").html("3");
		  $("#menu-btn1").css("backgroundImage","none");
		  $("#menus").css("transform","translateX(-630px)");
	  }
   }
}

const viewChangeHandler1 = (catehandle1) => {
   if(catehandle1.matches === true){
      $("#menu-btn1").removeClass("d-block");
      $("#menu-btn2").removeClass("d-block");
      $("#menu-btn1").addClass("d-none");
      $("#menu-btn2").addClass("d-none");
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   } else {
      $("#menu-btn1").removeClass("d-none");
      $("#menu-btn2").removeClass("d-none");
      $("#menu-btn1").addClass("d-block");
      $("#menu-btn2").addClass("d-block");
   }
}

const viewChangeHandler2 = (catehandle2) => {
   if(catehandle2.matches === true){
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   } else {
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   }
}

const viewChangeHandler3 = (catehandle3) => {
   if(catehandle3.matches === true){
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   } else {
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   }
}

const viewChangeHandler4 = (catehandle4) => {
   if(catehandle4.matches === true){
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   } else {
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   }
}

const viewChangeHandler5 = (catehandle5) => {
   if(catehandle5.matches === true){
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   } else {
      $("#menus").css("transform","translateX(0px)");
      $("#menu-btn1").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-right@2x.png)");
      $("#menu-btn2").css("backgroundImage","none");
   }
}

catehandle1.addEventListener("change", viewChangeHandler1);
catehandle2.addEventListener("change", viewChangeHandler2);
catehandle3.addEventListener("change", viewChangeHandler3);
catehandle4.addEventListener("change", viewChangeHandler4);
catehandle5.addEventListener("change", viewChangeHandler5);

// 카테고리명에 맞는 검색기능에 ${searchKeyword}를 누르자마자 그에 맞게 직접 부여해주기 위한 js
// searchLink가 붙은 모든 클래스를 찾아 클릭 시 data-search에 있는 값을 searchKeyword에 저장 후, 페이지 이동
var searchLinks = document.querySelectorAll('.searchLink');
for (var i = 0; i < searchLinks.length; i++) {
    searchLinks[i].addEventListener('click', function(event) {
        event.preventDefault();
        var searchKeyword = this.getAttribute('data-search');
        
        // 검색어 값을 직접 설정하여 페이지 이동 처리
        window.location.href = 'list?search=' + searchKeyword;
    });
}