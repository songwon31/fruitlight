package poris.fruitlight.dto;

import java.util.Date;

import lombok.Data;

/**
 * ORDER_HISTORY (주문내역) 테이블 DTO
 * @author 이은지
 *
 */
@Data
public class OrderHistory {
	private int ORDER_NO;					//주문 번호
	private int SHOPPER_NO;					//유저 번호
	private int ADDRESS_NO;					//배송지 번호
	private Date ORDER_DATE;				//결제 날짜
	private int TOTAL_PRICE;				//총 상품가격
	private int DISCOUNT_PRICE;				//할인금액
	private int SHIPPING_PRICE;				//배송비
	private int PAYMENT_PRICE;				//결제금액
	private String PAYMENT_TYPE;			//결제 유형(계좌이체, 신용/체크카드, 휴대폰, 무통장입금(가상계좌))
	private String CASH_RECEIPT_PURPOSE;	//현금영수증 발행목적(소득공제, 지출증빙)
	private String CASH_RECEIPT_TYPE;		//현금영수증 종류(휴대폰번호, 현금영수증카드)
	private String CASH_RECEIPT_NO;			//현금영수증 번호
}
