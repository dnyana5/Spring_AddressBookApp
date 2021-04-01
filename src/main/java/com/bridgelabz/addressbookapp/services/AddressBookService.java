package com.bridgelabz.addressbookapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{

	@Override
	public List<AddressBookData> getAddressBookData() {
		List<AddressBookData> addressBookList = new ArrayList<>();
		addressBookList.add(new AddressBookData(1, new AddressBookDTO("Aarti","Gaikwad","9685412563","artig16@gmail.com",
				"solapur","Maharashtra",413008)));
		return addressBookList;
	}
	
	@Override
	public AddressBookData getAddressBookDataById(int perId) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1,new AddressBookDTO("Aarti","Gaikwad","9685412563","artig16@gmail.com",
				"solapur","Maharashtra",413008));
		return addressBookData;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1,addBookDTO);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int perId, AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(perId,addBookDTO);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int perId) {
		// TODO Auto-generated method stub
		
	}

}
