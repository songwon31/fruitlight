package poris.fruitlight.controller.mobile;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.AddressBook;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.Order;
import poris.fruitlight.dto.OrderHistory;
import poris.fruitlight.dto.ReceiptHistory;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.AddressBookService;
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
	
	@Autowired
	private AddressBookService addressBookService;
	
	private Shopper loginShopper;
	
	private int order_no;
	
	@GetMapping(value="/defaultAddress", produces="application/json; charset=UTF-8")
	public AddressBook defaultAddress(int shopper_no) {
		AddressBook defaultAddress = addressBookService.getAddress(shopper_no);
		log.info(defaultAddress.toString()+"나디폴트어드레스");
		
		return defaultAddress;
		
	}
	
	
	@PostMapping(value="/addOrder1", produces="application/json; charset=UTF-8")
	public void addOrder1(@RequestBody Order order) {
	
		log.info("데이터 잘 넘어오고있니?"+order.toString());
		
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setSHOPPER_NO(order.getSHOPPER_NO());
		orderHistory.setADDRESS_NO(order.getADDRESS_NO());
		orderHistory.setTOTAL_PRICE(order.getTOTAL_PRICE());
		orderHistory.setDISCOUNT_PRICE(order.getDISCOUNT_PRICE());
		orderHistory.setSHIPPING_PRICE(order.getSHIPPING_PRICE());
		orderHistory.setPAYMENT_PRICE(order.getPAYMENT_PRICE());
		orderHistory.setPAYMENT_TYPE(order.getPAYMENT_TYPE());
		orderHistory.setCASH_RECEIPT_PURPOSE(order.getCASH_RECEIPT_PURPOSE());
		orderHistory.setCASH_RECEIPT_NO(order.getCASH_RECEIPT_NO());
		orderHistory.setCASH_RECEIPT_TYPE(order.getCASH_RECEIPT_TYPE());
		Date currentDate = new Date();
		orderHistory.setORDER_DATE(currentDate);
		order_no = orderService.addOrder(orderHistory);
		
		
	}
	
	@PostMapping(value="/addOrder2", produces="application/json; charset=UTF-8")
	public void addOrder2(@RequestBody List<Coupon> couponList) throws Exception {
		log.info("데이터 잘 넘어오고있니?"+couponList.toString());
		
		for(Coupon coupon : couponList) {
			
			orderService.useCoupon(coupon);
		}
		
	}
	
	@PostMapping(value="/addOrder3", produces="application/json; charset=UTF-8")
	public void addOrder3(@RequestBody List<ReceiptHistory> receiptHistory) throws Exception {
		
		
		log.info("데이터 잘 넘어오고있니?"+receiptHistory.toString());
		
		
		for(ReceiptHistory receipt : receiptHistory) {
			log.info(order_no+"주문번호왜못받아오는데?");
			receipt.setORDER_NO(order_no);
			orderService.addReceipt(receipt);
		}
	}
	
	@PostMapping(value="/addOrder4", produces="application/json; charset=UTF-8")
	public void addOrder4(@RequestBody List<Cart> cartList) throws Exception {

		log.info("데이터 잘 넘어오고있니?"+cartList.toString());
				
		for(Cart cart : cartList) {
			
			cartProductService.deleteProduct(cart);
		}
		
		
	}
	
	

}
