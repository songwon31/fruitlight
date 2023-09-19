package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.Review;
import poris.fruitlight.dto.ReviewListItem;

public interface ReviewService {
	public List<ReviewListItem> getReviewList();
	public int writeReview(Review review);
}
