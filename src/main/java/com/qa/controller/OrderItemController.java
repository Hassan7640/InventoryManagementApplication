//package com.qa.controller;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.qa.persistence.domain.Orders;
//import com.qa.services.CrudOrderServices;
//
//import utils.Utils;
//
//public class OrderItemController {
//
//	public static final Logger LOGGER = Logger.getLogger(OrdersController.class);
//
//	private CrudOrderServices<Orders> ordersServices;
//
//
//	public OrdersController(CrudOrderServices<Orders> ordersServices) {
//		this.ordersServices = ordersServices;
//	}
//
//	String getInput() {
//		return Utils.getInput();
//	}
//	
//	public Orders create() {
//		LOGGER.info("Please enter your order cost");
//		Double orderCost = Double.parseDouble(Utils.getInput());
//		LOGGER.info("Please enter your customer id");
//		Long custId = Long.valueOf(getInput()) ;
//	    Orders orders = ordersServices.create(new Orders(orderCost, custId));
//		LOGGER.info("orders created");
//		return orders;
//	}
//
//	public List<Orders> readAll() {
//		List<Orders> orders = ordersServices.readAll();
//		for (Orders order : orders) {
//			LOGGER.info(order.toString());
//
//		}
//		return orders;
//	}
//	public Orders update() {
//		LOGGER.info("Please enter the id of the order you would like to update ");
//		Long id = Long.valueOf(getInput());
//		LOGGER.info("Please enter your new cost for your order");
//		Double orderCost = Double.parseDouble(Utils.getInput());
//		LOGGER.info("Please enter your up-to-date order");
//		Long custId = Long.valueOf(Utils.getInput());
//		Orders orders = ordersServices.update(new Orders(id, orderCost, custId));
//		LOGGER.info("orders updated");
//		return orders;
//	}
//
//	public void delete() {
//		LOGGER.info("Please enter the item in the order you would like to delete");
//		Long id = Long.valueOf(getInput());
//		ordersServices.delete(id);
//	}
//}
