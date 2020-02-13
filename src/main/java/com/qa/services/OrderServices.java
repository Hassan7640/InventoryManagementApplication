package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.OrderDAO;
import com.qa.persistence.domain.Orders;

public class OrderServices implements CrudOrderServices<Orders> {
	OrderDAO<Orders> orderDAO;

	public OrderServices(OrderDAO<Orders> orderDAO) {
		this.orderDAO = orderDAO;
	}

	public Orders create(Orders order) {
		return orderDAO.create(order);
	}

	public List<Orders> readAll() {
		return orderDAO.readAll();

	}

	public Orders update(Orders order) {
		return orderDAO.update(order);
	}

	public void delete(Long id) {
		orderDAO.delete(id);
	}
}
 