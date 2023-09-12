package poris.fruitlight.dto;

import lombok.Data;

/**
 * 장바구니 관련 데이터 조회 및 추가  DTO
 * @author 이은지
 *
 */
@Data
public class CartProduct {
	private int PRODUCT_NO;			//상품 번호
	private int CART_PRODUCT_STOCK;	//상품 수량
	private int PRODUCT_STOCK;		//상품 재고
	private byte[] MEDIA_DATA;		//상품 이미지
	private String PRODUCT_NAME;	//상품 이름
	private String PRODUCT_OPTION;	//상품 옵션
	private int DISCOUNT_PRICE;		//상품 가격
	private String base64Img;		//이미지 변환
}
