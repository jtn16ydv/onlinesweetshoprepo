package com.onlinesweetshopapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	/**
	 * find customer by customer id
	 * 
	 * @param customerId
	 * @return customer
	 */
	Customer findByCustomerId(String customerId);
	
}
