package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class AddressBookDTO {


	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Person first name is Invalid")
	public String first_name;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Person last name is Invalid")
	public String last_name;
	@Pattern(regexp ="^([\\+]91)?[6-9]{1}[0-9]{9}$",message = "Invalid Phone number")
	public String phone_number;
	@Pattern(regexp ="^[a-zA-Z]{1,}([.\\-+]?[a-zA-Z0-9]+)?\\@[a-z0-9]{1,}\\.([a-z]{2,4})(\\.[a-z]{2,4})?$"
						,message = "Invalid email")
	public String email;
	@NotBlank(message = "City cannot be Empty")
	public String city;
	@NotBlank(message = "State cannot be Empty")
	public String state;
	@Pattern(regexp ="^[0-9]{6}$", message = "Zip should be 6 digit")
	public String zip;

}
