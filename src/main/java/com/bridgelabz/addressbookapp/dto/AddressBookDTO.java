package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {

	public String first_name;
	public String last_name;
	public String phone_number;
	public String email;
	public String city;
	public String state;
	public long zip;
	
	public AddressBookDTO(String first_name, String last_name, String phone_number, 
						String email, String city,String state, long zip) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
		
		@Override
		public String toString() {
			return "AddressBookDTO [first_name=" + first_name + ", last_name=" + last_name + ", phone_number="
					+ phone_number + ", email=" + email + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
		}
	}
