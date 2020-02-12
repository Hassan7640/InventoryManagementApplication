package com.qa.controller;

import java.util.List;

import com.qa.persistence.domain.Items;

public interface CrudItemsController <T>{

	Items create ();
	
	public List<Items> readAll();
	
	Items update();
	
	void delete();
}
