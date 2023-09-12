package poris.fruitlight.dto;

import lombok.Data;

/**
 * 배송지 DB DTO
 * @author 고재승
 */
@Data
public class AddressBook {
	private int addressNo;				// 배송지 고유번호(PK)
	private int shopperNo;				// 회원 고유번호(FK)
	private String shippingName;		// 받는 사람
	private String shippingAddress;		// 받을 주소
	private String receiverTel;			// 받는 사람의 연락처
	private String shippingPreference;	// 배송 요청사항
	private String activate;			// 활성화 여부
}
