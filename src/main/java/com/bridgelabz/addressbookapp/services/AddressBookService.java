package com.bridgelabz.addressbookapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{
	
	private List<AddressBookData> addressBookList = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}
	
	@Override
	public AddressBookData getAddressBookDataById(int perId) {
		  return addressBookList.get(perId-1);
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1,addBookDTO);
		addressBookList.add(addressBookData);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int perId, AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(perId);
		addressBookData.setFirst_name(addBookDTO.first_name); 
		addressBookData.setLast_name(addBookDTO.last_name);
		addressBookData.setPhone_number(addBookDTO.phone_number);
		addressBookData.setEmail(addBookDTO.email);
		addressBookData.setCity(addBookDTO.city);
		addressBookData.setState(addBookDTO.state);
		addressBookData.setZip(addBookDTO.zip);
		addressBookList.set(perId-1, addressBookData);
		return addressBookData;
	}


	@Override
	public void deleteAddressBookData(int perId) {
		addressBookList.remove(perId-1);
		
	}

}
