package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.Review;
import poris.fruitlight.dto.ReviewListItem;

public interface ReviewService {
	public List<ReviewListItem> getReviewList();
	public List<ReviewListItem> getShopperReviewList(String shopper_id);
	public int writeReview(Review review);
	public int editReview(Review review);
	public Review getReview(int review_no);
	public int deleteReview(int review_no);
	public int checkReview(int order_no, int product_no);
}
