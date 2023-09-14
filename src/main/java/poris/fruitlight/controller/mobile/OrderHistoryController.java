package poris.fruitlight.controller.mobile;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.MorderHistory;
import poris.fruitlight.service.MyPageOrderedService;

@RestController
@Slf4j
public class OrderHistoryController {
	
	@Resource
	public MyPageOrderedService myPageOrderedService;
	
	@GetMapping(value="/getOrderedList", produces="application/json; charset=UTF-8")
	public List<MorderHistory> getOrderList() {
		int shopperNo = 1;
		List<MorderHistory> orderHistoryList = myPageOrderedService.getOrderHistory(shopperNo);
		
		return orderHistoryList;
		
	}
	

}
