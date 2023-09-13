package poris.fruitlight.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.BoardMedia;
import poris.fruitlight.dto.Cart;
import poris.fruitlight.dto.FoodRequiredInfo;
import poris.fruitlight.dto.OrderParam;
import poris.fruitlight.dto.Pager;
import poris.fruitlight.dto.Product;
import poris.fruitlight.dto.ProductBoard;
import poris.fruitlight.dto.ProductInquiry;
import poris.fruitlight.dto.Review;
import poris.fruitlight.dto.ReviewInfo;
import poris.fruitlight.dto.Shopper;
import poris.fruitlight.service.DetailViewService;

@Slf4j
@Controller
public class DetailViewController {
	@Resource
	private DetailViewService detailViewService;
	
	/**
	 * 상품 상세 페이지 초기화면 출력
	 * @author 고재승, 이은지
	 * @param model
	 * @return 상세상품(detailView) 페이지
	 */
	@RequestMapping("/detailView")
	public String detailView(Model model, HttpSession session) {
		// Step1. Session에 있는 게시판 번호 얻기
		int bno = Integer.parseInt(session.getAttribute("BoardNo").toString());
		
		//  -------------   [ 상품 정보  ]  --------------------
		// Step2-1. 게시판 번호에 해당하는 데이터 load
		ProductBoard productBoard = detailViewService.getProduct(bno);
		productBoard.setBase64Img(Base64.getEncoder().encodeToString(productBoard.getMediaData()));
		List<ProductBoard> productImageList = detailViewService.getImages(bno);
		
		for(ProductBoard product : productImageList) {
			product.setBase64Img(Base64.getEncoder().encodeToString(product.getMediaData()));
		}
		
		// Step2-2. 상품 이름을 기준으로 옵션 데이터 load
		List<Product> productOptionList = detailViewService.getOptions(productBoard.getProductName());
		
		
		// Step2-3. 상품 정보와 옵션 정보를 JSP에 Model으로 전달
		model.addAttribute("productBoard", productBoard);
		model.addAttribute("productImageList", productImageList);
		model.addAttribute("productOptionList", productOptionList);
		
		//  -------------   [ 상품 필수 표기 정보  ]  --------------------
		// Step3-1. 게시글 번호를 기준으로 필수 표기 정보 데이터 load
		FoodRequiredInfo foodRequiredInfo = detailViewService.getFoodRequiredInfoByBoardNo(bno);
		// Step3-2. 상품 필수 표기 정보를 JSP에 Model으로 전달
		model.addAttribute("foodRequiredInfo", foodRequiredInfo);
		
		//  -------------   [ 상품 상세 정보  ]  --------------------
		// Step4-1. 게시글 번호를 기준으로 상품 상세 정보 데이터 load
		List<BoardMedia> productContentList = detailViewService.getProductContentList(bno);
		
		// Step4-2. 이미지 데이터 Base64 인코딩 진행
		for(BoardMedia productContent : productContentList) {
			productContent.setBase64Img(Base64.getEncoder().encodeToString(productContent.getMediaData()));
	    }
		// Step4-3. 상품 상세정보를 JSP에 Model으로 전달
		model.addAttribute("productContentList", productContentList);
		
		
		//  -------------   [ 리뷰 페이저  ]  --------------------
		// Step5-1. 게시판 번호에 해당하는 리뷰의 총 개수 load
		int totalReviewStock = detailViewService.getTotalReviewStock(bno);
		
		// Step5-2. Pager객체 생성 및 리뷰 게시판 생성
		Pager ReviewPager = new Pager(2, 2, totalReviewStock, 1);
		List<Review> ReviewList = detailViewService.getReviewList(ReviewPager, bno);
		
		// Step5-3. 리뷰 평균 점수 처리
		ReviewInfo reviewInfo = null;
		
		if(ReviewList.size() != 0) {
			reviewInfo = new ReviewInfo();
			int totalSumStarRate = 0;
			
			for(Review review : ReviewList) {
				totalSumStarRate += review.getStar_rate();
			}
			
			reviewInfo.setStarRateAvg(totalSumStarRate/ReviewList.size());
			reviewInfo.setTotalReviewScore((float)(Math.round((totalSumStarRate/40.0)*10)/10.0));
		}
		
		// Step5-4. Model객체로 JSP 전달
		model.addAttribute("ReviewPager", ReviewPager);
		model.addAttribute("ReviewList", ReviewList);
		model.addAttribute("ReviewInfo", reviewInfo);
		
		//  -------------   [ 상품 문의 페이저  ]  --------------------
		// Step6-1. 상품 게시판에 존재하는 상품문의 게시판 개수 load
		int totalProductInquiryNum = detailViewService.getTotalProductInquiryNum(bno);
		
		// Step6-2. Pager 객체 생성 (게시글 행 수, 페이지 개수, 총 페이지 개수, 페이지 시작 번호)
		Pager productInquiryPager = new Pager(5, 5, totalProductInquiryNum, 1);
		
		// Step6-3. Pager 기반 상품 문의 게시판 생성
		List<ProductInquiry> productInquiryList = detailViewService.getProductInquiryList(productInquiryPager, bno);
		
		// Step6-4. Model객체로 JSP 전달
		model.addAttribute("productInquiryPager", productInquiryPager);
		model.addAttribute("productInquiryList", productInquiryList);
		
		return "detailView";
	}

