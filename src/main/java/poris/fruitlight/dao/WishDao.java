package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.WishListItemDB;

/**
 * 리뷰와 관련된 DAO.
 * @author 송원석
 *
 */
@Mapper
public interface WishDao {
	public List<WishListItemDB> selectListByShopperId(String shopper_id);
	public int deleteWish(@Param("product_no") int product_no, @Param("shopper_no") int shopper_no);
	public int insertCart(Cart cart);
	public int countCart(Cart cart);
	public int countWish(@Param("product_no") int product_no, @Param("shopper_id") String shopper_id);
	public int putInWishList(@Param("product_no") int product_no, @Param("shopper_id") String shopper_id);
	public int getshopperNoById(String shopper_id);
	public int removeFromWishList(@Param("product_no") int product_no, @Param("shopper_no") int shopper_no);
}