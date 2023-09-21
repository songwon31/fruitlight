package poris.fruitlight.controller;

import java.util.Base64;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.MobileProductForList;
import poris.fruitlight.dto.ProductList;
import poris.fruitlight.service.ListService;

@Slf4j
@Controller
public class ListController {
	
	@Resource
	private ListService listService;
	
	/**
	 * @author 송원석
	 */
	@RequestMapping(value="/list/getMobileProductsForList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<MobileProductForList> getMobileProductsForList(@RequestParam(value="keyword", required=false) String keyword) {
		return listService.getMobileProductsForList(keyword);
	}
	
	/**
	 * @author 송원석
	 */
	@RequestMapping(value="/list/getMobileProductsForListPriceDesc", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<MobileProductForList> getMobileProductsForListPriceDesc(@RequestParam(value="keyword", required=false) String keyword) {
		return listService.getMobileProductsForListPriceDesc(keyword);
	}
	
	/**
	 * @author 송원석
	 */
	@RequestMapping(value="/list/getMobileProductsForListPriceAsc", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<MobileProductForList> getMobileProductsForListPriceAsc(@RequestParam(value="keyword", required=false) String keyword) {
		return listService.getMobileProductsForListPriceAsc(keyword);
	}
	
	@RequestMapping(value="/list/getCherryAdList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<MobileProductForList> getCherryAdList() {
		return listService.getCherryAdList();
	}
	
	@RequestMapping(value="/list/getWatermelonAdList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<MobileProductForList> getWatermelonAdList() {
		return listService.getWatermelonAdList();
	}
	
	@RequestMapping(value="/list/getMangoAdList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<MobileProductForList> getMangoAdList() {
		return listService.getMangoAdList();
	}
	
	/**
	 * @author 송원석
	 */
	@RequestMapping(value="/list/getThumbnailImage", produces="image/jpeg")
	@ResponseBody
	public byte[] getThumbnailImage(int board_no) {
		return listService.getThumbnailImage(board_no).getMedia_data();
	}
	
	
	
	/**
	 * @author 김진성
	 * @param searchKeyword - 검색 된 상품명(Header 상단 카테고리를 검색어로 적용)
	 * @param sortOption - 가격 순으로 상품 목록을 나타내기 위한 param
	 * @param model - 검색어 및 상품 목록 DTO
	 * @return 상품 목록 페이지
	 */
	@RequestMapping("/list")
		public String list(
				@RequestParam(name = "search", required = false) String searchKeyword,
				@RequestParam(name = "sort", required = false) String sortOption,
				Model model) {
			List<ProductList> productLists;
			
			if (searchKeyword != null) {
	            productLists = listService.SearchProductsByPname(searchKeyword);
	            
	            for(ProductList listProduct : productLists) {
	            	listProduct.setBase64Img(Base64.getEncoder().encodeToString(listProduct.getMEDIA_DATA()));
	  	      }
	        } else {
	            productLists = listService.SearchProducts(); // 모든 제품 목록을 가져오는 메소드
	            for(ProductList listProduct : productLists) {
	            	listProduct.setBase64Img(Base64.getEncoder().encodeToString(listProduct.getMEDIA_DATA()));
	            }
	        }
			
			//DISCOUNT_PRICE를 기준으로 비교하여 오름/내림 차순으로 정렬해주는 메소드(Comparator.comparing)
			if ("lowPrice".equals(sortOption)) {
				productLists.sort(Comparator.comparing(ProductList::getDISCOUNT_PRICE));
		    } else if ("highPrice".equals(sortOption)) {
		    	productLists.sort(Comparator.comparing(ProductList::getDISCOUNT_PRICE).reversed());
		    }
			
			model.addAttribute("productLists", productLists);
			model.addAttribute("searchKeyword", searchKeyword);
			return "list";
		}
	
	/**
	 * @author 고재승
	 * @param pid - 상품 고유 번호
	 * @param session
	 * @return 상품 상세 정보 페이지
	 */
	@RequestMapping("/list/SelectDetailView")
	public String moveDetailViewPage(int pid, HttpSession session) {
		
		// Step1. PRODUCT_ID를 기준으로 선택한 게시판 번호를 조회한다.
		int boardNo = listService.getSelectBoardNo(pid);
		// Step2. Session에 게시판 번호를 저장한다.
		session.setAttribute("BoardNo", boardNo);
		// Step3. 페이지는 DetailView로 이동하되, Detail View에서 게시판 번호를 Session 객체로 조회해야한다.
		
		
		return "redirect:/detailView";
	}
}
