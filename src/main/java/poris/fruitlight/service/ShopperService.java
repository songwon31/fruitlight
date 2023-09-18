package poris.fruitlight.service;

import poris.fruitlight.dto.Shopper;

public interface ShopperService {
	/**
	 * 모든 회원 정보 DB를 얻는 메소드
	 * @author 고재승
	 * 보안을 위해 Service, DAO 내부에서만 사용하기 위해 반환값이 없습니다.
	 */
	public void getAllShopper();
	
	
	/**
	 * DB에 해당 회원 존재 여부 확인 메소드
	 * @author 고재승
	 * @param userId
	 * @return True or False
	 * DB에 해당 회원의 존재 유무만 확인
	 */
	public boolean isMember(Shopper shopper);
	
	
	/**
	 * 신규 회원을 DB에 추가하는 메소드
	 * @author 고재승
	 * @param joinParam
	 * @see Join
	 */
	public void insertMember(Shopper shopper);
	
	
	/**
	 * ID와 PW가 일치하는 회원 정보를 가져오는 메소드
	 * @param shopper
	 * @return 세션에 유저 정보를 전달하기 위한 Shopper DTO
	 */
	public Shopper getShopperById(Shopper shopper);
	
	public void setShopperAutoLogin(Shopper shopper);
	
	public void deleteShopper(Shopper shopper);
	
	public String getSearchShopperId(Shopper shopper);
	
	public String getSearchShopperPassword(Shopper shopper);
	
	//김시온
	public Shopper getShopperByShopperId(String shopperId);
}
