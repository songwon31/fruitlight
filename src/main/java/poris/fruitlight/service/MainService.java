package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.ProductList;

public interface MainService {
	/**
	 * @author 김진성
	 * @return 메인 배너에 나올 모든 상품 DTO
	 */
   public List<ProductList> getMainList();
   
   /**
	 * @author 김진성
	 * @return 오늘의 발견 품목에 나올 모든 상품 DTO
	 */
   public List<ProductList> getTodayList();
   
   /**
	 * @author 김진성
	 * @return 오늘의 판매자 특가 품목에 나올 모든 상품 DTO
	 */
   public List<ProductList> getSellerList();
   
   /**
	 * @author 김진성
	 * @return 카테고리별 추천상품의 메인베너에 나올 모든 상품 DTO
	 */
   public List<ProductList> getCateMainList();
   
   /**
	 * @author 김진성
	 * @return 카테고리별 추천상품의 서브 품목에 나올 모든 상품 DTO
	 */
   public List<ProductList> getCateSubList();
   
   
   /**
	 * 상품 고유번호를 기준으로 게시판의 번호를 조회하는 메소드
	 * @author 고재승
	 * @param pid - 제품(상품) 고유번호
	 */
   public int getSelectBoardNo(int pid);
   
   /**
    * 동일한 상품명을 가진 상품 정보 조회 메소드
    * @author 고재승
    * @since 2023.08.17
    * @param pname - 상품 이름
    * @return 상품 DTO 리스트
    */
   public List<ProductList> SelectListName(String pname);
}