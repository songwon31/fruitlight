package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import poris.fruitlight.dto.Review;

/**
 * 리뷰와 관련된 DAO.
 * @author 송원석
 *
 */
@Mapper
public interface ReviewDao {
	public int count();
	
	public List<Review> getList();
	
	public List<Review> getShopperList(String shopper_id);
	
	public String getShopperName(int orderNo);
	
	public int insertReview(Review review);
	
	public int updateReview(Review review);
	
	public Review selectReview(int review_no);
	
	public int deleteReview(int review_no);
}