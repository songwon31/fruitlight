package poris.fruitlight.service;

import java.util.List;

import poris.fruitlight.dto.AddressBook;
import poris.fruitlight.dto.Shopper;

public interface AddressBookService {
	/**
	 * DB에 저장된 배송지의 정보를 모두 조회하는 메소드
	 * @author 고재승
	 * @return 배송지 정보의 목록을 반환합니다.
	 */
	public List<AddressBook> getAddressBookList(int shopperNo);
	
	/**
	 * 삭제할 배송지 정보를 전달하는 메소드
	 * @author 고재승
	 * @param addressNo - 배송지 고유번호
	 */
	public void deleteAddressBook(int addressNo);
	
	/**
	 * 새로운 배송지를 DB에 등록하는 메소드
	 * @author 고재승
	 * @since 2023.08.14
	 * @param addressBook - 배송지 DTO
	 */
	public void createAddressBook(AddressBook addressBook);
	
	public void modifyAddressBook(AddressBook addressBook);
	
	public AddressBook getAddress(int shopperNo);
	
	
}
