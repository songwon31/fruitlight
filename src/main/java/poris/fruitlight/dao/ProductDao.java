package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import poris.fruitlight.dto.MobileBoardMedia;
import poris.fruitlight.dto.MobileProductForListDB;
import poris.fruitlight.dto.Product;
import poris.fruitlight.dto.ProductList;

/**
 * 상품 정보와 관련된 DAO.
 * @author 고재승, 김진성
 *
 */
@Mapper
public interface ProductDao {
	
	public List<MobileProductForListDB> selectMobileProductList(String keyword);
	
	public List<Product> selectCherryAdList();
	
	public List<Product> selectWatermelonAdList();
	
	public List<Product> selectMangoAdList();
	
	public Product selectProductById(int product_no);
	
	public List<Product> selectProductList(String keyword);
	
	List<Integer> selectStarRateList(int product_no);
	
	/**
	 * @author 송원석
	 * @return 단일 상품 썸네일 가져오기
	 */
	public MobileBoardMedia selectThumbnailImage(int board_no);
	
   /**
    * @author 김진성
    * @return 메인 배너에 보여질 상품 목록 리스트
    */
   public List<ProductList> MainBanner();
   
   /**
    * @author 김진성
    * @return 오늘의 발견 품목에 보여질 상품 목록 리스트
    */
   public List<ProductList> TodayDiscovery();
   
   /**
    * @author 김진성
    * @return 오늘의 판매자 특가 품목에 보여질 상품 목록 리스트
    */
   public List<ProductList> TodaySeller();
   
   /**
    * @author 김진성
    * @return 카테고리별 추천 상품 목록의 메인 베너에 보여질 상품 목록 리스트
    */
   public List<ProductList> CategoryMain();
   
   /**
    * @author 김진성
    * @return 카테고리별 추천 상품 목록의 서브 품목에 보여질 상품 목록 리스트
    */
   public List<ProductList> CategorySub();
   
   /**
    * DB에서 PRODUCT 테이블과 PRODUCT_BOARD 테이블에서 상품 번호를 기준으로 게시판 번호를 조회하는 메소드
    * @author 고재승
    * @param pid - 상품 고유번호
    * @return 상세 게시판 이동을 위한 게시판 번호
    */
   public int SelectDetailView(int pid);
   
   /**
    * @author 김진성
    * @return 전체 상품 List 출력
    */
   
   public List<ProductList> SearchProducts();
   
   /**
    * @author 김진성
    * @param pname - 상품 이름
    * @return 검색한 상품이름을 토대로 List 출력
    */
   
   public List<ProductList> SearchProductsByPname(String pname);
   
}