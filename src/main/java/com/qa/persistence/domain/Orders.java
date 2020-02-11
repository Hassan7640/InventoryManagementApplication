package com.qa.persistence.domain;

public class Orders {
	private Long id;
	private Long customer_id;


	private float order_cost;
	
	public Orders (Long id, Long customer_id, float order_cost) {
		this.id=id;
		this.order_cost=order_cost;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public float getOrder_cost() {
		return order_cost;
	}
	
	public void setOrder_cost(float order_cost) {
		this.order_cost = order_cost;
	}


	

	


}
