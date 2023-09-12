package poris.fruitlight.dto;

import lombok.Data;


/**
 * 결제 페이지 - 주문 상품 목록 출력  DTO
 * @author 고재승
 */
@Data
public class DeliveryParam {
	private String name;				// 배송 제품명
	private int stock;					// 배송 제품 개수
	private int productPrice;			// 배송 제품 가격
}