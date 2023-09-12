package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.CartProduct;
import poris.fruitlight.dto.Coupon;

/**
 * 
 * @author 이은지
 *
 */
@Mapper
public interface CartDao {
	/**
	 * 로그인한 회원번호로 장바구니 데이터 select
	 * @param sno(회원번호)
	 * @return List<CartProduct>(장바구니 상품 DTO 리스트)
	 */
	public List<CartProduct> selectCartBySno(int sno);
	
	/**
	 * 로그인한 회원번호로 사용가능한 보유쿠폰 데이터 select
	 * @param sno(회원번호)
	 * @return List<Coupon>(쿠폰 DTO 리스트)
	 */
	public List<Coupon> selectCouponBySno(int sno);
	
	/**
	 * 장바구니에서 상품 delete
	 * @param cart(장바구니에 담긴 상품 DTO)
	 * @return
	 */
	public int deleteCart(Cart cart);
	
	/**
	 * 장바구니에서 상품수량 update
	 * @param cart(장바구니에 담긴 상품 DTO)
	 * @return
	 */
	public int updateStock(Cart cart);
	
	/**
	 * 장바구니에 담긴 상품의 게시글 번호 select
	 * @param pno(장바구니에 담긴 상품번호)
	 * @return int(게시글 번호)
	 */
	public int selectFirstBnoByPno(int pno);
}
