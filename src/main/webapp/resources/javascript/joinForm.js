/* 고재승
- 쿠팡 회원가입 HTML, CSS 구현
- 정규표현식 기반 유저 아이디(이메일) 데이터 유효성 검사 기능 구현
- 정규표현식 기반 유저 패스워드 데이터 3가지 유효성 검사 기능 구현
    - 영문/숫자/특수문자 2가지 이상 조합 (8~20자)
    - 3개 이상 연속되거나 동일한 문자/숫자 제외
    - 아이디(이메일) 제외
- 유저 패스워드 다시 입력 데이터 유효성 검사 기능 구현
- 유저 이름 데이터 유효성 검사 기능 구현
- 유저 연락처 데이터 유효성 검사 기능 구현
- 모든 유효성 조건을 만족하지 않을 시 form 제출 비활성화 기능 구현
*/

window.onload = init;

function init() {
	validationEmptyUserID = false;
	validationPattenUserID = false;
	validationEmptyUserPW = false;
	validationPattenUserPW = false;
	validationEmptyAgainUserPW = false;
	validationPattenUserName = false;
	validationEmptyUserTel = false;
	validationAcceptAgreement = false;
	
    $("#user_id").click(checkEmptyUserID);
    $("#user_id").on("blur",checkEmptyUserID);
    $("#user_id").keyup(checkPattenUserID);

    $("#user_pw").click(checkEmptyPassword);
    $("#user_pw").keyup(checkEmptyPassword);
    $("#user_pw").on("blur",checkEmptyUserID);
    $("#user_pw").keyup(checkPattenPassword);
    
    $("#user_pw_check").click(checkEmptyAgainPassword);
    $("#user_pw_check").keyup(checkEmptyAgainPassword);

    $("#user_name").click(checkEmptyUserName);
    $("#user_name").keyup(checkEmptyUserName);
    
    $("#user_tel").click(checkEmptyPhone);
    $("#user_tel").keyup(checkEmptyPhone);
    
    $("#join_btn").click(checkValidation);
}

function checkAcceptAgreement() {
	$("#agreement_content_1").css("display", "block");
}


function checkEmptyUserID () {
    if($("#user_id").val() === ""){
        $("#uidNotInputErr").css("display","block");
        $("#uidNotAvailableErr").css("display","none");
        validationEmptyUserID = false;
    } else {
        $("#uidNotInputErr").css("display","none");
        validationEmptyUserID = true;
    }
}
function checkPattenUserID () {
    let email_pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!email_pattern.test($('#user_id').val())){
        $("#uidNotInputErr").css('display','none');
        $("#uidNotAvailableErr").css("display","block");
        validationPattenUserID = false;
    } else {
        $("#uidNotAvailableErr").css("display","none");
        validationPattenUserID = true;
    }
}


function checkEmptyPassword () {
    if($("#user_pw").val() === ""){
        $("#user_pw_letter_combination").css("display","block");
        $("#user_pw_character_pattern").css("display","block");
        $("#user_pw_duplicate_pattern").css("display","block");
        validationEmptyUserPW = false;
    } else {
    	validationEmptyUserPW = true;
    }
}
function checkPattenPassword () {
    let isLetterCombination = false;
    let isCharanterPattern = false;
    let isDuplicatePattern = false;

    // 영문/숫자/특수문자 2가지 이상 조합 (8~20자)
    let letter_combination_pattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
    if(letter_combination_pattern.test($("#user_pw").val())) {
        $("#user_pw_letter_combination").css("color","green");
        isLetterCombination = true;
    } else {
        isLetterCombination = false;
        $("#user_pw_letter_combination").css("color","#e52528");
    }


    // 3개 이상 연속되거나 동일한 문자/숫자 제외
    let character_pattern = /(\w)\1\1/;
    if(character_pattern.test($("#user_pw").val())){
        isCharanterPattern = false;
        $("#user_pw_character_pattern").css("color","#e52528");
    } else {
        isCharanterPattern = true;
        $("#user_pw_character_pattern").css("color","green");
    }

    
    // 아이디(이메일) 제외
    let split_email = $("#user_id").val().split("@");
    let front_email = split_email[0];
    let id_pw_equal_patten = new RegExp(`${front_email}`,'i');
    if(!id_pw_equal_patten.test($("#user_pw").val())){
        isDuplicatePattern = true;
        $("#user_pw_duplicate_pattern").css("color","green");
    } else {
        isDuplicatePattern = false;
        $("#user_pw_duplicate_pattern").css("color","#e52528");
    }

    if(isLetterCombination&&isCharanterPattern&&isDuplicatePattern){
        $("#user_pw_letter_combination").css("display","none");
        $("#user_pw_character_pattern").css("display","none");
        $("#user_pw_duplicate_pattern").css("display","none");
        $("#user_pw_success").css("display","block");
        $("#user_pw_success").css("color","green");
        validationPattenUserPW = true;
    } else {
        $("#user_pw_letter_combination").css("display","block");
        $("#user_pw_character_pattern").css("display","block");
        $("#user_pw_duplicate_pattern").css("display","block");
        $("#user_pw_success").css("display","none");
        validationPattenUserPW = false;
    }
}


function checkEmptyAgainPassword () { 
    if($("#user_pw_check").val() === $("#user_pw").val()){
        $("#pw_match").css("display","block");
        $("#pw_match").css("color","green");
        $("#pw_no_match").css("display","none");
        validationEmptyAgainUserPW = true;
    } else {
        $("#pw_match").css("display","none");
        $("#pw_no_match").css("display","block");
        validationEmptyAgainUserPW = false;
    }
}


function checkEmptyUserName () { 
	// 국문식/영문식 이름 정규표현식
	let name_pattern = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
    if($("#user_name").val() !== "" && name_pattern.test($("#user_name").val())) {
    	$("#uname_no_match").css("display","none");
    	validationPattenUserName = true;
    } else {
    	$("#uname_no_match").css("display","block");
    	validationPattenUserName = false;
        
    }
}

function checkEmptyPhone () { 
    let tel_partten = /^(010)-[0-9]{4}-[0-9]{4}$/;
    if($("#user_tel").val() === "" || !tel_partten.test($(user_tel).val())) {
        $("#phone_no_match").css("display","block");
        validationEmptyUserTel = false;
    } else {
        $("#phone_no_match").css("display","none");
        validationEmptyUserTel = true;
    }
}



function checkValidation() {
    // 모든 에러 메시지를 보여주지 않도록 초기화
	$(".errorMsg").each((index,el) => {$(el).css("display","none")});
	
	if($("#acceptAgreement").is(":checked")){
		validationAcceptAgreement = true;
	} else {
		validationAcceptAgreement = false;
	}
	
	console.log("validationEmptyUserID : " + validationEmptyUserID);
	console.log("validationPattenUserID : " + validationPattenUserID);
	console.log("validationEmptyUserPW : " + validationEmptyUserPW);
	console.log("validationPattenUserPW : " + validationPattenUserPW);
	console.log("validationEmptyAgainUserPW : " + validationEmptyAgainUserPW);
	console.log("validationPattenUserName : " + validationPattenUserName);
	console.log("validationEmptyUserTel : " + validationEmptyUserTel);
	console.log("validationAcceptAgreement : " + validationAcceptAgreement);

    // 유효성 검사에서 실패시 form의 제출기능 비활성화
	if(validationEmptyUserID && validationPattenUserID && validationEmptyUserPW && validationPattenUserPW && validationEmptyAgainUserPW && validationPattenUserName && validationEmptyUserTel && validationAcceptAgreement) {
	} else {
		event.preventDefault();
	}
}