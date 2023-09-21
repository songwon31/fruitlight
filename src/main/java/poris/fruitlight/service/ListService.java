package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.MobileBoardMedia;
import poris.fruitlight.dto.MobileProductForList;
import poris.fruitlight.dto.ProductList;

public interface ListService {
	
	public List<MobileProductForList> getCherryAdList();
	public List<MobileProductForList> getWatermelonAdList();
	public List<MobileProductForList> getMangoAdList();
	
	public List<MobileProductForList> getMobileProductsForList(String keyword);
	
	public List<MobileProductForList> getMobileProductsForListPriceDesc(String keyword);
	
	public List<MobileProductForList> getMobileProductsForListPriceAsc(String keyword);
	
	/**
	 * @author 송원석
	 */
	public MobileBoardMedia getThumbnailImage(int board_no);
	
	/**
	 * @author 김진성
	 * @param pname - 검색한 상품의 이름
	 * @return 검색어가 포함된 상품 DTO
	 */
	 List<ProductList> SearchProductsByPname(String pname);
	 
	 /**
	  * @author 김진성
	  * @return 상품목록에 나올 모든 상품 DTO
	  */
	 List<ProductList> SearchProducts();
	 
	 /**
	  * @author 김진성
	  * @param pid - 상품의 고유 번호
	  * @return 선택된 상품의 고유 번호
	  */
	 public int getSelectBoardNo(int pid);
}
