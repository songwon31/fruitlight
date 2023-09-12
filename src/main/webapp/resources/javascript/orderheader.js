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
      $("#menus").css("transform","translateX(0px)");
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
      $("#menus").css("transform","translateX(-320px)");
   }
   if(catehandle4.matches === true) {
      $("#menu-btn1").css("backgroundImage","none");
      $("#menu-btn2").css("backgroundImage","url(//img1a.coupangcdn.com/image/coupang/common/pc_gnb_arrow-left@2x.png)");
      $("#menus").css("transform","translateX(-480px)");
   }
   if(catehandle5.matches === true) {
      $("#menus").css("transform","translateX(-300px)");
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