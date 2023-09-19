package poris.fruitlight.controller.mobile;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.AddressBook;
import poris.fruitlight.service.AddressBookService;


@Slf4j
@RestController
public class AddressController {
	
	@Autowired
	private AddressBookService addrBookService;
		
	/**
	 * @author 김시온
	 * @param model - (받는 사람, 받을 주소, 연락처, 배송 요청사항) DTO
	 * @return 배송지 목록 페이지 이동
	 */
	@GetMapping(value="/getAddressList", produces="application/json; charset=UTF-8")
	public List<AddressBook> getAddressList() {
		 
		// Step1. 회원 정보 조회 - 회원 고유번호 획득
		//Shopper shopper = (Shopper) session.getAttribute("ShopperInfo");
		
		// Step2. 회원 번호를 기준으로 배송지 목록 조회
		int shopperNo = 1;
		List<AddressBook> addrBookList = addrBookService.getAddressBookList(shopperNo);
		
		if(addrBookList == null) {
			return addrBookList;
		}
		log.info(addrBookList.toString());
		// Step3. 배송지 목록을 JSP으로 전달
		//model.addAttribute("addrBookList", addrBookList);
		
		return addrBookList;
	}

	
	@PostMapping(value="/deleteAddress", produces="application/json; charset=UTF-8")
	public String deleteAddress(int address_no) throws Exception {
		   log.info("실행");
		   JSONObject jsonObject = new JSONObject();
		   try {
		           addrBookService.deleteAddressBook(address_no);
		           jsonObject.put("address_no", address_no);
		           jsonObject.put("address_result", "success");
		    
		   } catch(Exception e) {      
		       jsonObject.put("address_result", "fail");
		       jsonObject.put("message", e.getMessage());
		   }     
		   return jsonObject.toString();
	}
	
	/**
	 * @author 김시온
	 * @return 배송지 추가 페이지 이동
	 */
	@PostMapping(value="/addAddress", produces="application/json; charset=UTF-8")
	public String addAddress(AddressBook addressBook) throws Exception {
		log.info("addressBook :" + addressBook.toString());
		JSONObject jsonObject = new JSONObject();
		try {
				addrBookService.createAddressBook(addressBook);
				
				jsonObject.put("address_result", "success");
				jsonObject.put("address_no", addressBook.getAddress_no());
		} catch(Exception e) {
			
			jsonObject.put("address_result", "fail");
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject.toString();
	}
	

	
	
/*	*//**
	 * @author 고재승
	 * @param addressNo - 삭제할 배송지 고유번호
	 * @return - 배송지 목록 페이지으로 리다이렉트 
	 *//*
	@GetMapping("/addressBook/deleteAddressBook")
	public String deleteAddressBook(int addressNo) {
		addrBookService.deleteAddressBook(addressNo);
		
		return "redirect:/addressBook";
	}
	
	*//**
	 * @author 고재승
	 * @return 배송지 추가 페이지 이동
	 *//*
	@GetMapping("/addressBook/newAddressBook")
	public String newAddressBook() {
		
		return "newAddressBook";
	}*/
	
	

}
