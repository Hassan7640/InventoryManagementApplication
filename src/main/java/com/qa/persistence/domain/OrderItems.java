package com.qa.persistence.domain;

public class OrderItems {
	private Long id;

	private String itemOrdered;
	private Long itemQuantity;
	private Long orderId;
	private Long itemId;

	public OrderItems(Long id, Long itemQuantity) {
		this.id = id;
		this.itemQuantity = itemQuantity;
	}

	public OrderItems(Long id,/* String itemOrdered, Long itemQuantity, */ Long orderId, Long itemId) {
		this.id = id;
//		this.itemOrdered=itemOrdered;
//		this.itemQuantity = itemQuantity;
		this.orderId = orderId;
		this.itemId = itemId;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItemOrdered() {
		return itemOrdered;
	}

	public void setItemOrdered(String itemOrdered) {
		this.itemOrdered = itemOrdered;
	}
 

	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public String toString() {
		
		return " id : " +id+ "ItemQuantity : " + itemQuantity + " OrderId: " + orderId+ "ItemId: " + itemId;
	}

}
