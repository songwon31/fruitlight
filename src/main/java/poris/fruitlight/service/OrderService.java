package poris.fruitlight.service;

import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.OrderHistory;
import poris.fruitlight.dto.OrderParam;
import poris.fruitlight.dto.ReceiptHistory;
import poris.fruitlight.dto.ShippingAddressParam;
import poris.fruitlight.dto.Shopper;

public interface OrderService {
	
	/**
	 * 
	 * @author 고재승
	 * @since 2023.08.16
	 * @param shopper
	 * @return
	 */
	public ShippingAddressParam getShippingAddressInfo(Shopper shopper);
	
	/**
	 * 결제 시 ORDER_HISTORY에 데이터 추가
	 * @author 이은지
	 * @param orderHistory(주문내역 DTO)
	 */
	public int addOrder(OrderHistory orderHistory);
	
	/**
	 * 결제 시 RECEIPT_HISTORY에 데이터 추가
	 * @author 이은지
	 * @param receiptHistory(영수증 내역 DTO)
	 */
	public void addReceipt(ReceiptHistory receiptHistory);
	
	/**
	 * 결제 시 사용한 쿠폰을 사용완료로 변경
	 * @author 이은지
	 * @param coupon(쿠폰 DTO)
	 */
	public void useCoupon(Coupon coupon);
	
	/**
	 * 결제 후 구매한 상품수량만큼 상품의 재고 변경
	 * @author 이은지
	 * @param orderParam(결제 관련 정보 DTO)
	 */
	public void changeProductStock(OrderParam orderParam);
}
