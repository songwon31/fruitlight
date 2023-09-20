package poris.fruitlight.controller.mobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.OrderHistory;
import poris.fruitlight.dto.OrderRequestBody;
import poris.fruitlight.dto.ReceiptHistory;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.CartService;
import poris.fruitlight.service.OrderService;
import poris.fruitlight.service.ShopperService;

@Slf4j
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ShopperService shopperService;
	
	@Autowired
	private CartService cartProductService;
	
	private Shopper loginShopper;
	
	
	@PostMapping(value="/addOrder", produces="application/json; charset=UTF-8")
	public void addOrder(@RequestBody OrderRequestBody orderRequestBody) throws Exception {
	
		//  =============   ORDER_HISTORY(주문내역) 데이터  ====================
		//OrderHistory DTO 객체 생성
		//유저 번호
		//DB에 저장
		
		List<Cart> cartList = orderRequestBody.getCartList();
		List<Coupon> couponList = orderRequestBody.getCouponList();
		OrderHistory order  = orderRequestBody.getOrder();
		List<ReceiptHistory> receiptHistory= orderRequestBody.getReceiptHistoryList();
		
		orderService.addOrder(order);
		
		for(ReceiptHistory receipt : receiptHistory) {
		
			orderService.addReceipt(receipt);
		}
		
		for(Cart cart : cartList) {
			
			cartProductService.deleteProduct(cart);
		}

		for(Coupon coupon : couponList) {
			
			orderService.useCoupon(coupon);
		}
		
	}

}
