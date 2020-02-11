package com.qa.persistence.domain;

public class Customer {
	
	private Long id;
	private String firstName;
	private String surName;
	
	public Customer(String firstName, String surName) {
		this.firstName=firstName;
		this.surName=surName;
	}
	
	public Customer(Long id, String firstName,String surName ) {
		this.id=id;
		this.firstName=firstName;
		this.surName=surName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surName;
	}
	public void setSurname(String surName) {
		this.surName = surName;
	}
	
	public String toString() {
		return "id: "+ id+" first name: " +firstName+" surname: " +surName;
	}

}
