package poris.fruitlight.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poris.fruitlight.dao.ProductDao;
import poris.fruitlight.dao.WishDao;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.WishListItem;
import poris.fruitlight.dto.WishListItemDB;

@Service
public class WishServiceImpl implements WishService {
	@Resource
	private WishDao wishDao;
	@Resource
	private ProductDao productDao;
	
	@Override
	public List<WishListItem> getShopperWishList(String shopper_id) {
		List<WishListItem> list = new ArrayList<>();
		List<WishListItemDB> tempList = wishDao.selectListByShopperId(shopper_id);
		for (WishListItemDB wishListItemDB : tempList) {
			DecimalFormat df = new DecimalFormat("###,###,###,###");
			
			WishListItem wishListItem = new WishListItem();
			wishListItem.setShopper_no(wishListItemDB.getShopper_no());
			wishListItem.setProduct_no(wishListItemDB.getProduct_no());
			wishListItem.setProduct_name(wishListItemDB.getProduct_name());
			wishListItem.setProduct_option(wishListItemDB.getProduct_option());
			wishListItem.setDiscount_price(df.format(wishListItemDB.getDiscount_price()) + "원");
			list.add(wishListItem);
		}
		return list;
	}
	
	@Override
	public int deleteWish(int product_no, int shopper_no) {
		return wishDao.deleteWish(product_no, shopper_no);
	}
	
	@Override
	public int addToCart(Cart cart) {
		return wishDao.insertCart(cart);
	}
	
	@Override
	public int checkCart(Cart cart) {
		return wishDao.countCart(cart);
	}
	/*
	@Override
	public List<ReviewListItem> getReviewList() {
		List<ReviewListItem> list = new ArrayList<ReviewListItem>();
		List<Review> reviewList = reviewDao.getList();
		
		for (int i=0; i<reviewList.size(); ++i) {
			Product product = productDao.selectProductById(reviewList.get(i).getProduct_no());
			ReviewListItem item = new ReviewListItem();
			item.setReview_no(reviewList.get(i).getReview_no());
			item.setProduct_no(product.getPRODUCT_NO());
			item.setWrite_date(reviewList.get(i).getWrite_date());
			item.setProduct_name(product.getPRODUCT_NAME());
			item.setProduct_option(product.getPRODUCT_OPTION());
			item.setContent(reviewList.get(i).getContent());
			
			list.add(item);
		}
		
		return list;
	}
	
	@Override
	public List<ReviewListItem> getShopperReviewList(String shopper_id) {
		List<ReviewListItem> list = new ArrayList<ReviewListItem>();
		List<Review> reviewList = reviewDao.getShopperList(shopper_id);
		
		for (int i=0; i<reviewList.size(); ++i) {
			Product product = productDao.selectProductById(reviewList.get(i).getProduct_no());
			ReviewListItem item = new ReviewListItem();
			item.setReview_no(reviewList.get(i).getReview_no());
			item.setProduct_no(product.getPRODUCT_NO());
			item.setWrite_date(reviewList.get(i).getWrite_date());
			item.setProduct_name(product.getPRODUCT_NAME());
			item.setProduct_option(product.getPRODUCT_OPTION());
			item.setContent(reviewList.get(i).getContent());
			
			list.add(item);
		}
		
		return list;
	}
	
	@Override
	public Review getReview(int review_no) {
		return reviewDao.selectReview(review_no);
	}
	
	@Override
	public int writeReview(Review review) {
		review.setWrite_date(new Date());
		review.setHelp_point(0);
		review.setStar_rate(review.getStar_rate() * 20);
		return reviewDao.insertReview(review);
	}
	
	@Override
	public int editReview(Review review) {
		review.setWrite_date(new Date());
		review.setStar_rate(review.getStar_rate() * 20);
		return reviewDao.updateReview(review);
	}
	
	@Override
	public int deleteReview(int review_no) {
		return reviewDao.deleteReview(review_no);
	}
	*/
}
