package com.qa.services;

import java.util.List;

import com.qa.persistence.domain.Orders;

public interface CrudOrderServices <T>{
	
	Orders create (T t);
	
	public List<Orders> readAll();
	
	Orders update (Orders orders);
	
	void delete (Long id);

}
