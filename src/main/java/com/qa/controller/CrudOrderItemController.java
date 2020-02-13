package com.qa.controller;

import java.util.List;

import com.qa.persistence.domain.OrderItems;
//import com.qa.persistence.domain.Orders;

public interface CrudOrderItemController<T> {

	     OrderItems create ();
		
		public List<OrderItems> readAll();
		
		OrderItems update();
		
		void delete();
}
