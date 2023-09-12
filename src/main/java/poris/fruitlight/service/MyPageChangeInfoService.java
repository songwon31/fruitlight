package poris.fruitlight.service;

import poris.fruitlight.dto.MyPageChangeInfo;
import poris.fruitlight.dto.Shopper;

public interface MyPageChangeInfoService {
	public Shopper getShopper(int shopperNo);
	public void modify(Shopper shopper);
	
	
	/**
	 * 회원의 중복 ID를 검사하는 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param shopper - 유저 정보
	 * @return 논리값
	 */
	public boolean shopperIdDuplicateCheck(Shopper shopper);
	
	/**
	 * 유저가 입력한 데이터가 DB의 PW와 동일한지 확인 요청하는 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param shopper - 회원 정보
	 * @return boolean
	 */
	public boolean isShopperPw(Shopper shopper);
	
	
	/**
	 * 유저가 입력한 연락처 데이터 갱신을 요청하는 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param shopper - 회원 정보
	 */
	public void setShopperTel(Shopper shopper);
	
	
	/**
	 * 유저가 입력한 비밀번호 데이터 갱신을 요청하는 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param shopper - 회원 정보
	 */
	public void setShopperPassword(Shopper shopper);
}
