package poris.fruitlight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.CartDao;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.CartProduct;
import poris.fruitlight.dto.Coupon;

/**
 * 
 * @author 이은지
 *
 */
@Service
@Slf4j
public class CartServiceImpl implements CartService {
	@Autowired
	CartDao cartDao;
	
	//장바구니 목록 가져오기
	@Override
	public List<CartProduct> getCartProduct(int sno) {
		List<CartProduct> list = cartDao.selectCartBySno(sno);
		return list;
	}
	
	//장바구니 상품 이미지 가져오기
	@Override
	public CartProduct getMediaData(int pno) {
		CartProduct cartProduct = cartDao.selectMediaDataByPno(pno);
		return cartProduct;
	}

	//쿠폰 목록 가져오기
	@Override
	public List<Coupon> getCoupon(int sno) {
		List<Coupon> list = cartDao.selectCouponBySno(sno);
		return list;
	}
	
	//상품삭제
	@Override
	public void deleteProduct(Cart cart) {
		cartDao.deleteCart(cart);
	}
	
	//수량변경
	@Override
	public void changeStock(Cart cart) {
		cartDao.updateStock(cart);
	}

	//상품게시글 번호 가져오기
	@Override
	public int getBoardNo(int pno) {
		int bno = cartDao.selectFirstBnoByPno(pno);
		return bno;
	}
}
