/* 고재승
- 쿠팡 로그인 페이지 HTML, CSS 구현
- 유저 아이디 데이터 유효성 검사 기능 구현
    - null 값 and empty 값 확인
    - 정규표현식 기반 이메일 패턴 유효성 감사
- 유저 패스워드 데이터 유효성 검사 기능 구현
    - null 값 and empty 값 확인
- 유저 패스워드 데이터 보이기/숨기기 기능 구현
*/
window.onload=init;

function init() {
    var isIdNullValidation = false;
    var isIdPattenValidation = false;
    var isPwValidation = false;

    // ID null 값 유효성 검사
    $('input[name=userId]').click(() => {
        if($('input[name=userId]').val() == ""){
            isIdNullValidation = false;
            $('.id_empty_error').css('display','block');
            $('.id_form_error').css('display','none');
        } else {
            isIdNullValidation = true;
            $('.id_form_error').css('display','none');
        }
    });

    // ID 형식 유효성 검사
    $('input[name=userId]').keyup(() => {
        let email_pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(!email_pattern.test($('input[name=userId]').val())){
            isIdPattenValidation = false;
            $('.id_empty_error').css('display','none');
            $('.id_form_error').css('display','block');
        } else {
            isIdPattenValidation = true;
            $('.id_form_error').css('display','none');
        }
    });

    // PW null 값 유효성 검사
    $('input[name=userPw]').click(() => {
        isPwValidation = false;
        if($('input[name=userPw]').val() == ""){
            $('.pw_error').css('display','block');
        }
    });

    // PW null 값 유효성 검사
    $('input[name=userPw]').keyup(() => {
        isPwValidation = true;
        $('.pw_error').css('display','none');
    });

    // 비밀번호 시각화 기능
    let isVisualization = true
    $('.pw_show_hide').click(() => {
        if(isVisualization == true) {
            isVisualization = false;
            $('.pw_show_hide').css('background-position','-126px 0');
            $('input[name=shopperPw]').prop("type","text");
        } else {
            isVisualization = true;
            $('.pw_show_hide').css('background-position','-105px 0');
            $('input[name=shopperPw]').prop("type","password");
        }
    });


    // 로그인 유효성 검사
    $('#login_btn').click(() => {
        console.log(event.target);
        if(isIdNullValidation && isIdPattenValidation && isPwValidation) {
            event.preventDefault();
            console.log(event.target);
        }
    });
}


function findEmailOpenEvent() {
	findEmailChild = window.open("/fruitlight/login/findEmail", "_blank","top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no", true);
}

function findEmailCloseEvent() {
	findEmailChild.close();
}


function findPWOpenEvent() {
	findPWChild = window.open("/fruitlight/login/findPW", "_blank","top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no", true);
}

function findPWCloseEvent() {
	findPWChild.close();
}

