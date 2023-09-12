package poris.fruitlight.dto;

import lombok.Data;

/**
 * 로그인 JSP 페이지 - 로그인 요청 데이터를 서버에 전송하는 DTO
 * @author KOSA
 */
@Data
public class LoginParam {
	private String userId;			// 유저 ID
	private String userPw;			// 유저 비밀번호
	private String autoLogin;		// 자동 로그인 체크 여부
}
