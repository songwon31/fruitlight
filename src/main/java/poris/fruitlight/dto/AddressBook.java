package poris.fruitlight.dto;

import lombok.Data;

/**
 * 배송지 DB DTO
 * @author 고재승
 */
@Data
public class AddressBook {
	private int address_no;				// 배송지 고유번호(PK)
	private int shopper_no;				// 회원 고유번호(FK)
	private String shipping_name;		// 받는 사람
	private String shipping_address;		// 받을 주소
	private String receiver_tel;			// 받는 사람의 연락처
	private String shipping_preference;	// 배송 요청사항
	private String activate;			// 활성화 여부
}
