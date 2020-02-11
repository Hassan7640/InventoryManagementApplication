package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.DAO;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices <Customer>/*, CustomerId<Customer >*/ {
	
	DAO<Customer> customerDAO;
	
    public CustomerServices (DAO <Customer> customerDAO) {
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



