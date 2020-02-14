package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.OrderItemDAO;
import com.qa.persistence.domain.OrderItems;

public class OrderItemServices implements CrudOrderItemServices<OrderItems>{

	OrderItemDAO<OrderItems> orderItemDAO;

	public OrderItemServices(OrderItemDAO<OrderItems> orderItemDAO) {
		this.orderItemDAO = orderItemDAO;
	}

	public OrderItems create(OrderItems orderItem) {
		return orderItemDAO.create(orderItem);
	}

	public List<OrderItems> readAll() {
		return orderItemDAO.readAll();

	}

	public OrderItems update(OrderItems orderItem) {
		return orderItemDAO.update(orderItem);
	}

	public void delete(Long id) {
		orderItemDAO.delete(id);
	}
}
 