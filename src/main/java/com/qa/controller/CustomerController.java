package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudServices;

import utils.Utils;

public class CustomerController implements CrudController<Customer> /* , CustomerIdController<Customer> */ {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerServices;

	// private CustomerId <Customer> getCustId;

	public CustomerController(CrudServices<Customer> customerServices /* , CustomerId<Customer> getCustId */) {
		this.customerServices = customerServices;
		// this.getCustId=getCustId;
	}

	String getInput() {
		return Utils.getInput();
	}

	public Customer create() {
		LOGGER.info("Please enter your first name");
		String firstName = Utils.getInput();
		LOGGER.info("Please enter your surname");
		String surname = Utils.getInput();
		Customer customer = customerServices.create(new Customer(firstName, surname));
		LOGGER.info("Customer created");
		return customer;
	}

	public List<Customer> readAll() {
		List<Customer> customers = customerServices.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());

		}
		return customers;
	}

	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter your up-to-date firstname");
		String firstName = Utils.getInput();
		LOGGER.info("Please enter your up-to-date firstname");
		String surname = Utils.getInput();
		// long id =getCustId();
		Customer customer = customerServices.update(new Customer(id, firstName, surname));
		LOGGER.info("Customer updated");
		return customer;
	}

	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		customerServices.delete(id);
	}

}
