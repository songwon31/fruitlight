package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import poris.fruitlight.dto.Shopper;

/**
 * 회원 정보 관련 DAO
 * @author 고재승
 */
@Mapper
public interface ShopperDao {
	/**
	 * 모든 유저 정보  조회 메소드
	 * @author 고재승
	 * @return 회원정보  DTO 목록
	 */
	public List<Shopper> selectAllShopper();
	
	/**
	 * 1명의 회원 정보 조회 메소드
	 * @param shopper - 회원 정보
	 * @return 회원정보 DTO
	 */
	public Shopper selectShopper(Shopper shopper);
	
	/**
	 * 회원 고유번호와 일치하는 회원 정보 조회 메소드
	 * @author 고재승
	 * @param sid - 회원 고유번호
	 * @return 회원정보 DTO
	 */
	public Shopper selectShopperBySid(int sid);
	
	/**
	 * 회원 고유번호와 일치하는 회원 번호 조회 메소드
	 * @author 고재승
	 * @param shopperId - 회원 고유 번호
	 * @return
	 */
	public String selectShopperId(String shopperId);
	
	
	/**
	 * DB에 회원 정보 추가 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 */
	public void insertShopper(Shopper shopper);
	
	
	/**
	 * 회원 정보 수정 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 */
	public void updateShopper(Shopper shopper);
	/**
	 * 회원 연락처 정보 수정 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 */
	public void updateShopperTel(Shopper shopper);
	/**
	 * 회원 비밀번호 정보 수정 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 */
	public void updateShopperPW(Shopper shopper);
	/**
	 * 회원 자동 로그인 설정 수정 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 */
	public void updateShopperAutoLoginState(Shopper shopper);
	
	/**
	 * 회원 비활성화(회원 탈퇴) 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 */
	public void deleteShopper(Shopper shopper);
	
	/**
	 * 연락처와 실명으로 회원 아이디를 조회하는 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 * @return - shopperId(회원 아이디)
	 */
	public String selectSearchShopperEmail(Shopper shopper);
	
	/**
	 * 연락처와 실명으로 회원 아이디를 조회하는 메소드
	 * @author 고재승
	 * @param shopper - 회원 정보
	 * @return - shopperId(회원 아이디)
	 */
	public String selectSearchShopperPassword(Shopper shopper);
}
