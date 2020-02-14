package com.qa.persistence.dao;

import java.util.List;

import com.qa.persistence.domain.OrderItems;

public interface OrderItemDAO <T> {
	
	OrderItems create(OrderItems orders);

	List<T> readAll();

	OrderItems update(OrderItems orders);

	void delete(long id);

}
