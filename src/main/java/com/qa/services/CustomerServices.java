package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.DAO;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices <Customer>/*, CustomerId<Customer >*/ {
	
	DAO<Customer> customerDao;
	
    public CustomerServices (DAO <Customer> customerDao) {
    	this.customerDao = customerDao;
    }
    
    public Customer create (Customer customer) {
     	return customerDao.create(customer);
    }
   
    public List <Customer> readAll(){
    	return customerDao.readAll();
    	
    }
  
    public Customer update ( Customer customer) {
    	return customerDao.update( customer);
    }
    
    public void delete (Long id) {
    	customerDao.delete(id);
    }

	
}



//	@Override
//	public Long getCustId(Customer customer) {
//		// TODO Auto-generated method stub
//		return customerDao.getCustId(customer);
//	}

