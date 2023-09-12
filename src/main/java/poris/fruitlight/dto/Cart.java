package poris.fruitlight.dto;

import lombok.Data;

/**
 * CART (장바구니) 테이블 DTO
 * @author 이은지
 *
 */
@Data
public class Cart {
	private int SHOPPER_NO;			//회원번호
	private int PRODUCT_NO;			//상품번호
	private int CART_PRODUCT_STOCK;	//장바구니 상품수량
}
