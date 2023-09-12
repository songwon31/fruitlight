package poris.fruitlight.controller.mobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poris.fruitlight.dto.AddressBook;
import poris.fruitlight.dto.Shopper;
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
	@GetMapping(value="/addressBook", produces="application/json; charset=UTF-8")
	public List<AddressBook> getAddressList(Shopper shopper) {
		 
		// Step1. 회원 정보 조회 - 회원 고유번호 획득
		//Shopper shopper = (Shopper) session.getAttribute("ShopperInfo");
		
		// Step2. 회원 번호를 기준으로 배송지 목록 조회
		List<AddressBook> addrBookList = addrBookService.getAddressBookList(shopper);
		
		if(addrBookList == null) {
			return addrBookList;
		}
		log.info(addrBookList.toString());
		// Step3. 배송지 목록을 JSP으로 전달
		//model.addAttribute("addrBookList", addrBookList);
		
		return addrBookList;
	}
/*	
	*//**
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
	}
	
	
	*//**
	 * @author 고재승
	 * @return 배송지 추가 페이지 이동
	 *//*
	@PostMapping("/addressBook/addAddressBook")
	public String addAddressBook(AddressBook addressBook) {
		log.info("addressBook :" + addressBook.toString());
		addrBookService.createAddressBook(addressBook);
		
		return "redirect:/addressBook";
	}*/
}
