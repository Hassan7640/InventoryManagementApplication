package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.OrderItems;
import com.qa.services.CrudOrderItemServices;

import utils.Utils;

public class OrderItemController implements CrudOrderItemController<OrderItems> {

	public static final Logger LOGGER = Logger.getLogger(OrdersController.class);

	private CrudOrderItemServices<OrderItems> orderItemServices;


	public OrderItemController(CrudOrderItemServices<OrderItems> orderItemServices) {
		this.orderItemServices = orderItemServices;
	}

	String getInput() {
		return Utils.getInput();
	}
	 
	public OrderItems create() {
		LOGGER.info("Please enter your order id");
		Long orderId = Long.valueOf(Utils.getInput());
		LOGGER.info("Please enter your item id");
		Long itemId = Long.valueOf(getInput()) ;
	    OrderItems orders = orderItemServices.create(new OrderItems(orderId, itemId));
		LOGGER.info("orders created");
		return orders;
	}

	public List<OrderItems> readAll() {
		List<OrderItems> orders = orderItemServices.readAll();
		for (OrderItems order : orders) {
			LOGGER.info(order.toString());

		}
		return orders;
	}
	public OrderItems update() {
		LOGGER.info("Please enter the id of the order you would like to update ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter your new order id for your order");
		Long orderId = Long.valueOf(Utils.getInput());
		LOGGER.info("Please enter your up-to-date item_id");
		Long itemId = Long.valueOf(Utils.getInput());
//		LOGGER.info("Please enter your up-to-date order");
//		Long custsId = Long.valueOf(Utils.getInput());
		OrderItems orders = orderItemServices.update(new OrderItems(id, orderId, itemId));
		LOGGER.info("orders updated");
		return orders;
	}

	public void delete() {
		LOGGER.info("Please enter the item in the order you would like to delete");
		Long id = Long.valueOf(getInput());
		orderItemServices.delete(id);
	}
}
