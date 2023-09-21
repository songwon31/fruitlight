package poris.fruitlight.controller;

import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.ProductList;
import poris.fruitlight.service.MainService;

@Slf4j
@Controller
public class MainPageController {

   @Resource
   private MainService mainService;
   
   /**
    * @author 김진성
    * @param session
    * @return 메인 페이지
    */
   @RequestMapping("/")
   public String main(HttpSession session) {
	   
	  // Step1. 초기 화면 init 데이터 LOAD FROM DB
      List<ProductList> mainlists = mainService.getMainList();
      
      List<ProductList> todaylists = mainService.getTodayList();
      for(ProductList today : todaylists) {
    	  today.setBase64Img(Base64.getEncoder().encodeToString(today.getMEDIA_DATA()));
      }
      
      /* 
       * [이미지 데이터 적용하는법]
       * Step1. BLOB 데이터가 있는 DTO 객체 리스트를 DB로부터 가져온다.
       * Step2-1. 반복문을 통해, 각 DTO 객체의 BLOB(byte[])를 GETTER로 가져온다.
       * Step2-2. BLOB(byte[])를 Base64 형식의 String으로 변환 후, SETTER으로 Base64Img 필드에 저장한다.
       * Step3. JSP에 사용할 수 있도록 Session에 DTO객체를 설정(저장)한다.
       * Step4. JSP 내 img태그 src 속성에  DTO 필드, MEDIA_DATA, base64Img -> JSTL을 적용한다.
       * <img class="productImage" src="data:${todaylist.MEDIA_DATA};base64, ${todaylist.base64Img}"/>
       */
      
      List<ProductList> sellerlists = mainService.getSellerList();
      List<ProductList> catemainlists = mainService.getCateMainList();
      List<ProductList> catesublists = mainService.getCateSubList();
      
      // Step2. JSP 초기 화면 init 데이터
      session.setAttribute("mainlists", mainlists);
      session.setAttribute("todaylists", todaylists);
      session.setAttribute("sellerlists", sellerlists);
      session.setAttribute("catemainlists", catemainlists);
      session.setAttribute("catesublists", catesublists);
      
      // Step3. 각종 배너 사진 출력 기능
      List<ProductList> mainBannerlist = mainService.getMainList();
      for(ProductList mainBanner : mainBannerlist) {
    	  mainBanner.setBase64Img(Base64.getEncoder().encodeToString(mainBanner.getMEDIA_DATA()));
      }
      session.setAttribute("productlist", mainBannerlist);
      
      List<ProductList> mainTodaylist = mainService.getTodayList();
      for(ProductList mainToday : mainTodaylist) {
    	  mainToday.setBase64Img(Base64.getEncoder().encodeToString(mainToday.getMEDIA_DATA()));
      }
      session.setAttribute("todaylists", mainTodaylist);
      
      List<ProductList>	mainSellerlist = mainService.getSellerList();
      for(ProductList mainSeller : mainSellerlist) {
    	  mainSeller.setBase64Img(Base64.getEncoder().encodeToString(mainSeller.getMEDIA_DATA()));
      }
      session.setAttribute("sellerlists", mainSellerlist);
      
      List<ProductList>	cateMainlist = mainService.getCateMainList();
      for(ProductList cateMain : cateMainlist) {
    	  cateMain.setBase64Img(Base64.getEncoder().encodeToString(cateMain.getMEDIA_DATA()));
      }
      session.setAttribute("catemainlists", cateMainlist);
      
      List<ProductList>	cateSublist = mainService.getCateSubList();
      for(ProductList cateSub : cateSublist) {
    	  cateSub.setBase64Img(Base64.getEncoder().encodeToString(cateSub.getMEDIA_DATA()));
      }
      session.setAttribute("catesublists", cateSublist);
      
      return "/WEB-INF/views/main.jsp";
   }
   
   @RequestMapping("/searchAddress")
   public String searchAddress() {
	   
	   return "/WEB-INF/views/daum_address.jsp";
   }

   /**
    * @author 김진성
    * @return 메인 페이지
    */
   //로고 클릭 시, 메인 페이지로 이동
	@RequestMapping("/main")
	public String moveMainPage() {
		return "redirect:/";
	}
	
	/**
	 * @author 고재승
	 * @since 2023.08.13
	 * @param pid - 제품 고유번호
	 * @return - 요청 게시글 번호
	 */
	@RequestMapping("/main/SelectDetailView")
	public String moveDetailViewPage(int pid, HttpSession session) {
		// Step1. PRODUCT_ID를 기준으로 선택한 게시판 번호를 조회한다.
		int boardNo = mainService.getSelectBoardNo(pid);
		// Step2. Session에 게시판 번호를 저장한다.
		session.setAttribute("BoardNo", boardNo);
		// Step3. 페이지는 DetailView로 이동하되, Detail View에서 게시판 번호를 Session 객체로 조회해야한다.
		
		return "redirect:/detailView";
	}
	
	
	/**
	 * 
	 * @author 김진성
	 * @since 2023.08.14
	 * 
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("ShopperInfo");
		return "redirect:/";
	}
	
	
}