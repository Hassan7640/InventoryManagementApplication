package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.CustomerDAO;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudCustomerServices <Customer>/*, CustomerId<Customer >*/ {
	
	CustomerDAO<Customer> customerDAO;
	
    public CustomerServices (CustomerDAO <Customer> customerDAO) {
    	this.customerDAO = customerDAO;
    }
    
    public Customer create (Customer customer) {
     	return customerDAO.create(customer);
    }
   
    public List <Customer> readAll(){
    	return customerDAO.readAll();
    	
    }
  
    public Customer update ( Customer customer) {
    	return customerDAO.update( customer);
    }
    
    public void delete (Long id) {
    	customerDAO.delete(id);
    }
}



