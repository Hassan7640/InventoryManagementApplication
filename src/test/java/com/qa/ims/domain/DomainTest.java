package com.qa.ims.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.persistence.domain.Domain;

public class DomainTest {
		
		@Test
		public void customerTest() {
			Domain domain = Domain.CUSTOMER;
			assertTrue(domain.getDescription().toLowerCase().contains("customer"));
		}
		
		@Test
		public void itemTest() {
			Domain domain = Domain.ITEM;
			assertTrue(domain.getDescription().toLowerCase().contains("item"));
		}
		
		@Test
		public void orderTest() {
			Domain domain = Domain.ORDER;
			assertTrue(domain.getDescription().toLowerCase().contains("order"));
		}
		 
		@Test
		public void orderItemTest() {
			Domain domain = Domain.ORDERITEM;
			assertTrue(domain.getDescription().toLowerCase().contains("orderitem"));
		}
		
		@Test
		public void stopTest() {
			Domain domain = Domain.STOP;
			assertTrue(domain.getDescription().toLowerCase().contains("close"));
		}

	} 

