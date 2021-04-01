package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

public class AddressBookData {
	 private int personId;
	 public String first_name;
		public String last_name;
		public String phone_number;
		public String email;
		public String city;
		public String state;
		public long zip;
		
		public AddressBookData() { }
		
		public AddressBookData(int perId, AddressBookDTO addBookDTO) {
			this.personId = perId;
			this.first_name = addBookDTO.first_name;
			this.last_name = addBookDTO.last_name;
			this.phone_number = addBookDTO.phone_number;
			this.email = addBookDTO.email;
			this.city = addBookDTO.city;
			this.state = addBookDTO.state;
			this.zip = addBookDTO.zip;
		}
		public int getPersonId() {
			return personId;
		}
		public void setPersonId(int personId) {
			this.personId = personId;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getPhone_number() {
			return phone_number;
		}
		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public long getZip() {
			return zip;
		}
		public void setZip(long zip) {
			this.zip = zip;
		}
		
}
