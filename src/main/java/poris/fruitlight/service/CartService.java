package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.CartProduct;
import poris.fruitlight.dto.Coupon;

/**
 * 
 * @author 이은지
 *
 */
public interface CartService {
	/**
	 * 회원번호로 장바구니 리스트 조회
	 * @param sno(현재 로그인한 회원 번호)
	 * @return List<CartProduct>(장바구니상품 DTO 리스트)
	 */
	public List<CartProduct> getCartProduct(int sno);
	
	/**
	 * 회원번호로 보유쿠폰 조회
	 * @param sno(현재 로그인한 회원 번호)
	 * @return List<Coupon>(쿠폰 DTO 리스트)
	 */
	public List<Coupon> getCoupon(int sno);
	
	/**
	 * 장바구니에 담긴 상품 삭제
	 * @param cart(삭제될 장바구니 상품 DTO)
	 */
	public void deleteProduct(Cart cart);
	
	/**
	 * 장바구니에 담긴 상품 수량 변경
	 * @param cartProduct(수량이 변경될 장바구니 상품 DTO)
	 */
	public void changeStock(Cart cart);
	
	/**
	 * 장바구니에 담긴 상품의 게시글 번호
	 * @param pno(장바구니에 담긴 상품 번호)
	 * @return int(장바구니에 담긴 상품의 상품게시글 번호)
	 */
	public int getBoardNo(int pno);
}
