package poris.fruitlight.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Coupon;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.MyPageShopperInquiryService;
import poris.fruitlight.util.AlertScript;

/**
 * 
 * @author 이은지
 *
 */
@Slf4j
@Controller
public class MyPageShopperCouponController {
	@Resource
	private MyPageShopperInquiryService pageShopperInquiryService;
	
	/**
	 * 내 쿠폰함 초기화면 출력
	 * @param response
	 * @param session
	 * @param model
	 * @return 내 쿠폰함(mypageShopperCoupon) 페이지
	 */
	@RequestMapping("/mypageShopperCoupon")
	public String mypageShopperCoupon(HttpServletResponse response, HttpSession session, Model model) {
		// Step1. Session에 있는 로그인한 회원 정보 얻기
		Shopper loginShopper = (Shopper) session.getAttribute("ShopperInfo");
		if(loginShopper == null) {
			try {
				AlertScript.alertAndMovePage(response, "로그인을 해주세요", "/fruitlight/login");
			} catch (IOException e) {
				return "redirect:/main";
			}
		} else {
			// Step2. 로그인한 회원의 쿠폰 데이터 얻기
			List<Coupon> listCoupon = pageShopperInquiryService.getCoupon(loginShopper.getShopperNo());
			// Step2-2. 쿠폰 정보를 JSP에 Model으로 전달
			model.addAttribute("listCoupon", listCoupon);
		}
		return "mypageShopperCoupon";
	}
	
}
