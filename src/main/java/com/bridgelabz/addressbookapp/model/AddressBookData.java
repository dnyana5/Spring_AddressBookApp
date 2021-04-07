package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

public  @Data class AddressBookData {
		private int personId;
		public String first_name;
		public String last_name;
		public String phone_number;
		public String email;
		public String city;
		public String state;
		public String zip;
		
		public AddressBookData() { }
		
		public AddressBookData(int perId, AddressBookDTO addBookDTO) {
			this.personId = perId;
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