	/**
	 * 장바구니에 상품 추가
	 * @author 이은지
	 * @param request
	 * @param session
	 */
	//장바구니 담기
	@RequestMapping("/detailView/addCartProduct")
	public void addCartProduct(HttpServletRequest request, HttpSession session) {
		Shopper loginShopper = (Shopper) session.getAttribute("ShopperInfo");
		if(loginShopper != null) {
			List<Cart> list = new ArrayList<>();
			
			String[] strPnoList = request.getParameterValues("pnos");
			String[] strStockList = request.getParameterValues("stocks");
			
			for(int i=0; i<strPnoList.length; i++) {
				Cart cartProduct = new Cart();
				cartProduct.setSHOPPER_NO(loginShopper.getShopperNo());
				cartProduct.setPRODUCT_NO(Integer.parseInt(strPnoList[i]));
				cartProduct.setCART_PRODUCT_STOCK(Integer.parseInt(strStockList[i]));
				
				list.add(cartProduct);
			}

			detailViewService.addToCart(list);
		}
	}
	
	/**
	 * 바로구매 클릭시 ajax로 받은 상품정보를 결제 controller에 전달
	 * @author 이은지
	 * @param session
	 * @param pnos(상품 번호 리스트)
	 * @param pnames(상품 이름 리스트)
	 * @param options(상품 옵션 리스트)
	 * @param stocks(상품 수량 리스트)
	 * @param prices(상품 가격 리스트)
	 * @param totalPrice(총 상품 가격)
	 * @param shippingPrice(배송비)
	 * @param orderPrice(총 주문 가격)
	 * @return redirect로 주문/결제(order) 페이지
	 */
	//바로구매
	@RequestMapping("/detailView/buyDirect")
	public String buyDirect(
			HttpSession session,
			@RequestParam List<Integer> pnos, 
			@RequestParam List<String> pnames,
			@RequestParam List<String> options,
			@RequestParam List<Integer> stocks,
			@RequestParam List<Integer> prices,
			@RequestParam int totalPrice,
			@RequestParam int shippingPrice,
			@RequestParam int orderPrice) {
		
		List<OrderParam> orderParamList = new ArrayList<>();
		
		for(int i=0; i<pnos.size(); i++) {
			OrderParam oderParam = new OrderParam();
			oderParam.setProductNo(pnos.get(i));
			oderParam.setProductName(pnames.get(i));
			oderParam.setProductOption(options.get(i));
			oderParam.setProductStock(stocks.get(i));
			oderParam.setProductPrice(prices.get(i));
			
			orderParamList.add(oderParam);
		}
		
		session.setAttribute("orderParamList", orderParamList);
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("discountPrice", 0);
		session.setAttribute("shippingPrice", shippingPrice);
		session.setAttribute("orderPrice", orderPrice);
		
		return "redirect:/order";
	}
	
