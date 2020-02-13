package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;
import com.qa.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	@Mock
	private CustomerServices customerServices;
	
	@Spy
	@InjectMocks
	private CustomerController customerController;
	
	
//	@Test
//	public void createTest() {
//		String firstname = "Brahim";
//		String surname = "Azreg";
//		Mockito.doReturn(firstname, surname).when(customerController).getInput();
//		Customer customers = new Customer(firstname,surname);
//		Customer currentCustomer = new Customer(1L,"Brahim", "Azreg");
//		Mockito.when(customerServices.create(customers)).thenReturn(currentCustomer);
//		assertEquals(currentCustomer, customerController.create());
//	}
	
	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Josh", "Young-Cannon"));
		customers.add(new Customer("Rhys", "Thompson"));
		customers.add(new Customer("Chris", "Perrins"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	
	}
	
//	@Test
//	public void updateTest() {
//		String id = "1";
//		String firstname = "Charlie";
//		String surname = "Reddin";
//		Mockito.doReturn(id, firstname, surname).when(customerController).getInput();
//		Customer customer = new Customer(1L,firstname, surname);
//		Mockito.when(customerServices.update(customer)).thenReturn(customer);
//		assertEquals(customer, customerController.update());
//	}
	
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

}
