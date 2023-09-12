package poris.fruitlight.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * 마이페이지(내 정보 변경) 회원 정보 수정에 필요한 DTO
 * @author 김진성
 *
 */
@Data
public class MyPageChangeInfo {
	private String userId;
	private String userPassword;
	private String userPasswordCheck;
	private String userName;
	private String userTel;
	private String userAddress;
}
