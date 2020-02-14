package com.qa.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Items;
import com.qa.services.CrudItemsServices;

import utils.Utils;

public class ItemsController implements CrudItemsController<Items>{

	public static final Logger LOGGER = Logger.getLogger(ItemsController.class);

	private CrudItemsServices<Items> itemsServices;


	public ItemsController(CrudItemsServices<Items> itemsServices) {
		this.itemsServices = itemsServices;
	}

	public String getInput() {
		return Utils.getInput();
	} 

	public Items create() {
		LOGGER.info("Please enter your item");
		String item = Utils.getInput();
		LOGGER.info("Please enter your value");
		Double value = Double.parseDouble(Utils.getInput()) ;
//		LOGGER.info("Please enter your item quantity");
//		Long quantity = Long.valueOf(getInput());
		Items items = itemsServices.create(new Items(item, value));
		LOGGER.info("item created");
		return items;
	}
 	
	public List<Items> readAll() {
		List<Items> items = itemsServices.readAll();
		for (Items item : items) {
			LOGGER.info(item.toString());

		}
		return items;
	}
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter your new item");
		String item = Utils.getInput();
		LOGGER.info("Please enter your new value");
		Double itemValue =Double.parseDouble(Utils.getInput()) ;
//		LOGGER.info("Please enter your new item quantity");
//		Long value = Long.valueOf(getInput());
		Items items = itemsServices.update(new Items(id, item, itemValue));
		LOGGER.info("item updated");
		return items;
	}
   
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		itemsServices.delete(id);
	}

}
