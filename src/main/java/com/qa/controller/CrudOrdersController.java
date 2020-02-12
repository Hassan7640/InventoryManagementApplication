package com.qa.controller;

import java.util.List;

import com.qa.persistence.domain.Orders;

public interface CrudOrdersController<T> {

    Orders create ();
	
	public List<Orders> readAll();
	
	Orders update();
	
	void delete();
}
