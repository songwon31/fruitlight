package poris.fruitlight.dto;

import lombok.Data;

/**
 * 상품상세 -> 결제 / 장바구니 -> 결제  DTO
 * @author 이은지
 *
 */
@Data
public class OrderParam {
	private int productNo;			//상품 번호
	private String productName;		//상품 이름
	private String productOption;	//상품 옵션
	private int productStock;		//상품 수량
	private int productPrice;		//상품 가격
}