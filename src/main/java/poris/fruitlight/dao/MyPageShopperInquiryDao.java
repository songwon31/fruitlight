package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.CartProduct;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.ProductInquiry;

/**
 * 
 * @author 이은지
 *
 */
@Mapper
public interface MyPageShopperInquiryDao {
	public List<String> selectShopperInquiryProductList(int sno);
	public List<ProductInquiry> selectShopperInquiry(ProductInquiry productInquiry);
	/**
	 * 페이저로 회원별 상품문의 목록 select
	 * @param pager(페이저 DTO)
	 * @return List<ProductInquiry>(상품문의 DTO 리스트)
	 */
	public List<ProductInquiry> selectShopperInquiryPager(Pager pager);
	
	/**
	 * 회원별 상품문의 목록 페이징을 위한 총 상품문의 수 count
	 * @param sno(회원번호)
	 * @return 총 상품문의 수
	 */
	public int countShopperInquiry(int sno);
	
	/**
	 * 상품문의 delete
	 * @param ino(상품문의 번호)
	 * @return
	 */
	public int deleteShopperInquiry(int ino);
	
	/**
	 * 회원번호로 회원이 보유한 쿠폰 리스트 select
	 * @param sno(회원번호)
	 * @return List<Coupon>(쿠폰 DTO 리스트)
	 */
	public List<Coupon> selectCouponBySno(int sno);
}
