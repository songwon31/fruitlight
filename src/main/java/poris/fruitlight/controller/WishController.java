package poris.fruitlight.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.WishListItem;
import poris.fruitlight.service.WishService;

/**
 * @author 송원석
 */
@RestController
@RequestMapping("/wish")
@Slf4j
public class WishController {
	@Resource
	private WishService wishService;
	
	@GetMapping(value="/getShopperWishList", produces="application/json; charset=UTF-8")
	public List<WishListItem> getShopperWishList(String shopper_id) {
		return wishService.getShopperWishList(shopper_id);
	}
	
	@GetMapping(value="/deleteWish", produces="application/json; charset=UTF-8")
	public String deleteWish(int product_no, int shopper_no) {
		int result = wishService.deleteWish(product_no, shopper_no);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		
		return jsonObject.toString();
	}
	
	@GetMapping(value="/addToCart", produces="application/json; charset=UTF-8")
	public String addToCart(int product_no, int shopper_no) {
		Cart cart = new Cart();
		cart.setPRODUCT_NO(product_no);
		cart.setSHOPPER_NO(shopper_no);
		cart.setCART_PRODUCT_STOCK(1);
		
		int isInCart = wishService.checkCart(cart);
		JSONObject jsonObject = new JSONObject();
		if (isInCart == 0) {
			int result = wishService.addToCart(cart);
			jsonObject.put("result", "success");
		} else {
			jsonObject.put("result", "alreadyInCart");
		}
		
		return jsonObject.toString();
	}
	
	@GetMapping(value="/isInWish", produces="application/json; charset=UTF-8")
	public String isInWish(int product_no, String shopper_id) {
		JSONObject jsonObject = new JSONObject();
		int isWish = wishService.checkWish(product_no, shopper_id);
		if (isWish == 0) {
			jsonObject.put("result", "false");
		} else {
			jsonObject.put("result", "true");
		}
		
		return jsonObject.toString();
	}
	
	@GetMapping(value="/putInWishList", produces="application/json; charset=UTF-8")
	public String putInWishList(int product_no, String shopper_id) {
		int result = wishService.putInWishList(product_no, shopper_id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		
		return jsonObject.toString();
	}
	
	@GetMapping(value="/removeFromWishList", produces="application/json; charset=UTF-8")
	public String deleteWish(int product_no, String shopper_id) {
		int result = wishService.removeFromWishList(product_no, shopper_id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		
		return jsonObject.toString();
	}
	/*
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
	*/
}
