package poris.fruitlight.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.ShopperService;
import poris.fruitlight.util.AlertScript;

@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	private ShopperService shopperService;
	
	
	
	
	/**
	 * 로그인 페이지 접속 메소드
	 * @author 고재승
	 * @return 로그인 페이지 이동
	 */
	@RequestMapping("/login")
	public String login(HttpSession session) {
		
		if(session.getAttribute("ShopperInfo") != null) {
			return "redirect:/main";
		}
		
		return "login";
	}
	
	/**
	 * 로그인 요청 처리 메소드
	 * @param loginParam - (유저ID, 유저PW, 자동로그인 여부)
	 * @param response - 쿠키를 응답으로 전송하기 위해 사용
	 * @param session - 로그인 성공 시 유저 정보를 브라우저 내 공유하기 위해 사용
	 * @param model - 로그인 실패 시, 에러 사유 메세지와 유저가 입력한 값을 전달하기 위해 사용
	 * @return 메인 페이지로 리다이렉트
	 * @throws IOException 
	 */
	@PostMapping("/login/askLogin")
	public String askLogin(Shopper shopper, HttpServletResponse response , HttpSession session, Model model) throws IOException {
		Shopper dbShopper = null;
		
		if( (shopper.getShopperId() != null) && (shopper.getShopperPw() != null) ) {
			// Stpe1. JSP에서 유저 로그인 값을 얻고, userID 정보로 DB에서 Select로 회원 유무 확인
			dbShopper = shopperService.getShopperById(shopper);
		} else {
			return "redirect:/login";
		}
		
		// Step3. 회원 정보가 없으면 JSP에 에러 콘솔 출력 (에러 처리)
		if(dbShopper == null) {
			AlertScript.alertAndBackPage(response, "회원정보를 찾을 수 없습니다.");
			session.setAttribute("Shopper", shopper);
			return "redirect:/login";
		}
		
		// Step4. 비활성화 회원이면 JSP에 예외 처리 콘솔 출력
		if(dbShopper.getActivate().equals("N")) {
			AlertScript.alertAndBackPage(response, "탈퇴 회원입니다. 다시 로그인해주세요");
		} else {
			
			// Step5. 자동 로그인 체크 여부 확인
			shopper.setShopperNo(dbShopper.getShopperNo());
			if(shopper.getShopperAutoLogin() != null) {
				shopperService.setShopperAutoLogin(shopper);
			} else {
				shopper.setShopperAutoLogin("0");
				shopperService.setShopperAutoLogin(shopper);
			}
			
			// Step6. 세션에 Shopper 정보 저장
			session.setAttribute("ShopperInfo", dbShopper);
			session.removeAttribute("Shopper");
			
			// Step7. 자동로그인이 체크되었다면, 클라이언트에게 쿠키 생성
			if(shopper.getShopperAutoLogin().equals("0")) {
				
				Cookie cookie = new Cookie("ShopperID", Integer.toString(dbShopper.getShopperNo()));
				cookie.setPath("/");
				cookie.setMaxAge(86400);
				cookie.setHttpOnly(true);
				cookie.setSecure(false);
				
				response.addCookie(cookie);
			}
			// Step8. 메인페이지로 리다이렉트
			return "redirect:/";
		}
		return "/main";
	}
	
	
	/**
	 * 아이디 찾기 페이지 이동
	 * @author 고재승
	 * @return 아이디 찾기 페이지
	 */
	@GetMapping("/login/findEmail")
	public String findEmail() {
		
		return "findEmail";
	}
	
	/**
	 * 회원의 아이디 조회 및 응답
	 * @param shopper - 회원 정보
	 * @param response - 회원 아이디
	 */
	@PostMapping("/login/findEmail/submit")
	@ResponseBody
	public void findEmailSubmit(Shopper shopper, HttpServletResponse response) {
		
		try {
			String resultEmail = shopperService.getSearchShopperId(shopper);
		
			AlertScript.alertAndMovePage(response, "아이디는 " + resultEmail + " 입니다.", "/fruitlight/login");
		} catch (IOException e) {}
	}
	
	
	/**
	 * 패스워드 찾기 페이지 이동
	 * @author 고재승
	 * @return 패스워드 찾기 페이지
	 */
	@GetMapping("/login/findPassword")
	public String findPW() {
		
		
		return "findPassword";
	}
	
	
	/**
	 * 회원의 패스워드 조회 및 응답
	 * @param shopper - 회원 정보
	 * @param response - 회원 패스워드
	 */
	@PostMapping("/login/findPassword/submit")
	@ResponseBody
	public void findPasswordSubmit(Shopper shopper, HttpServletResponse response) {
		
		try {
			String resultPassword = shopperService.getSearchShopperPassword(shopper);
		
			AlertScript.alertAndMovePage(response, "비밀번호는 " + resultPassword + " 입니다.", "/fruitlight/login");
		} catch (IOException e) {}
	}
}
