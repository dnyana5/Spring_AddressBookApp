package com.bridgelabz.addressbookapp.services;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

public interface IAddressBookService {
	List<AddressBookData> getAddressBookData();
	
	AddressBookData getAddressBookDataById(int perId);
	
	AddressBookData createAddressBookData(
		AddressBookDTO addBookDTO);
	
	AddressBookData updateAddressBookData(int perId,
		AddressBookDTO addBookDTO);
	
	void deleteAddressBookData(int perId);
	
}
