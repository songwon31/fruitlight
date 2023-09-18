package poris.fruitlight.controller.mobile;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.ProductInquiry;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.MyPageShopperInquiryService;

/**
 * 
 * @author 이은지
 *
 */
@Slf4j
@RestController
public class MyPageShopperInquiryController {

   @Resource
   private MyPageShopperInquiryService pageShopperInquiryService;

   @GetMapping(value="myPageShopperInquiry/getInquiryProductList", produces="application/json; charset=UTF-8")
   public List<String> getInquiryProductList(int sno) {
	   List<String> inquiryProductList = pageShopperInquiryService.getMShopperInquiryProductList(sno);
	   return inquiryProductList;
   }
   
   @GetMapping(value="myPageShopperInquiry/getInquiryList", produces="application/json; charset=UTF-8")
   public List<ProductInquiry> getInquiryList(int sno, String productName) {
	   ProductInquiry productInquiry = new ProductInquiry();
	   productInquiry.setSHOPPER_NO(sno);
	   productInquiry.setPRODUCT_NAME(productName);
	   List<ProductInquiry> productInquiryList = pageShopperInquiryService.getMShopperInquiryList(productInquiry);
	   return productInquiryList;
   }
   
   /**
    * 내 상품문의 초기화면 출력
    * @param pageNo(상품문의 페이저 페이지번호, default=1)
    * @param searchKeyword(상품 검색어, default="")
    * @param model
    * @param session
    * @return 상품문의(mypageShopperInquiry) 페이지
    */
   @RequestMapping("/mypageShopperInquiry")
   public String myPageShopperInquiry(
		   @RequestParam(name="pageNo", defaultValue="1") int pageNo, 
		   @RequestParam(name = "searchKeyword", defaultValue="") String searchKeyword,
		   Model model, 
		   HttpSession session) {
	   Shopper loginShopper = (Shopper) session.getAttribute("ShopperInfo");
	   //  -------------   [ 상품 문의 페이저  ]  --------------------
	   // Step1-1. 상품 게시판에 존재하는 회원별 상품문의 게시판 개수 load
	   int totalProductInquiryNum = pageShopperInquiryService.getTotalShopperInquiryNum(loginShopper.getShopperNo());
		
	   // Step2-2. Pager 객체 생성 (게시글 행 수, 페이지 개수, 총 페이지 개수, 페이지 시작 번호)
	   Pager productInquiryPager = new Pager(3, 5, totalProductInquiryNum, pageNo);
	   productInquiryPager.setSearchKeyword(searchKeyword);  //검색어로 찾기
		
	   // Step1-3. Pager 기반 상품 문의 게시판 생성
	   List<ProductInquiry> productInquiryList = pageShopperInquiryService.getShopperInquiryList(productInquiryPager, loginShopper.getShopperNo());
		
	   // Step1-4. Model객체로 JSP 전달
	   model.addAttribute("productInquiryPager", productInquiryPager);
	   model.addAttribute("productInquiryList", productInquiryList);
	   return "mypageShopperInquiry";
   }
   
   /**
    * 상품 이름 클릭시 해당 게시글로 이동
    * @param bno(상품 게시글로 이동할 상품 번호)
    * @param session
    * @return redirect로 상품 상세(detailView) 페이지
    */
   @RequestMapping("/mypageShopperInquiry/goToDetailView")
   public String goToDetailView(int bno, HttpSession session) {
		session.setAttribute("BoardNo", bno);
		return "redirect:/detailView";
   }
   
   /**
    * 상품문의 게시글 삭제
    * @param ino(삭제될 상품문의 번호)
    * @return redirect로 상품문의(mypageShopperInquiry) 페이지
    */
   @RequestMapping("/mypageShopperInquiry/deleteInquiry")
   public String deleteInquiry(int ino) {
	   pageShopperInquiryService.deleteShopperInquiry(ino);
	   return "redirect:/mypageShopperInquiry?shopperNo=" + 1;
   }
}