package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.BoardMedia;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.FoodRequiredInfo;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.Product;
import poris.fruitlight.dto.ProductBoard;
import poris.fruitlight.dto.ProductInquiry;
import poris.fruitlight.dto.Review;

/**
 * 
 * @author 고재승, 이은지
 *
 */
public interface DetailViewService {
	/**
	 * 게시글 번호에 해당하는 이미지 번호 조회 메소드
	 * @param bno
	 * @return
	 */
	public List<Integer> getMediaNoList(int bno);
	
	/**
	 * 이미지 번호에 해당하는 이미지 조회 메소드
	 * @author 이은지
	 * @param mno
	 * @return
	 */
	public byte[] getMediaData(int mno);
	
	public List<ProductInquiry> getMProductInquiryList(int bno);
	
	public List<Review> getMReviewList(int bno);
	public List<Review> getMRecentReviewList(int bno);
	public List<Review> getMBestReviewList(int bno);
	
	public byte[] getMainImage(int bno);

	public void writeInquiry(ProductInquiry productInquiry);
	
	
	/**
	 * 게시글 번호에 해당하는 게시글 조회 메소드
	 * @author 고재승
	 * @since 2023.08.13
	 * @param bno - 상품 게시글 번호
	 * @return ProductBoard(상품 게시글 DTO)
	 */
	public ProductBoard getProduct(int bno);
	
	
	/**
	 * 식품 필수 표기 정보 조회 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param bno - 상품 게시글 번호
	 * @return FoodRequiredInfo(상품 필수 표기 정보 DTO)
	 */
	public FoodRequiredInfo getFoodRequiredInfoByBoardNo(int boardNo);
	
	
	/**
	 * 상품 상세 내용 조회 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param boardNo - 상품 게시글 번호
	 * @return BoardMedia(게시글 미디어 파일 정보 DTO)
	 */
	public List<BoardMedia> getProductContentList(int boardNo);
	
	/**
	 * 총 리뷰 개수 조회 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param boardNo - 상품 게시글 번호
	 * @return 리뷰 글 개수
	 */
	public int getTotalReviewStock(int boardNo);
	
	/**
	 * 게시글의 리뷰 조회 메소드
	 * @author 고재승
	 * @since 2023.08.17
	 * @param pager - 페이지 정보
	 * @param boardNo - 출력할 게시글 번호
	 * @return 페이지내 출력 개수만큼의 Review 객체 목록
	 */
	public List<Review> getReviewList(Pager pager, int boardNo);
	
	/**
	 * 리뷰 게시글 검색 결과 조회 메소드
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pager - 페이지 정보
	 * @param searchKeyword - 검색 키워드
	 * @param boardNo - 출력할 게시글 번호
	 * @return 페이지내 출력 개수만큼의 Review 객체 목록
	 */
	public List<Review> getSearchReviewList(Pager pager, String searchKeyword, int boardNo);
	
	
	/**
	 * 베스트 리뷰 게시글 조회 결과 메소드
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pager - 페이지 정보
	 * @param boardNo - 출력할 게시글 번호
	 * @return 페이지내 출력 개수만큼의 Review 객체 목록
	 */
	public List<Review> getSearchBestReviewList(Pager pager, int boardNo);
	
	
	/**
	 * 최근 리뷰 게시글 조회 결과 메소드
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pager - 페이지 정보
	 * @param boardNo - 출력할 게시글 번호
	 * @return 페이지내 출력 개수만큼의 Review 객체 목록
	 */
	public List<Review> getSearchRecentReviewList(Pager pager, int boardNo);
	
	
	/**
	 * 상품상세 페이지에서 보여줄 옵션 상품들 조회
	 * @author 이은지
	 * @param name(현재 상품 이름)
	 * @return List<Product>(같은 이름을 가진 상품 DTO 리스트)
	 */
	public List<ProductBoard> getOptions(String name);
	
	
	/**
	 * 상품상세 페이지에서 보여줄 이미지 조회
	 * @author 이은지
	 * @param bno(상품 게시글 번호)
	 * @return List<ProductBoard>(상품 이미지 정보를 담은 상품 게시글 DTO 리스트)
	 */
	public List<ProductBoard> getImages(int bno);
	
	
	/**
	 * 장바구니에 상품 추가
	 * @author 이은지
	 * @param productList(장바구니에 추가될 상품 DTO 리스트)
	 * @return
	 */
	public int addToCart(List<Cart> cart);
	
	
	/**
	 * 페이징된 상품문의 게시글 목록 조회
	 * @author 이은지
	 * @param pager(상품문의 페이저 DTO)
	 * @param pno(상품문의 목록을 보여줄 상품번호)
	 * @return List<ProductInquiry>(상품문의 DTO 리스트)
	 */
	public List<ProductInquiry> getProductInquiryList(Pager pager, int bno);
	
	
	/**
	 * 상품문의 게시글 페이징을 위한 총 상품문의 개수 조회
	 * @author 이은지
	 * @param pno(상품 번호)
	 * @return int(상품문의 총 개수)
	 */
	public int getTotalProductInquiryNum(int bno);
	
	
	/**
	 * 
	 */
	public void addHelpPoint(String reviewNo);
}