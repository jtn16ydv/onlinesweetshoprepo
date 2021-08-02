package com.onlinesweetshopapi.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void test_findByCustomerId() throws Exception {
		System.out.println("----test_findByAdminId------"+customerRepository);
	}
	
}
