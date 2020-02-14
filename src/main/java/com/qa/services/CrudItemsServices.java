package com.qa.services;

import java.util.List;

import com.qa.persistence.domain.Items;

public interface CrudItemsServices<T> {

	Items create(T t);

	public List<Items> readAll();

	Items update(Items item);

	void delete(Long id);
}
