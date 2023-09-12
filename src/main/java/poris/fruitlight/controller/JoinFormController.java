package poris.fruitlight.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.JoinParam;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.ShopperService;
import poris.fruitlight.util.AlertScript;

@Slf4j
@Controller
public class JoinFormController {
	
	@Autowired
	private ShopperService shopperService;
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	/**
	 * @author 고재승
	 * @since 2023.08.14
	 * @param joinParam - (유저ID, 유저PW, 유저PW 재입력, 유저 이름, 유저 연락처, 필수 동의 여부)
	 * @param response - alert 메세지 응답
	 * @throws IOException - response 응답 실패 시 예외처리
	 */
	@PostMapping("/joinForm/askJoinForm")
	public void askJoinForm(JoinParam joinParam, HttpServletResponse response) throws IOException {
		// Step1. 회원가입 입력 데이터 확인 (유효성 검사) - 향후 인터셉터로 기능 구현
		log.info(joinParam.toString());
		
		if(joinParam.getUserId().equals("")) {
			AlertScript.alertAndBackPage(response, "ID를 확인해주세요");
		} else if (joinParam.getUserPassword().equals("")) {
			AlertScript.alertAndBackPage(response, "PW를 확인해주세요");
		} else if (joinParam.getUserPasswordCheck().equals("")) {
			AlertScript.alertAndBackPage(response, "PW를 한번 더확인해주세요");
		} else if (joinParam.getUserName().equals("")) {
			AlertScript.alertAndBackPage(response, "이름을 확인해주세요");
		} else if (joinParam.getUserTel().equals("")) {
			AlertScript.alertAndBackPage(response, "연락처를 확인해주세요");
		} else if (joinParam.getAcceptAgreement() == null) {
			AlertScript.alertAndBackPage(response, "필수 항목은 반드시 동의되어야 합니다.");
		}
		
		
		// Step2. DB에 동일 회원 유무 검사
		Shopper shopper = new Shopper();
		shopper.setShopperId(joinParam.getUserId());
		shopper.setShopperPw(joinParam.getUserPassword());
		shopper.setShopperName(joinParam.getUserName());
		shopper.setShopperTel(joinParam.getUserTel());
		
		boolean resultIsMember = shopperService.isMember(shopper);
		log.info("resultIsMember : " + resultIsMember);
		
		if(resultIsMember) {
			// Step3. 중복 회원 있으면 에러 반환
			AlertScript.alertAndBackPage(response, "중복된 ID입니다.");
		} else {
			// Step4. 중복 회원 없으면 DB에 저장 후 메인페이지로 이동
			shopperService.insertMember(shopper);
			AlertScript.alertAndMovePage(response, "회원가입이 완료되었습니다.", "/fruitlight/");
		}
	}
}
