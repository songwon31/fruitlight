package poris.fruitlight.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poris.fruitlight.dao.ProductDao;
import poris.fruitlight.dao.ReviewDao;
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
			String option = productDao.selectProductOption(reviewList.get(i).getProduct_no());
			ReviewListItem item = new ReviewListItem();
			item.setReview_no(reviewList.get(i).getReview_no());
			item.setWrite_date(reviewList.get(i).getWrite_date());
			item.setProduct_name(reviewList.get(i).getProduct_name());
			item.setProduct_option(option);
			item.setContent(reviewList.get(i).getContent());
			
			list.add(item);
		}
		
		return list;
	}
}