	/**
	 * 상품문의 페이저
	 * @author 이은지
	 * @param pageNo(이동할 페이지 번호)
	 * @param session
	 * @return HashMap<"키", 객체>
	 */
	//상품문의 페이저
	@GetMapping("/detailView/moveInquiryPage")
	@ResponseBody
	public HashMap<String, Object> moveInquiryPage(String pageNo, HttpSession session) {
		int bno = Integer.parseInt(session.getAttribute("BoardNo").toString());
		int totalProductInquiryNum = detailViewService.getTotalProductInquiryNum(bno);
		
		Pager productInquiryPager = new Pager(5, 5, totalProductInquiryNum, Integer.parseInt(pageNo));
		List<ProductInquiry> productInquiryList = detailViewService.getProductInquiryList(productInquiryPager, bno);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("productInquiryPager", productInquiryPager);
		map.put("productInquiryList", productInquiryList);
		
		return map;
	}
	
	
	
	@GetMapping("/detailView/addHelpPoint")
	@ResponseBody
	public Object addHelpPoint(String ReviewNo) {
		log.info("ReviewNo : " + ReviewNo);
		
		detailViewService.addHelpPoint(ReviewNo);
		
		return Integer.parseInt(ReviewNo);
	}
	
	
	
	/**
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pageNo - 이동할 페이지 번호
	 * @param session - 게시글 번호
	 * @return Map<"키", 객체>
	 */
	@GetMapping("/detailView/moveReviewPage")
	@ResponseBody
	public HashMap<String, Object> moveReviewPage(String pageNo, HttpSession session) {
		int bno = Integer.parseInt(session.getAttribute("BoardNo").toString());
		int totalReviewCount = detailViewService.getTotalReviewStock(bno);
		
		Pager reviewPager = new Pager(2, 2, totalReviewCount, Integer.parseInt(pageNo));
		List<Review> reviewList = detailViewService.getReviewList(reviewPager, bno);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ReviewPager", reviewPager);
		map.put("ReviewList", reviewList);
		
		return map;
	}
	
	
	/**
	 * @author 고재승
	 * @since 2023.08.18
	 * @param pageNo - 이동할 페이지 번호
	 * @param session - 게시글 번호
	 * @return Map<"키", 객체>
	 */
	@GetMapping("/detailView/searchReviewPage")
	@ResponseBody
	public HashMap<String, Object> searchReviewPage(@RequestParam("reviewSearchKeyword")String reviewSearchKeyword, @RequestParam("pageNo")String pageNo, HttpSession session) {
		int bno = Integer.parseInt(session.getAttribute("BoardNo").toString());
		int totalReviewCount = detailViewService.getTotalReviewStock(bno);
		
		if(pageNo == null || pageNo.equals("")) {pageNo = "1";}
		log.info("pageNo : " + pageNo);
		log.info("reviewSearchKeyword : " + reviewSearchKeyword);
		Pager reviewPager = new Pager(2, 2, totalReviewCount, Integer.parseInt(pageNo));
		List<Review> reviewList = detailViewService.getSearchReviewList(reviewPager, reviewSearchKeyword, bno);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ReviewPager", reviewPager);
		map.put("ReviewList", reviewList);
		
		return map;
	}
	
	
	/**
	 * @author 고재승
	 * @since 2023.08.18
	 * @param session - 게시글 번호
	 * @return Map<"키", 객체>
	 */
	@GetMapping("/detailView/bestReviewPage")
	@ResponseBody
	public HashMap<String, Object> bestReviewPage(HttpSession session) {
		int bno = Integer.parseInt(session.getAttribute("BoardNo").toString());
		int totalReviewCount = detailViewService.getTotalReviewStock(bno);
		
		Pager reviewPager = new Pager(10, 1, totalReviewCount, 1);
		List<Review> reviewList = detailViewService.getSearchBestReviewList(reviewPager, bno);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ReviewPager", reviewPager);
		map.put("ReviewList", reviewList);
		
		return map;
	}
	
	
	/**
	 * @author 고재승
	 * @since 2023.08.18
	 * @param session - 게시글 번호
	 * @return Map<"키", 객체>
	 */
	@GetMapping("/detailView/recentReviewPage")
	@ResponseBody
	public HashMap<String, Object> recentReviewPage(HttpSession session) {
		int bno = Integer.parseInt(session.getAttribute("BoardNo").toString());
		int totalReviewCount = detailViewService.getTotalReviewStock(bno);
		
		Pager reviewPager = new Pager(10, 1, totalReviewCount, 1);
		List<Review> reviewList = detailViewService.getSearchRecentReviewList(reviewPager, bno);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ReviewPager", reviewPager);
		map.put("ReviewList", reviewList);
		
		return map;
	}
}
