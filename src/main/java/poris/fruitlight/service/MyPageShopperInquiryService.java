package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.ProductInquiry;

/**
 * 
 * @author 이은지
 *
 */
public interface MyPageShopperInquiryService {
	public List<String> getMShopperInquiryProductList(int sno);
	public List<ProductInquiry> getMShopperInquiryList(ProductInquiry productInquiry);
	/**
	 * 회원별 상품문의 목록 조회
	 * @param pager(상품문의 페이저)
	 * @param sno(상품문의 목록을 보여줄 회원번호)
	 * @return List<ProductInquiry>(상품문의 DTO 리스트)
	 */
	public List<ProductInquiry> getShopperInquiryList(Pager pager, int sno);
	
	/**
	 * 회원별 총 상품문의 수 조회
	 * @param sno(회원번호)
	 * @return int(회원별 상품문의 총 개수)
	 */
	public int getTotalShopperInquiryNum(int sno);
	
	/**
	 * 상품문의 글 삭제
	 * @param ino(삭제할 상품문의 번호)
	 */
	public void deleteShopperInquiry(int ino);
	
	/**
	 * 회원별 보유쿠폰 목록 조회 - 추후 위치 이동
	 * @param sno(보여줄 쿠폰 목록을 가진 현재 로그인한 회원 번호)
	 * @return List<Coupon>(보유 쿠폰 DTO 리스트)
	 */
	public List<Coupon> getCoupon(int sno);
}
