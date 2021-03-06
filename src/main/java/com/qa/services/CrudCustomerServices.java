package com.qa.services;

import java.util.List;

import com.qa.persistence.domain.Customer;

public interface CrudCustomerServices<T> {

	Customer create(Customer customer);

	public List<T> readAll();

	Customer update(Customer customer);

	void delete(Long id);

}
