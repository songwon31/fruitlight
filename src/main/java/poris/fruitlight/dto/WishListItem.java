package poris.fruitlight.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * DB 리뷰 테이블 정보 DTO
 * @author 고재승
 * @since 2023.08.17
 */
@Data
public class WishListItem {
	private int shopper_no;
	private int product_no;
	private String product_name;
	private String product_option;
    private String discount_price;
}