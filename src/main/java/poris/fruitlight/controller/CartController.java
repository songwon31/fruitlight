package poris.fruitlight.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.CartProduct;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.OrderParam;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.CartService;
import poris.fruitlight.util.AlertScript;

/**
 * 
 * @author 이은지
 *
 */
@Controller
public class CartController {
	@Resource
	private CartService cartProductService;
	
	private Shopper loginShopper;
	
	/**
	 * 장바구니 페이지 초기화면 출력
	 * @param model
	 * @return 장바구니(cart) 페이지
	 */
	@RequestMapping("/cart")
	public String cart(HttpServletResponse response, HttpSession session, Model model) {
		// Step1. Session에 있는 로그인한 회원 정보 얻기
		loginShopper = (Shopper) session.getAttribute("ShopperInfo");
		if(loginShopper == null) {
			try {
				AlertScript.alertAndMovePage(response, "로그인을 해주세요", "/fruitlight/login");
			} catch (IOException e) {
				return "redirect:/main";
			}
		} else {
			// Step2. 로그인한 회원의 장바구니 상품 및 쿠폰 데이터 얻기
			List<CartProduct> listProduct = cartProductService.getCartProduct(loginShopper.getShopperNo());
			List<Coupon> listCoupon = cartProductService.getCoupon(loginShopper.getShopperNo());
			
			// Step2-1. 장바구니 상품 이미지 변환
			for(CartProduct cartProduct : listProduct) {
				cartProduct.setBase64Img(Base64.getEncoder().encodeToString(cartProduct.getMEDIA_DATA()));
		    }
			
			// Step2-2. 장바구니 정보를 JSP에 Model으로 전달
			model.addAttribute("listProduct", listProduct);
			model.addAttribute("listCoupon", listCoupon);
		}
		return "cart";
	}
	
	/**
	 * 장바구니 상품 개별 삭제
	 * @param pid(삭제할 상품의 no)
	 * @return 리다이렉트로 장바구니(cart) 페이지
	 */
	//개별삭제
	@RequestMapping("/cart/delete")
	public String delete(int pno) {
		Cart cart = new Cart();
		cart.setSHOPPER_NO(loginShopper.getShopperNo());
		cart.setPRODUCT_NO(pno);
		
		cartProductService.deleteProduct(cart);
		return "redirect:/cart";
	}
	
	/**
	 * 장바구니 상품 일괄 삭제
	 * @param request(ajax로 삭제할 상품의 no 리스트)
	 * @return 리다이렉트로 장바구니(cart) 페이지
	 */
	//선택삭제 및 전체삭제
	@RequestMapping("/cart/deleteChecked")
	public String deleteChecked(@RequestParam List<Integer> pnos) {
		for(Integer pno : pnos) {
			Cart cart = new Cart();
			cart.setSHOPPER_NO(loginShopper.getShopperNo());
			cart.setPRODUCT_NO(pno);
			
			cartProductService.deleteProduct(cart);
		}
		return "redirect:/cart";
	}

	/**
	 * 장바구니 상품 수량 변경
	 * @param cartProduct(수량 변경할 상품 객체) 
	 * @param model
	 * @return 장바구니(cart) 페이지
	 */
	//수량변경
	@RequestMapping("/cart/changeStock")
	public void changeStock(int pno, int stock) {
		Cart cart = new Cart();
		cart.setSHOPPER_NO(loginShopper.getShopperNo());
		cart.setPRODUCT_NO(pno);
		cart.setCART_PRODUCT_STOCK(stock);
		
		cartProductService.changeStock(cart);
	}

	/**
	 * 결제하기 위해 필요한 데이터(장바구니 상품 정보, 쿠폰 정보, 주문금액 정보) 결제 controller에 전달
	 * @param request(ajax로 삭제할 상품의 id 리스트)
	 * @return 리다이렉트로 장바구니(cart) 페이지
	 */
	//구매
	@GetMapping("/cart/buyFromCart")
	public String buyFromCart(
			HttpSession session,
			@RequestParam List<Integer> pnos, 
			@RequestParam List<String> pnames,
			@RequestParam List<String> options,
			@RequestParam List<Integer> stocks,
			@RequestParam List<Integer> prices,
			@RequestParam int totalPrice,
			@RequestParam int discountPrice,
			@RequestParam int shippingPrice,
			@RequestParam int orderPrice,
			@RequestParam List<Integer> cnos) {
		
		List<OrderParam> orderParamList = new ArrayList<>();
		
		for(int i=0; i<pnos.size(); i++) {
			OrderParam oderParam = new OrderParam();
			oderParam.setProductNo(pnos.get(i));
			oderParam.setProductName(pnames.get(i));
			oderParam.setProductOption(options.get(i));
			oderParam.setProductStock(stocks.get(i));
			oderParam.setProductPrice(prices.get(i));
			
			orderParamList.add(oderParam);
		}
		
		session.setAttribute("orderParamList", orderParamList);
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("discountPrice", discountPrice);
		session.setAttribute("shippingPrice", shippingPrice);
		session.setAttribute("orderPrice", orderPrice);
		session.setAttribute("couponList", cnos);
		session.setAttribute("from", "cart");
		
		return "redirect:/order";
	}
	
	/**
	 * 장바구니 상품 클릭 시 해당 게시글로 이동
	 * @param pno(이동할 상품 번호)
	 * @param session
	 * @return 리다이렉트로 상품 상세(DetailView) 페이지
	 */
	@GetMapping("/cart/goToDetailView") 
	public String goToDetailView(int pno, HttpSession session) {
		int bno = cartProductService.getBoardNo(pno);
		session.setAttribute("BoardNo", bno);
		return "redirect:/detailView";
	}
}
