package com.qa.controller;

import java.util.List;

import com.qa.persistence.domain.Customer;

public interface CrudCustomerController <T>{

	Customer create ();
	
	public List<Customer> readAll();
	
	Customer update();
	
	void delete();
}
