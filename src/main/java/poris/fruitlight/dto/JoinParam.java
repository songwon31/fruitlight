package poris.fruitlight.dto;

import lombok.Data;

/**
 * 회원가입 JSP 페이지 - 회원가입 데이터를 서버에 전송하는 DTO
 * @author KOSA
 *
 */
@Data
public class JoinParam {
	private String userId;					// 유저 아이디(이메일)
	private String userPassword;			// 유저 비밀번호
	private String userPasswordCheck;		// 유저 비밀번호 재확인
	private String userName;				// 유저 실명
	private String userTel;					// 유저 연락처
	private String acceptAgreement;			// 필수 동의서 동의 여부
}
