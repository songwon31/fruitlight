package poris.fruitlight.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poris.fruitlight.dao.ProductDao;
import poris.fruitlight.dao.ReviewDao;
import poris.fruitlight.dto.Product;
import poris.fruitlight.dto.Review;
import poris.fruitlight.dto.ReviewListItem;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Resource
	private ReviewDao reviewDao;
	@Resource
	private ProductDao productDao;
	
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
}
