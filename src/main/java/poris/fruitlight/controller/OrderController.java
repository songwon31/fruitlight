package poris.fruitlight.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.OrderHistory;
import poris.fruitlight.dto.OrderParam;
import poris.fruitlight.dto.ReceiptHistory;
import poris.fruitlight.dto.ShippingAddressParam;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.CartService;
import poris.fruitlight.service.ShopperService;
import poris.fruitlight.service.OrderService;
import poris.fruitlight.util.AlertScript;

@Slf4j
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ShopperService shopperService;
	
	@Autowired
	private CartService cartProductService;
	
	private Shopper loginShopper;
	
	/**
	 * 
	 * @param response - alert 반환
	 * @param session - 회원 정보
	 * @param model - 회원정보, 배송지 정보 DTO
	 * @return
	 */
	@RequestMapping("/order")
	public String DetailViewPage(HttpServletResponse response,HttpSession session, Model model) {
		// Step1. 로그인 세션 정보 Load
		if(session.getAttribute("ShopperInfo") == null) {
			try {
				AlertScript.alertAndMovePage(response, "로그인을 해주세요", "/fruitlight/login");
			} catch (IOException e) {
				return "redirect:/main";
			}
		} else {
			loginShopper = (Shopper) session.getAttribute("ShopperInfo");
			
			// Step2.구매자 정보, 도착지 정보를 DB에서 가져오기
			ShippingAddressParam shipAddress = orderService.getShippingAddressInfo(loginShopper);
			
			// finish. 객체 설정 및 결제 페이지로 전송
			model.addAttribute("shopperInfo", loginShopper);
			model.addAttribute("shipAddress", shipAddress);
		}
		
		return "order";
	}
	
	/**
	 * 구매하기 클릭시 주문 관련 데이터 db에 저장 및 업데이트
	 * @author 이은지
	 * @param session
	 * @param addressNo(주문번호)
	 * @param payType(결제유형 - 계좌이체, 신용/체크카드, 휴대폰, 무통장입금)
	 * @param payTypeBank(계좌이체 시 은행먕)
	 * @param payTypeCard(신용/체크키드 시 카드사명)
	 * @param payTypeTelecom(휴대폰 시 통신사명)
	 * @param payTypeDepositBank(무통장입금 시 은행명)
	 * @param receiptPurpose(현금영수증 발행목적 - 소득공제, 지출증빙)
	 * @param cashReceiptRegisterType(현금영수증 종류 - 휴대폰번호, 현금영수증카드)
	 * @param cashReceiptRequestNo(현금영수증 번호)
	 * @return 내 주문목록(mypageOrdered) 페이지
	 */
	@RequestMapping("/order/buyOrder")
	public String buyOrder(
			HttpSession session,
			int addressNo,
			String payType,
			String payTypeBank,
			String payTypeCard,
			String payTypeTelecom, 
			String payTypeDepositBank,
			String receiptPurpose,
			String cashReceiptRegisterType,
			String cashReceiptRequestNo) {
		
		//  =============   장바구니 및 바로구매로부터 받은 데이터  ====================
		//상품 목록과 결제 정보
		List<OrderParam> orderParamList = (List<OrderParam>) session.getAttribute("orderParamList");
		int totalPrice = (int) session.getAttribute("totalPrice");			//총 상품가격
		int discountPrice = (int) session.getAttribute("discountPrice");	//총 할인가격
		int shippingPrice = (int) session.getAttribute("shippingPrice");	//총 배송비
		int orderPrice = (int) session.getAttribute("orderPrice");			//총 주문가격
		
		//  =============   ORDER_HISTORY(주문내역) 데이터  ====================
		//OrderHistory DTO 객체 생성
		OrderHistory order = new OrderHistory();
		//유저 번호
		order.setSHOPPER_NO(loginShopper.getShopperNo());
		//배송지 번호
		order.setADDRESS_NO(addressNo);
		//결제 날짜
		order.setORDER_DATE(new Date());
		//총 상품가격
		order.setTOTAL_PRICE(totalPrice);
		//할인금액
		order.setDISCOUNT_PRICE(discountPrice);
		//배송비
		order.setSHIPPING_PRICE(shippingPrice);
		//결제금액
		order.setPAYMENT_PRICE(orderPrice);
		
		//결제 유형(계좌이체, 신용/체크카드, 휴대폰, 무통장입금(가상계좌))
		String paymentType = "";
		switch(payType) {
			case "ROCKET_BANK": {
				paymentType = "계좌이체";
				paymentType += " / " + payTypeBank;
				break;
			}
			case "ROCKET_CARD": {
				paymentType = "신용/체크카드"; 
				paymentType += " / " + payTypeCard;
				break;
			}
			case "PHONE": {
				paymentType = "휴대폰"; 
				paymentType += " / " + payTypeTelecom;
				break;
			}
			case "VIRTUALACCOUNT": {
				paymentType = "무통장입금(가상계좌)";
				paymentType += " / " + payTypeDepositBank;
				break;
			}
		}
		order.setPAYMENT_TYPE(paymentType);
		
		//현금영수증 발행목적(소득공제, 지출증빙)
		String cashReciptPurpose = "";
		if(receiptPurpose.equals("incomeDeduction")) {
			cashReciptPurpose = "소득공제";
		} else if(receiptPurpose.equals("proofExpenditure")) {
			cashReciptPurpose = "지출증빙";
		}
		order.setCASH_RECEIPT_PURPOSE(cashReciptPurpose);
		
		//현금영수증 종류(휴대폰번호, 현금영수증카드)
		String cashReceiptType = "";
		if(cashReceiptRegisterType.equals("PHONE_NUMBER")) {
			cashReceiptType = "휴대폰번호";
		} else if(cashReceiptRegisterType.equals("CASH_RECEIPT_CARD_NUMBER")) {
			cashReceiptType = "현금영수증카드";
		}
		order.setCASH_RECEIPT_TYPE(cashReceiptType);
		
		//현금영수증 번호
		order.setCASH_RECEIPT_NO(cashReceiptRequestNo);
		
		//DB에 저장
		orderService.addOrder(order);
		
		//  =============   RECEIPT_HISTORY(주문 상세 내역) 데이터  ====================
		for(OrderParam orderParam : orderParamList) {
			//ReceiptHistory DTO 객체 생성
			ReceiptHistory receipt = new ReceiptHistory();
			//상품번호
			receipt.setPRODUCT_NO(orderParam.getProductNo());
			//상품가격
			receipt.setPRICE(orderParam.getProductPrice());
			//상품수량
			receipt.setSTOCK(orderParam.getProductStock());
			//DB에 저장
			orderService.addReceipt(receipt);
		}
		
		//  =============   CART(장바구니) 데이터  ====================
		//장바구니에서 구매했을 경우 장바구니에 담긴 상품 제거
		if((String) session.getAttribute("from") == "cart") {
			for(OrderParam orderParam : orderParamList) {
				//장바구니에서 삭제하기 위해 Cart DTO 객체 생성
				Cart cart = new Cart();
				cart.setSHOPPER_NO(loginShopper.getShopperNo());
				cart.setPRODUCT_NO(orderParam.getProductNo());
				//DB에서 제거
				cartProductService.deleteProduct(cart);
			}
		}
		
		//  =============   COUPON(쿠폰) 데이터  ====================
		//사용한 쿠폰이 있을 경우 사용완료로 변경
		List<Integer> couponList = (List<Integer>) session.getAttribute("couponList");
		if(couponList != null) {
			for(int couponNo : couponList) {
				//사용완료로 변경하기 위해 Coupon DTO 객체 생성
				Coupon coupon = new Coupon();
				coupon.setCOUPON_NO(couponNo);
				coupon.setSHOPPER_NO(loginShopper.getShopperNo());
				//DB에 업데이트
				orderService.useCoupon(coupon);
			}
		}
		
		//  =============   PRODUCT(상품) 데이터  ====================
		//구매한 상품의 구매수량만큼 재고 업데이트
		for(OrderParam orderParam : orderParamList) {
			orderService.changeProductStock(orderParam);
		}
		
		return "redirect:/mypageOrdered";
	}
	
}
