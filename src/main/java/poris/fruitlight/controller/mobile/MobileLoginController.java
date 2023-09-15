package poris.fruitlight.controller.mobile;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.ShopperService;

@Slf4j
@RestController
public class MobileLoginController {
	
	@Autowired
	private ShopperService shopperService;
	
	@RequestMapping(value="/shopper/tryLogin", produces="application/json; charset=UTF-8")
	public String tryLogin(Shopper shopper) throws IOException {
		Shopper dbShopper = null;
		log.info("id: " + shopper.getShopperId() + "    pw: " + shopper.getShopperPw());
		JSONObject jsonObject = new JSONObject();
		if( (shopper.getShopperId() != null) && (shopper.getShopperPw() != null) ) {
			dbShopper = shopperService.getShopperById(shopper);
			if (dbShopper == null) {
				jsonObject.put("result", "fail_shopper_id");
			} else if (dbShopper.getActivate().equals("N")) {
				jsonObject.put("result", "fail_enabled");
			} else {
				jsonObject.put("result", "success");
				jsonObject.put("shopperId", shopper.getShopperId());
				jsonObject.put("shopperPw", shopper.getShopperPw());
			}
		}
		
		return jsonObject.toString();
	}
	
	
	
}
