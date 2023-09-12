package poris.fruitlight.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.OrderHistoryOrderList;
import poris.fruitlight.dto.OrderSearchParam;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.MyPageChangeInfoService;
import poris.fruitlight.service.MyPageOrderedService;
import poris.fruitlight.util.AlertScript;

@Slf4j
@Controller
public class MyPageOrderHistoryController {
	
	@Resource
	public MyPageOrderedService myPageOrderedService;
	
	
	/**
	 * @author 김진성
	 * @param searchKeyword - 마이페이지(내주문 내역)의 주문내역을 필터링 하기 위한 검색어
	 * @param pageNo - 주문 내역의 페이지 번호
	 * @param response
	 * @param session
	 * @param model - 주문 내역 검색어, 주문 된 상품 리스트
	 * @return 로그인된 회원의 마이페이지(내주문 내역)
	 */
	@RequestMapping("/mypageOrdered")
	public String myPageOrdered(
			@RequestParam(name = "searcho", required = false) String searchKeyword,
			@RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
			HttpServletResponse response,
			HttpSession session,
			Model model) {
		
		List<OrderHistoryOrderList> mypageOrdered;
	    OrderSearchParam orderSearch = new OrderSearchParam();
	    Shopper shopper = (Shopper) session.getAttribute("ShopperInfo");
	    if(shopper == null) {
	    	try {
				AlertScript.alertAndMovePage(response, "로그인을 해주세요", "/fruitlight/login");
			} catch (IOException e) {
				return "redirect:/main";
			}
	    } else {
	    	if (searchKeyword != null) {
	    		orderSearch.setShopperNo(shopper.getShopperNo());
	    		orderSearch.setSearchKeyword(searchKeyword);
	    		
	    		
	    		mypageOrdered = myPageOrderedService.searchOrderList(orderSearch);
	    		for (OrderHistoryOrderList mpo : mypageOrdered) {
	    			mpo.setBase64Img(Base64.getEncoder().encodeToString(mpo.getMEDIA_DATA()));
	    		}
	    	} else {
	    		int totalOrderHistory = myPageOrderedService.SelectTotalOrderHistory(shopper.getShopperNo());
	    		Pager OrderHistoryPager = new Pager(5, 5, totalOrderHistory, pageNo);
	    		
	    		
	    		mypageOrdered = myPageOrderedService.getList(OrderHistoryPager, shopper.getShopperNo());
	    		for (OrderHistoryOrderList mpo : mypageOrdered) {
	    			mpo.setBase64Img(Base64.getEncoder().encodeToString(mpo.getMEDIA_DATA()));
	    		}
	    		model.addAttribute("OrderHistoryPager", OrderHistoryPager);
	    	}
	    	
	    	model.addAttribute("mypageOrdered", mypageOrdered);
	    	model.addAttribute("searchKeyword", searchKeyword);
	    }


	    return "mypageOrdered";
	}
}
