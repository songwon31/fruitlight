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
	
	public String getShopperName(int orderNo);
	
	public int insertReview(Review review);
   
}