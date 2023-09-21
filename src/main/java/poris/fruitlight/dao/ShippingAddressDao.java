package poris.fruitlight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import poris.fruitlight.dto.AddressBook;
import poris.fruitlight.dto.ShippingAddressParam;
import poris.fruitlight.dto.Shopper;

@Mapper
public interface ShippingAddressDao {
	
	/**
	 * 회원의 배송지 목록 리스트를 반환하는 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param shopper - 회원 정보
	 * @return - 회원의 배송지 목록
	 */
	public List<AddressBook> selectShippingAddressListById(int shopperNo);
	
	/**
	 * 신규 배송지 주소를 등록하는 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param addressBook - 배송지 주소
	 */
	public void insertShippingAddress(AddressBook addressBook);
	
	/**
	 * 회원 고유번호를 기준으로 기본 배송지 주소록을 얻는 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param userId - 회원 고유번호
	 * @return 기본 배송지 주소 정보
	 */
	public AddressBook selectShippingAddressById(int shopperNo);
	
	/**
	 * 배송지 고유번호를 기준으로 배송지를 삭제하는 메소드
	 * @author 고재승
	 * @since 2023.08.16
	 * @param addressNo
	 */
	public void deleteShippingAddress(int addressNo);
}
