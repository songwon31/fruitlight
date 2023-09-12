package poris.fruitlight.dto;

import lombok.Data;


/**
 * 결제 페이지 JSP - 받는 사람 정보를 출력에 사용하는 DTO
 * @author 고재승
 */
@Data
public class ShippingAddressParam {
	private int addressNo;				// 배송지 고유번호
	private String name;				// 받는 사람 이름
	private String address;				// 보내는 주소
	private String tel;					// 받는 사람의 연락처
}
