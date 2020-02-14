package com.qa.services;

import java.util.List;

import com.qa.persistence.domain.OrderItems;

public interface CrudOrderItemServices <T> {
  
	OrderItems create(T t); 
	
	public List<OrderItems> readAll();
	
	OrderItems update (OrderItems orderItems);
	
	void delete (Long id);
}
