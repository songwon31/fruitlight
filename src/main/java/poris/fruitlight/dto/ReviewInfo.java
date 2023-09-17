package poris.fruitlight.dto;

import lombok.Data;

/**
 * 상품 상세 페이지 JSP - 리뷰 평점 출력에 사용하는 DTO
 * @author 고재승
 */
@Data
public class ReviewInfo {
	private int starRateAvg;				// 리뷰 평균 점수
	private float totalReviewScore;			// 리뷰 총 점수
	private int reviewCount;
}