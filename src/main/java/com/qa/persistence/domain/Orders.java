package com.qa.persistence.domain;

public class Orders {
	private Long id;
	private Long customerId;
   	private Double orderCost;
   	
   	public Orders (Double orderCost, Long customerId) {
		this.orderCost=orderCost;
		this.customerId=customerId;

	}
		
	public Orders (Long id, Double orderCost, Long customerId) {
		this.id=id;
		this.customerId=customerId;
		this.orderCost=orderCost;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public  double getOrderCost() {
		return orderCost;
	}
	
	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}

	public String toString() {
		return " id : " + id +  " orderCost: " + orderCost + " customerId: " + customerId;
	}



}
