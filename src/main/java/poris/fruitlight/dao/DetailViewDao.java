package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import poris.fruitlight.dto.BoardMedia;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.FoodRequiredInfo;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.Product;
import poris.fruitlight.dto.ProductBoard;
import poris.fruitlight.dto.ProductInquiry;
import poris.fruitlight.dto.Review;

@Mapper
public interface DetailViewDao {
	public List<Review> selectProductReview(int bno);
	
	public List<ProductInquiry> selectProductInquiry(int bno);
	
	public List<Integer> selectMediaNoListByBno(int bno);
	
	public BoardMedia SelectProductContentImageByBoardNo(int mno);
	
	/**
	 * 게시글 번호로 상품 게시글 select
	 * @author 이은지
	 * @param bno(게시글 번호)
	 * @return ProductBoard(게시글 DTO)
	 */
	public ProductBoard selectByBno(int bno);
	
	/**
	 * 게시글 번호를 기준으로 식품 필수 표기 정보의 모든 정보를 조회하는 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param boardNo - 게시판 번호
	 * @return 식품 필수 표기 정보 DTO
	 */
	public FoodRequiredInfo SelectRequiredInfoByBoardNo(int boardNo);
	
	/**
	 * 게시글의 고유 번호를 기준으로 상품의 미디어 파일을 조회하는 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param boardNo - 게시판 번호
	 * @return 식품 필수 표기 정보 DTO
	 */
	public List<BoardMedia> SelectProductContentByBoardNo(int boardNo);
	
	/**
	 * 게시글의 고유 번호를 기준으로 리뷰 글 개수를 조회하는 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param boardNo - 게시판 번호
	 * @return 총 리뷰 개수 정보
	 */
	public int SelectTotalReviewStock(int boardNo);
	
	/**
	 * 페이저 객체로 페이지별 설정한 개수만큼 리뷰 목록을 조회하는 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param pager
	 * @return 리뷰 목록
	 */
	public List<Review> selectReviewList(Pager pager);
	
	/**
	 * 페이저 객체로 페이지별 설정한 개수만큼 리뷰 목록을 조회하는 메소드
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pager
	 * @return 검색 조건에 해당하는 리뷰 목록
	 */
	public List<Review> selectSearchReviewList(@Param("Pager") Pager pager, @Param("Keyword") String searchKeyword);
	
	/**
	 * 페이저 객체로 페이지별 설정한 개수만큼 리뷰 목록을 조회하는 메소드
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pager
	 * @return 베스트 리뷰 목록
	 */
	public List<Review> selectBestReviewList(Pager pager);
	
	
	/**
	 * 페이저 객체로 페이지별 설정한 개수만큼 리뷰 목록을 조회하는 메소드
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pager
	 * @return 최신순 리뷰 목록
	 */
	public List<Review> selectRecentReviewList(Pager pager);
	
	public void updateAddHelpPoint(String reviewNo);
	
	/**
	 * 상품번호로 상품 이미지들 select
	 * @author 이은지
	 * @param bno(상품번호)
	 * @return List<ProductBoard>(게시글 DTO 리스트)
	 */
	public List<ProductBoard> selectImgsByBno(int bno);
	
	/**
	 * 상품이름이 같은 상품들 select => 게시글의 옵션
	 * @author 이은지
	 * @param name(상품이름)
	 * @return List<Product>(상품 DTO 리스트)
	 */
	public List<Product> selectByName(String name);
	
	/**
	 * 상품 게시글에서 상품 선택 후 장바구니에 상품 추가
	 * @author 이은지
	 * @param cart(장바구니 상품 DTO)
	 * @return
	 */
	public int updateCart(Cart cart);
	
	/**
	 * 페이저로 상품문의 목록 select
	 * @author 이은지
	 * @param pager(페이저 DTO)
	 * @return List<ProductInquiry>(상품문의 DTO 리스트)
	 */
	public List<ProductInquiry> selectProductInquiryPager(Pager pager);
	
	/**
	 * 게시글 번호에 해당하는 상품문의 목록 페이징을 위한 총 상품문의 수 count
	 * @author 이은지
	 * @param bno(게시글 번호)
	 * @return 총 상품문의 수
	 */
	public int count(int bno);
}
