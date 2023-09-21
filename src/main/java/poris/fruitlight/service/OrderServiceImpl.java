package poris.fruitlight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dao.OrderHistoryDao;
import poris.fruitlight.dao.ShippingAddressDao;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.OrderHistory;
import poris.fruitlight.dto.OrderParam;
import poris.fruitlight.dto.ReceiptHistory;
import poris.fruitlight.dto.ShippingAddressParam;
import poris.fruitlight.dto.Shopper;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	ShippingAddressDao shippingAddressDao;
	
	@Autowired
	OrderHistoryDao orderHistoryDao;
	
	
	@Override
	public ShippingAddressParam getShippingAddressInfo(Shopper shopper) {
		return shippingAddressDao.selectShippingAddressById(shopper);
	}
	
	//주문내역 추가
	@Override
	public int addOrder(OrderHistory orderHistory) {
		orderHistoryDao.insertOrderHistory(orderHistory);
		int orderNo = orderHistoryDao.selectOrderNo();
		log.info(orderNo+"나오더넘버1");
		return orderNo;
	}
	
	//영수증내역(주문상세내역) 추가
	@Override
	public void addReceipt(ReceiptHistory receiptHistory) {
		orderHistoryDao.insertReceiptHistory(receiptHistory);
		
	}
	
	//쿠폰 사용
	@Override
	public void useCoupon(Coupon coupon) {
		orderHistoryDao.updateCouponUsed(coupon);
	}

	//상품 재고 변경
	@Override
	public void changeProductStock(OrderParam orderParam) {
		orderHistoryDao.updateProductStock(orderParam);
	}
}
