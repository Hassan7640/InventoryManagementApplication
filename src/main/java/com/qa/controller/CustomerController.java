package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudCustomerServices;

import utils.Utils;

public class CustomerController implements CrudCustomerController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudCustomerServices<Customer> customerServices;


	public CustomerController(CrudCustomerServices<Customer> customerServices) {
		this.customerServices = customerServices;
	}

	public String getInput() {
		return Utils.getInput();
	}
   /**
    * Creates a customer by taking in user input
    */
	public Customer create() {
		LOGGER.info("Please enter your firstname");
		String firstname = Utils.getInput();
		LOGGER.info("Please enter your surname");
		String surname = Utils.getInput();
		Customer customer = customerServices.create(new Customer(firstname, surname));
		LOGGER.info("Customer created");
		return customer;
	}
	
/**
 * Reads all customers to the logger
 */
	public List<Customer> readAll() {
		List<Customer> customers = customerServices.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());

		}
		return customers;
	}
  
	/**
	 * Updates an existing customer by taking in user input
	 */
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter your up-to-date firstname");
		String firstname = Utils.getInput();
		LOGGER.info("Please enter your up-to-date surname");
		String surname = Utils.getInput();
		Customer customer = customerServices.update(new Customer(id, firstname, surname));
		LOGGER.info("Customer updated");
		return customer;
	}
	
	/**
	 * Deletes an existing customer by an id of the customer
	 */
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		customerServices.delete(id);
	}

}
