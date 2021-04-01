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
	
			//curl localhost:8080/addressbookservice/ -w "\n"
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		List<AddressBookData> addDataList = null;
		addDataList = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Success",addDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	
	 		//curl localhost:8080/addressbookservice/get/1 -w "\n"
	@GetMapping("/get/{perId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("perId")int perId) {
		AddressBookData addressBookData = addressBookService.getAddressBookDataById(perId);
		ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
				//curl -X POST -H "Content-Type: application/json" -d '{"first_name": "Lisa","last_name": "Roy",
						//"phone_number": 9858742563,"email":"lisaR21@gmail.com","city":"pune",
						//"state":"Maharashtra","zip":413665}' "http://localhost:8080/addressbookservice/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = addressBookService.createAddressBookData(addBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Address Book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	 //curl -X PUT -H "Content-Type: application/json" -d '{"first_name": "Rahul","last_name": "Roy",
						//"phone_number": 8858742563,"email":"RahulR21@gmail.com","city":"pune",
						//"state":"Maharashtra","zip":413665}' "http://localhost:8080/addressbookservice/update/1" -w "\n"
	@PutMapping("/update/{perId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(
							@PathVariable("perId") int perId,
							@RequestBody AddressBookDTO addBookDTO) {
		AddressBookData addressBookData = addressBookService.updateAddressBookData(perId,addBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated  Address Book Data Successfully",addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	
	 		//curl -X DELETE -H "Content-Type: application/json" localhost:8080/addressbookservice/delete/1 -w "\n"
	@DeleteMapping("/delete/{perId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("perId") int perId) {
		addressBookService.deleteAddressBookData(perId);
			ResponseDTO respDTO = new ResponseDTO("Deleted Successfully","Deleted Id:"+perId);
			return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}
}