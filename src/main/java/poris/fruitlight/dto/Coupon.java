package poris.fruitlight.dto;

import lombok.Data;

/**
 * COUPON (쿠폰) 테이블 DTO
 * @author 이은지
 *
 */
@Data
public class Coupon {
	private int COUPON_NO;		//쿠폰 번호
	private int SHOPPER_NO;		//회원 번호
	private String COUPON_NAME;	//쿠폰 이름
	private String COUPON_TYPE;	//쿠폰 분류(원 or %)
	private String COUPON_KIND;	//쿠폰 종류(배송비 or 상품)
	private int DISCOUNT_PRICE;	//쿠폰 할인금액
	private int DISCOUNT_RULE;	//쿠폰 적용 조건 금액
	private boolean USED;		//쿠폰 사용여부
}
