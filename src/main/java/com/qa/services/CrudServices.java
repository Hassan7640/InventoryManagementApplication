package com.qa.services;

import java.util.List;

import com.qa.persistence.domain.Customer;

public interface CrudServices<T> {

	Customer create(T t);

	public List<T> readAll();

	Customer update(Customer customer);

	void delete(Long id);

}
