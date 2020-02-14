package com.qa.controller;

import java.util.List;

import com.qa.persistence.domain.Customer;

/**
 * Create, Read, Update and Delete controller.
 * Accepts inputs for each functionality to be transfered to a service class
 *  
 */
public interface CrudCustomerController <T>{

	Customer create ();
	
	public List<Customer> readAll();
	
	Customer update();
	
	void delete();
}
