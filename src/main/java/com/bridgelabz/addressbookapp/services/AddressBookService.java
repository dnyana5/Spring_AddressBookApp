package com.bridgelabz.addressbookapp.services;

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

	public List<AddressBookData> getAddressBookData() {
		return addressRepository.findAll();
	}
	
	public AddressBookData getAddressBookDataById(int perId) {
		return addressRepository
		  			.findById(perId)
					.orElseThrow(() -> new AddressBookException("Person with personId"
					+ perId + "does not exists..!!"));
	}

	public AddressBookData createAddressBookData(AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(addBookDTO);
		log.debug("Add Data: "+addressBookData.toString());
		return addressRepository.save(addressBookData);
	}
	
	public AddressBookData updateAddressBookData(int perId, 
												AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(perId);
		addressBookData.updateAddressBookData(addBookDTO); 
		return addressRepository.save(addressBookData);
	}
	public void deleteAddressBookData(int perId) {
		AddressBookData addressBookData = this.getAddressBookDataById(perId);
		addressRepository.delete(addressBookData);
	}

}
