package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.MorderHistory;
import poris.fruitlight.dto.OrderHistory;
import poris.fruitlight.dto.OrderHistoryOrderList;
import poris.fruitlight.dto.OrderParam;
import poris.fruitlight.dto.OrderSearchParam;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.ReceiptHistory;

/**
 * 상품 정보와 관련된 DAO.
 * @author 김진성
 *
 */
@Mapper
public interface OrderHistoryDao {
   /**
    * @author 김진성
    * @param pager
    * @return 주문내역 DTO
    */
   public List<OrderHistoryOrderList> SelectOrderHistory(Pager pager);
   
   public List<MorderHistory> selectOrderHistory(int shopperNo);
   
   /**
    * @author 김진성
    * @param orderSearch (주문내역 내 검색된 내용)
    * @return 주문내역 DTO
    */
   public List<OrderHistoryOrderList> SearchOrdersByPname(OrderSearchParam orderSearch);
   
   /**
    * @author 김진성
    * @param shopperNo (회원 번호)
    * @return 사용자가 주문한 총 주문내역 수
    */
 
   public int SelectTotalOrderHistory(int shopperNo);
   
   /**
    * 결제 시 주문내역에 데이터 insert
    * @author 이은지
    * @param orderHistory(주문내역 DTO)
    */
   public void insertOrderHistory(OrderHistory orderHistory);
   
   /**
    * 결제 시 영수증내역(주문 상세)에 데이터 insert
    * @author 이은지
    * @param receiptHistory(영수증 내역 DTO)
    */
   public void insertReceiptHistory(ReceiptHistory receiptHistory);
   
   /**
    * 결제 후 사용한 쿠폰의 USED를 1로 update
    * @author 이은지
    * @param coupon(쿠폰 DTO)
    */
   public void updateCouponUsed(Coupon coupon);
   
   /**
    * 결제 후 구매한 상품 수량만큼 상품의 재고가 줄도록 update
    * @author 이은지
    * @param orderParam(주문 관련 DTO)
    */
   public void updateProductStock(OrderParam orderParam);
}