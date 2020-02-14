package com.qa.ims.services;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.Spy;
	import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.dao.MySQLCustomerDAO;
import com.qa.persistence.domain.Customer;
import com.qa.services.CustomerServices;

;

	@RunWith(MockitoJUnitRunner.class)
	public class CustomerServicesTest {
		
		@Mock
		private MySQLCustomerDAO customerDao;
		
		@InjectMocks
		private CustomerServices customerServices;
		
		@Test 
		public void customerServicesCreate() {
			Customer customer = new Customer("Hassan", "Njie");
			customerServices.create(customer);
			Mockito.verify(customerDao, Mockito.times(1)).create(customer);
		}
		
		@Test
		public void customerServicesRead() {
			customerServices.readAll();
			Mockito.verify(customerDao, Mockito.times(1)).readAll();
		}
		
		@Test
		public void customerServicesUpdate() {
			Customer customer = new Customer("rhys", "thompson");
			customerServices.update(customer);
			Mockito.verify(customerDao, Mockito.times(1)).update(customer);
		}
		
		@Test
		public void customerServicesDelete() {
			customerServices.delete(1L);;
			Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
		}
	}

