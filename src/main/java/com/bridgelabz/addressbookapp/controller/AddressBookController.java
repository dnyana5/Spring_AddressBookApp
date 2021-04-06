package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressBookData;
import com.bridgelabz.addressbookapp.services.IAddressBookService;

@RestController
@RequestMapping("/addressbookservice")

public class AddressBookController {
	
		@Autowired
		private IAddressBookService addressBookService;
	
		
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addDataList = null;
		addDataList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Success",addDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	
	 	
	@GetMapping("/get/{perId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("perId")int perId) {
		AddressBookData addressBookData = addressBookService.getAddressBookDataById(perId);
		ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
			
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = addressBookService.createAddressBookData(addBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Address Book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{perId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(
							@PathVariable("perId") int perId,
							@RequestBody AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = addressBookService.updateAddressBookData(perId,addBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated  Address Book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{perId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("perId") int perId) {
		addressBookService.deleteAddressBookData(perId);
			ResponseDTO respDTO = new ResponseDTO("Deleted Successfully","Deleted Id:"+perId);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}
}