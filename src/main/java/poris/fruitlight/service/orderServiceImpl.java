package poris.fruitlight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poris.fruitlight.dao.OrderHistoryDao;
import poris.fruitlight.dao.ShippingAddressDao;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.OrderHistory;
import poris.fruitlight.dto.OrderParam;
import poris.fruitlight.dto.ReceiptHistory;
import poris.fruitlight.dto.ShippingAddressParam;
import poris.fruitlight.dto.Shopper;

@Service
public class orderServiceImpl implements orderService{
	
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
	public void addOrder(OrderHistory orderHistory) {
		orderHistoryDao.insertOrderHistory(orderHistory);
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
