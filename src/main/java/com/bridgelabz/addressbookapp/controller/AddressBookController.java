package com.bridgelabz.addressbookapp.controller;

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

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	
	 //curl localhost:8080/addressbookservice/ -w "\n"
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1,new AddressBookDTO("Aarti","Gaikwad","9685412563","artig16@gmail.com",
				"solapur","Maharashtra",413008));
		ResponseDTO respDTO = new ResponseDTO("Get Call Success",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	 //curl localhost:8080/addressbookservice/get/1 -w "\n"
	@GetMapping("/get/{perId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("perId")int perId) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1,new AddressBookDTO("Aarti","Gaikwad","9685412563","artig16@gmail.com",
				"solapur","Maharashtra",413008));
		ResponseDTO respDTO = new ResponseDTO("Get Call Success for id: "+perId,addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	//curl -X POST -H "Content-Type: application/json" -d '{"first_name": "Lisa","last_name": "Roy",
						//"phone_number": 9858742563,"email":"lisaR21@gmail.com","city":"pune",
						//"state":"Maharashtra","zip":413665}' "http://localhost:8080/addressbookservice/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(1,addBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Address Book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	 //curl -X PUT -H "Content-Type: application/json" -d '{"first_name": "Rahul","last_name": "Roy",
						//"phone_number": 8858742563,"email":"RahulR21@gmail.com","city":"pune",
						//"state":"Maharashtra","zip":413665}' "http://localhost:8080/addressbookservice/update" -w "\n"
	@PutMapping("/update/{perId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(
							@PathVariable("perId") int perId,
							@RequestBody AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = null;
		addressBookData = new AddressBookData(perId,addBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Address Book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	 //curl -X DELETE -H "Content-Type: application/json" localhost:8080/addressbookservice/delete/1 -w "\n"
	@DeleteMapping("/delete/{perId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("perId") int perId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully","Deleted Id:"+perId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

}