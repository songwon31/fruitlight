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