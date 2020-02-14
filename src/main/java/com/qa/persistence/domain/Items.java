package com.qa.persistence.domain;

public class Items {

	private Long id;
	
	private String itemName;
	

	private Double itemValue;
//	public Items( Long id) {
//		
//		
//		this.id=id;
//	}

	
	public Items(String itemName, Double itemValue) {
//		this.itemQuantity=itemQuantity;
		this.itemName=itemName;
		this.itemValue=itemValue;
	}

	
	 
	public Items(Long id, String itemName, Double itemValue) {
		this.id=id;
		this.itemName=itemName;
		this.itemValue=itemValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
	public double getItemValue() {
		return itemValue;
	}

	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}
	
	public String toString() {
		return "id: " +id + " itemName: " +itemName+ " itemValue: " + itemValue;
	}
}
