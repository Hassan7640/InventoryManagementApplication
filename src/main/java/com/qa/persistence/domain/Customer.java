package com.qa.persistence.domain;

public class Customer {
	
	private Long id;
	private String firstname;
	private String surname;
	
	public Customer(String firstname, String surname) {
		this.firstname=firstname;
		this.surname=surname;
	}
	
	public Customer(Long id, String firstname,String surname ) {
		this.id=id;
		this.firstname=firstname;
		this.surname=surname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstname;
	}
	  
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return "id: "+ id+" first name: " +firstname+" surname: " +surname;
	}
}
