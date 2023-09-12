package poris.fruitlight.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poris.fruitlight.dao.ShippingAddressDao;
import poris.fruitlight.dto.AddressBook;
import poris.fruitlight.dto.Shopper;

@Service
public class AddressBookServiceImpl implements AddressBookService{
	
	@Autowired
	private ShippingAddressDao shippingAddressDao;
	
	@Override
	public List<AddressBook> getAddressBookList(Shopper shopper) {
		
		List<AddressBook> AddrList = shippingAddressDao.selectShippingAddressListById(shopper);

		if(AddrList == null) {
			return null;
		}
		
		return AddrList;
	}
	
	@Override
	public void deleteAddressBook(int addressNo) {
		shippingAddressDao.deleteShippingAddress(addressNo);
	}
	
	
	@Override
	public void createAddressBook(AddressBook addressBook) {
		shippingAddressDao.insertShippingAddress(addressBook);
		
	}
}
