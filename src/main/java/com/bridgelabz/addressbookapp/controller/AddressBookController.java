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

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	
	 //curl localhost:8080/addressbookservice/ -w "\n"
	@RequestMapping(value = {"","/","/get"})
	public ResponseEntity<String> getAddressBookData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
	
	 //curl localhost:8080/addressbookservice/get/1 -w "\n"
	@GetMapping("/get/{perId}")
	public ResponseEntity<String> getAddressBookData(@PathVariable("perId")int perId) {
		return new ResponseEntity<String>("Get Call Success for id: "+perId, HttpStatus.OK);
	}
	
	
	//curl -X POST -H "Content-Type: application/json" -d '{"first_name": "Lisa","last_name": "Roy",
						//"phone_number": 9858742563,"email":"lisaR21@gmail.com","city":"pune",
						//"state":"Maharashtra","zip":413665}' "http://localhost:8080/addressbookservice/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<String> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Created Address Book Data for: "+addressBookDTO, HttpStatus.OK);
	}
	
	
	 //curl -X PUT -H "Content-Type: application/json" -d '{"first_name": "Rahul","last_name": "Roy",
						//"phone_number": 8858742563,"email":"RahulR21@gmail.com","city":"pune",
						//"state":"Maharashtra","zip":413665}' "http://localhost:8080/addressbookservice/update" -w "\n"
	@PutMapping("/update")
	public ResponseEntity<String> updateAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<String>("Updated Address Book Data for: "+addressBookDTO, HttpStatus.OK);
	}	
	
	 //curl -X DELETE -H "Content-Type: application/json" localhost:8080/addressbookservice/delete/1 -w "\n"
	@DeleteMapping("/delete/{perId}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("perId") int perId) {
		return new ResponseEntity<String>("Delete call Success for id: "+perId, HttpStatus.OK);
	}

}