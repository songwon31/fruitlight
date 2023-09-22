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
	
	@GetMapping(value="/getShopperReviewList", produces="application/json; charset=UTF-8")
	public List<ReviewListItem> getShopperReviewList(String shopper_id) {
		return reviewService.getShopperReviewList(shopper_id);
	}
	
	@GetMapping(value="/getReview", produces="application/json; charset=UTF-8")
	public Review getReview(int review_no) {
		return reviewService.getReview(review_no);
	}
	
	
	@PostMapping(value="/writeReview", produces="application/json; charset=UTF-8")
	public String writeReview(Review review) {
		int result = reviewService.writeReview(review);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("review_no", review.getReview_no());
		
		return jsonObject.toString();
	}
	
	@PostMapping(value="/editReview", produces="application/json; charset=UTF-8")
	public String editReview(Review review) {
		int result = reviewService.editReview(review);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("review_no", review.getReview_no());
		
		return jsonObject.toString();
	}
	
	@GetMapping(value="/deleteReview", produces="application/json; charset=UTF-8")
	public String deleteReview(int review_no) {
		int result = reviewService.deleteReview(review_no);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		
		return jsonObject.toString();
	}
	
	@GetMapping(value="/checkReview", produces="application/json; charset=UTF-8")
	public String checkReview(int order_no, int product_no) {
		int result = reviewService.checkReview(order_no, product_no);
		JSONObject jsonObject = new JSONObject();
		log.info(""+result);
		if (result == 0) {
			jsonObject.put("result", "fail");
		} else {
			jsonObject.put("result", "success");
		}
		
		return jsonObject.toString();
	}
	
}
