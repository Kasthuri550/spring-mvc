package com.virtusa.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Address {
	
	@NotBlank(message = "{address.street}")
	private String street;
	
	@Size(min = 2,max = 2,message = "Size of state must be 2")
	private String state;
	
	@NotNull(message = "Zip code is a required field")
	private Integer zipCode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
}
