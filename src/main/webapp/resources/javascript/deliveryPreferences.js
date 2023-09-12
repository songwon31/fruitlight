/* 고재승
- 배송 요청사항 선택 페이지 HTML, CSS 구현
- 배송 요청사항 유형 선택 기능 구현
- 특정 유형 선택 시, 서브 UI 출력 기능 구현
*/

window.onload = init;

function init() {
    $("#put_front_of_door").on('change', lockerClickEvent);
    $("#direct_receive_as_front_of_door").on('change', lockerClickEvent);
    $("#security_office").on('change', lockerClickEvent);
    $("#delivery_Box").on('change', lockerClickEvent);
    $("#other_place").on('change', lockerClickEvent);
}


function lockerClickEvent() {
    if($("#delivery_Box").is(":checked")){
        $("#locker_detail_form").css("display", "block");
    } else {
        $("#locker_detail_form").css("display", "none");
    }

    if($("#other_place").is(":checked")){
        $("#other_place_detail_form").css("display", "block");
    } else {
        $("#other_place_detail_form").css("display", "none");
    }
}


/**
 * @author 고재승
 * 배송 요청사항을 호출한 부모 페이지의 종류에 따라 배송 요청사항을 전달하는 메소드
 */
function windowClose() {
	if(window.dataFromParent === "orderPage"){
		// Step1. 부모 페이지의 요소에 자식 페이지의 요소 값 대입
		$("#deliPre", opener.document).text($("input[name='requiredCheckType']:checked").val());
		$("#requiredCheckTypeID", opener.document).val($("input[name='requiredCheckType']:checked").val());
		if($("input[name='requiredCheckType']:checked").val() === "택배함"){
			$("#requiredMessageID", opener.document).val($("input[name='courierBoxMessage']").val());
		} else if($("input[name='requiredCheckType']:checked").val() === "기타사항") {
			$("#requiredMessageID", opener.document).val($("input[name='otherInfoMessage']").val());
		}
		$("#passwordCheckTypeID", opener.document).val($("input[name='passwordCheckType']:checked").val());
		$("#passwordMessageID", opener.document).val($("input[name='passwordMessage']").val());
		
		// Step2. 자식 페이지를 close하는 부모 페이지의 JS 함수 실행
		$(opener.location).attr("href", "javascript:deliveryPreferencesCloseEvent()");
		
	} else if(window.dataFromParent === "newAddressBookPage") {
		// Step1. 배송 요청사항 자식페이지 생성 요소 비활성화, 유저의 배송 요청사항을 부모페이지로 전달 및 입력 요소 활성화
		$("#askDeliveryPreference", opener.document).css("display","none");
		$("#getDeliveryPreference", opener.document).css("display","block");
		$("#addressbookPreference", opener.document).val($("input[name='requiredCheckType']:checked").val());
		
		// Step2. 자식 페이지를 close하는 부모 페이지의 JS 함수 실행
		$(opener.location).attr("href", "javascript:deliveryPreferencesCloseEvent()");
	}
	
}