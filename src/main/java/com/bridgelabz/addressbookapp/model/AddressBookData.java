package com.bridgelabz.addressbookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

@Entity
@Table(name = "address_book")
public  @Data class AddressBookData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
		private int personId;
		public String first_name;
		public String last_name;
		public String phone_number;
		public String email; 
		public String city;	
		public String state;
		public String zip;
		
		public AddressBookData() { }
		
		public AddressBookData(AddressBookDTO addBookDTO) {
			this.updateAddressBookData(addBookDTO);
		}

		private void updateAddressBookData(AddressBookDTO addBookDTO) {
			this.first_name = addBookDTO.first_name;
			this.last_name = addBookDTO.last_name;
			this.phone_number = addBookDTO.phone_number;
			this.email = addBookDTO.email;
			this.city = addBookDTO.city;
			this.state = addBookDTO.state;
			this.zip = addBookDTO.zip;
		}
}
