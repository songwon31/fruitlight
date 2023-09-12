package poris.fruitlight.dto;

import lombok.Data;

/**
 * DB 회원 테이블 DTO
 * @author 고재승
 */
@Data
public class Shopper {
	private int shopperNo;				// 회원 번호
	private String shopperId;			// 회원 ID(이메일 형식)
	private String shopperPw;			// 회원 비밀번호
	private String shopperName;			// 회원 실명
	private String shopperTel;			// 회원 연락처
	private String shopperAutoLogin;	// 회원 자동로그인 여부
	private String activate;			// 활성화 여부
}
