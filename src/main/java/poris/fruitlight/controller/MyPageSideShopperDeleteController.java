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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.OrderHistoryOrderList;
import poris.fruitlight.dto.OrderSearchParam;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.MyPageChangeInfoService;
import poris.fruitlight.service.MyPageOrderedService;
import poris.fruitlight.service.ShopperService;
import poris.fruitlight.util.AlertScript;

@Slf4j
@Controller
public class MyPageSideShopperDeleteController {
	
	@Autowired
	ShopperService shopperService;
	
	@GetMapping("/mypageShopperDelete")
	public String mypageShopperDelete() {
		
		return "mypageShopperDelete";
	}
	
	@PostMapping("/mypageShopperDelete/deleteAgree")
	public void deleteAgree(String acceptAgreement, HttpServletResponse response, HttpSession session) throws IOException {
		Shopper shopper = (Shopper) session.getAttribute("ShopperInfo");
		
		if(acceptAgreement != null ) {
			shopperService.deleteShopper(shopper);
			session.removeAttribute("ShopperInfo");
			AlertScript.alertAndMovePage(response, "회원 탈퇴가 완료되었습니다", "/fruitlight");
		} else {
			AlertScript.alertAndBackPage(response, "필수 동의를 체크해주세요.");
		}
	}
}
