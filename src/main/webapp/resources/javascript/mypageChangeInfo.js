window.onload = init;
function init() {
	validationEmail = false;
	validationTel = false;
	validationPattenUserOriginalPW = false;
	validationEmptyUserPW = false;
	validationPattenUserPW = false;
	validationEmptyAgainUserPW = false;
	 
	 $("#user_current_pw").click(checkEmptyOriginalPassword);
	 $("#user_current_pw").mouseout(checkEmptyOriginalPassword);
	 $("#user_current_pw").keyup(checkOriginalPassword);
	
	 $("#user_pw").click(checkEmptyPassword);
	 $("#user_pw").mouseout(checkEmptyPassword);
	 $("#user_pw").keyup(checkPattenPassword);
	 
	 $("#user_pw_check").click(checkEmptyAgainPassword);
	 $("#user_pw_check").keyup(checkEmptyAgainPassword);
	 
	 $("#btn_pwd").click(checkValidation);
	 
	 
	 // ID 변경 이메일 유효성 검사
	 $('input[name=shopperId]').keyup(() => {
	        let email_pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	        if(!email_pattern.test($('input[name=shopperId]').val())){
	        	validationEmail = false;
	        } else {
	        	validationEmail = true;
	        }
	    });
	 
	// ID 변경 버튼 유효성 검사
    $('#changeIdButton').click(() => {
        if(!validationEmail) {
            event.preventDefault();
            alert("이메일 형식에 맞지 않습니다 다시 작성해주세요. ex)email@mycompany.com");
        }
    });
    
    
    
     // 연락처 변경 유효성 검사
	 $('input[name=shopperTel]').keyup(() => {
	        let email_pattern = /^(010)-[0-9]{4}-[0-9]{4}$/;
	        if(!email_pattern.test($('input[name=shopperTel]').val())){
	        	validationTel = false;
	        } else {
	        	validationTel = true;
	        }
	    });
	 
	   // 연락처 변경  버튼 유효성 검사
	   $('#changeTelBtn').click(() => {
	       if(!validationTel) {
	           event.preventDefault();
	           alert("휴대폰 번호 형식에 맞지 않습니다 다시 작성해주세요. ex) 010-1234-5678");
	       }
	   });
}


function openEmailChange(){
	$("#emailChange").removeClass("d-inline-block");
	$("#emailChange").addClass("d-none");
	$("#emailCancel").removeClass("d-none");
	$("#emailCancel").addClass("d-inline-block");
	$("#changeIdForm").removeClass("d-none");
	$("#changeIdForm").addClass("d-block");
}

function openEmailChangeCancel(){
	$("#emailCancel").removeClass("d-inline-block");
	$("#emailCancel").addClass("d-none");
	$("#emailChange").removeClass("d-none");
	$("#emailChange").addClass("d-inline-block");
	$("#changeIdForm").removeClass("d-block");
	$("#changeIdForm").addClass("d-none");
}

function checkEmptyOriginalPassword () {
    if($("#user_original_pw").val() === ""){
        $("#user_pw_original_check").css("display","block");
        validationEmptyUserPW = false;
    } else {
    	validationEmptyUserPW = true;
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
function checkOriginalPassword() {
	let isPwOriginalCheck = false;
	
	// 초기 비밀번호와 값이 일치해야 함
	if($("#user_original_pw").val() == $("#user_current_pw").val()){
		$("#user_pw_original_check").css("color","green");
		isPwOriginalCheck = true;
	} else {
		isPwOriginalCheck = false;
		$("#user_pw_original_check").css("color","#e52528");
	}
	
	if(isPwOriginalCheck){
        $("#user_pw_original_check").css("display","none");
        $("#user_pw_original_success").css("display","block");
        $("#user_pw_original_success").css("color","green");
        validationPattenUserOriginalPW = true;
    } else {
        $("#user_pw_original_check").css("display","block");
        $("#user_pw_original_success").css("display","none");
        validationPattenUserOriginalPW = false;
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
    let split_email = $("#user_id").text().split("@");
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

function openTelChange(){
	$("#telChange").removeClass("d-inline-block");
	$("#telChange").addClass("d-none");
	$("#telCancel").removeClass("d-none");
	$("#telCancel").addClass("d-inline-block");
	$("#changeTelForm").removeClass("d-none");
	$("#changeTelForm").addClass("d-block");
}

function openTelChangeCancel(){
	$("#telCancel").removeClass("d-inline-block");
	$("#telCancel").addClass("d-none");
	$("#telChange").removeClass("d-none");
	$("#telChange").addClass("d-inline-block");
	$("#changeTelForm").removeClass("d-block");
	$("#changeTelForm").addClass("d-none");
}



function deliveryAddressBtn() {
    window.open("/fruitlight/addressBook", "_blank","top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no", true);
}

function checkValidation() {
    // 모든 에러 메시지를 보여주지 않도록 초기화
	$(".errorMsg").each((index,el) => {$(el).css("display","none")});
	
	console.log("validationPattenUserOriginalPW  :" + validationPattenUserOriginalPW );
	console.log("validationEmptyUserPW  :" + validationEmptyUserPW );
	console.log("validationPattenUserPW  :" + validationPattenUserPW );
	console.log("validationEmptyAgainUserPW  :" + validationEmptyAgainUserPW );
    
	// 유효성 검사에서 실패시 form의 제출기능 비활성화
	if(validationPattenUserOriginalPW &&validationEmptyUserPW && validationPattenUserPW && validationEmptyAgainUserPW) {
		alert("비밀번호가 변경되었습니다.");
	} else {
		event.preventDefault();
	}
}