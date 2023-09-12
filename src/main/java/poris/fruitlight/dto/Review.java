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
	private int reviewNo;				// 리뷰 고유번호
	private int orderNo;				// 결제 고유번호
	private int productNo;				// 상품 고유 번호
	private int boardNo;				// 게시글 고유번호
	private int starRate;				// 평점 ( 0 ~ 100 )
	private int helpPoint;				// 평점 ( 0 ~ 100 )
	private String content;				// 리뷰 내용
	private String shopperName;			// 리뷰 작성자
	private String productName;			// 리뷰 작성자
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date writeDate;				// 리뷰 작성일
}