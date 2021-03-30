package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {

	public String name;
	public long phoneNumber;
	
	public AddressBookDTO(String name,long phoneNumber) {
		this.name=name;
		this.phoneNumber=phoneNumber;
	}
		
		@Override
		public String toString() {
			return "name=" +name+ ":phoneNumber="+phoneNumber;
		}
	}
