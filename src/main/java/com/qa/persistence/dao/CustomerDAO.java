package com.qa.persistence.dao;

import java.util.List;

import com.qa.persistence.domain.Customer;


public interface CustomerDAO<T>{
	
	 Customer create(Customer customer);
	
     List<T> readAll();
	
    Customer update(Customer customer);
	
    void delete(long id);
    
   

}
