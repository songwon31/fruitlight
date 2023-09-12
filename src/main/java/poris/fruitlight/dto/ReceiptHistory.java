package poris.fruitlight.dto;

import lombok.Data;

/**
 * RECEIPT_HISTORY (주문상세내역) 테이블 DTO
 * @author 이은지
 */
@Data
public class ReceiptHistory {
	private int ORDER_NO;	//주문 번호
	private int PRODUCT_NO;	//상품 번호
	private int PRICE;		//상품 가격
	private int STOCK;		//상품 수량
}
