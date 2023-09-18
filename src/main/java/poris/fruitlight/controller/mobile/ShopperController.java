package poris.fruitlight.controller.mobile;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.ShopperService;

@Slf4j
@RestController
public class ShopperController {

	@Resource
	public ShopperService shopperService;
	
	
	@GetMapping(value="/getShopper", produces="application/json; charset=UTF-8")
	public Shopper getShopper(String shopperId) {
		
		Shopper shopper = shopperService.getShopperByShopperId(shopperId);
		return shopper;
		
	}
}
