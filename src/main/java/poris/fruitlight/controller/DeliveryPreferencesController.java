package poris.fruitlight.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.DeliveryPreferencesParam;

@Slf4j
@Controller
public class DeliveryPreferencesController {
	
	/**
	 * @author 고재승
	 * @return 배송 요청사항 페이지 이동
	 */
	@RequestMapping("/deliveryPreferences")
	public String DeliveryPreferencesPage() {
		
		return "deliveryPreferences";
	}
}
