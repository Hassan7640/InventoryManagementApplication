package com.qa.persistence.dao;

import java.util.List;

//import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Items;

public interface ItemDAO<T> {
	
	Items create (Items items);
	
	List<T> readAll();
	
    Items update(Items items);
    
    void delete(long id);


}
