package poris.fruitlight.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Review;
import poris.fruitlight.dto.ReviewListItem;
import poris.fruitlight.service.ReviewService;

/**
 * @author 송원석
 */
@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {
	@Resource
	private ReviewService reviewService;
	
	@GetMapping(value="/getReviewList", produces="application/json; charset=UTF-8")
	public List<ReviewListItem> getReviewList() {
		return reviewService.getReviewList();
	}
	
	@PostMapping(value="/writeReview", produces="application/json; charset=UTF-8")
	public String writeReview(Review review) {
		int result = reviewService.writeReview(review);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("review_no", review.getReview_no());
		
		return jsonObject.toString();
	}
	
	
}
