package com.qa.persistence.dao;

import java.util.List;

import com.qa.persistence.domain.Orders;

public interface OrderDAO<T> {

	Orders create(Orders orders);

	List<T> readAll();

	Orders update(Orders orders);

	void delete(long id);

}
