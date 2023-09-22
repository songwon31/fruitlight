package poris.fruitlight.dto;

import lombok.Data;

/**
 * 모바일 상품 목록 리스트에 필요한 상품 정보 DTO
 * @author 송원석
 */
@Data
public class ProductPart {
	private int product_no;
    private String product_name;
    private int product_price;
    private int discount_rate;
    private int discount_price;
}