package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.WishListItem;

public interface WishService {
	
	public List<WishListItem> getShopperWishList(String shopper_id);
	public int deleteWish(int product_no, int shopper_no);
	public int addToCart(Cart cart);
	public int checkCart(Cart cart);
	/*
	public List<ReviewListItem> getReviewList();
	public List<ReviewListItem> getShopperReviewList(String shopper_id);
	public int writeReview(Review review);
	public int editReview(Review review);
	public Review getReview(int review_no);
	public int deleteReview(int review_no);
	*/
}
