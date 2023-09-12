package poris.fruitlight.dto;

import lombok.Data;

/**
 * 배송 요청사항 JSP 페이지 - 유저가 선택한 요청 사항 수집 DTO
 * @author 고재승
 */
@Data
public class DeliveryPreferencesParam {
	private String requiredCheckType;		// 필수 요청 사항 종류
	private String requiredMessage;			// 필수 요청 사항의 메세지
	private String passwordCheckType;		// 공동 현관 출입 비밀번호 유무
	private String passwordMessage;			// 공동 현관 출입 비밀번호
}
