package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.ItemDAO;
import com.qa.persistence.domain.Items;

public class ItemServices implements CrudItemsServices<Items> {
	ItemDAO<Items> itemDAO;

	public ItemServices(ItemDAO<Items> itemDAO) {
		this.itemDAO = itemDAO;
	}

	public Items create(Items item) {
		return itemDAO.create(item);
	}

	public List<Items> readAll() {
		return itemDAO.readAll();

	}

	public Items update(Items item) {
		return itemDAO.update(item);
	}

	public void delete(Long id) {
		itemDAO.delete(id);
	}
} 