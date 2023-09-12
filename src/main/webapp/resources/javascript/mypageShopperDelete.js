window.onload = init;

function init() {
	validationAcceptAgreement = false;
    
    $("#join_btn").click(checkValidation);
}


function checkValidation() {

	if($("#acceptAgreement").is(":checked")){
		validationAcceptAgreement = true;
	} else {
		validationAcceptAgreement = false;
	}
	
	console.log($("#acceptAgreement").is(":checked"));
	console.log(validationAcceptAgreement);

    // 유효성 검사에서 실패시 form의 제출기능 비활성화
	if(validationAcceptAgreement) {
	} else {
		event.preventDefault();
		alert("탈퇴 동의 항목은 필수 입니다.");
	}
}