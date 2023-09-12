
/**
 * 배송 요청사항 자식 페이지 생성 메소드
 * @author 고재승
 */
function openDeliveryPreferencesPage() {
	deliPreChild = window.open("/fruitlight/deliveryPreferences", "_blank","top=10, left=10, width=500, height=600, status=no, menubar=no, toolbar=no, resizable=no", true);
	deliPreChild.dataFromParent = "newAddressBookPage";
}

/**
 * 배송 요청사항 자식 페이지 소멸 메소드
 * @author 고재승
 */
function deliveryPreferencesCloseEvent() {
	deliPreChild.close();
}