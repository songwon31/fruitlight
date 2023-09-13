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
public class Review {
	private int review_no;				// 리뷰 고유번호
	private int order_no;				// 결제 고유번호
	private int product_no;				// 상품 고유 번호
	private int board_no;				// 게시글 고유번호
	private int star_rate;				// 평점 ( 0 ~ 100 )
	private int help_point;				// 평점 ( 0 ~ 100 )
	private String content;				// 리뷰 내용
	private String shopper_name;			// 리뷰 작성자
	private String product_name;			// 리뷰 작성자
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date write_date;				// 리뷰 작성일
}