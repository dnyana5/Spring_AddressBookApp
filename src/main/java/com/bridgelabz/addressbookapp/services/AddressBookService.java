package com.bridgelabz.addressbookapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{
	@Autowired
	private AddressBookRepository addressRepository;
	private List<AddressBookData> addressBookList = new ArrayList<>();


	public List<AddressBookData> getAddressBookData() {
		return addressBookList;
	}
	
	public AddressBookData getAddressBookDataById(int perId) {
		return addressBookList.stream()
		  			.filter(addressBookData -> addressBookData.getPersonId() == perId)
					.findFirst()
					.orElseThrow(() -> new AddressBookException("Person Not Found"));
	}

	public AddressBookData createAddressBookData(AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addBookDTO);
		addressBookList.add(addressBookData);
		log.debug("Add Data: "+addressBookData.toString());
		return addressRepository.save(addressBookData);
	}

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

	public void deleteAddressBookData(int perId) {
		addressBookList.remove(perId-1);
		
	}

}
