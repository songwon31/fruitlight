/**
 * 부모 페이지에 배송지 데이터를 대입하는 메소드 (from. 배송지 목록 page)
 * @author 고재승
 * @param count - 배송지 목록 배멸의 임시 Index, 1부터 시작한다
 */
function selectAddressBook(index) {
	// 받을 사람, 받을 주소, 연락처를 부모 페이지 요소에 대입
	window.opener.document.getElementById("addressNo").value = $("input[name='addressNo"+index+"']").val();
	window.opener.document.getElementById("recipientName").innerHTML = $("input[name='recipientName"+index+"']").val();
	window.opener.document.getElementById("deliveryDetailAddress").innerHTML = $("input[name='streetAddress"+index+"']").val();
	window.opener.document.getElementById("deliveryTel").innerHTML = $("input[name='recipientTel"+index+"']").val();
	
	// 부모 페이지의 JS function 실행
	$(opener.location).attr("href", "javascript:deliveryAddressCloseEvent()");
}