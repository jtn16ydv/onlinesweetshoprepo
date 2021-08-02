package com.onlinesweetshopapi.web;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.onlinesweetshopapi.domain.Customer;
import com.onlinesweetshopapi.exception.CustomerIdException;
import com.onlinesweetshopapi.service.CustomerService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =CustomerController.class)
class CustomerControllerTest {


	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	
	@Test
	void test_getCustomerByCustomerIdentifier() throws Exception{
		BDDMockito.given(customerService.findCustomerByCustomerId(Mockito.anyString())).willReturn(new Customer("Jatin", "Cust16", "XYZ","jatin@gmail.com",0));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/customer/CUST16"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isMap())
				.andExpect(jsonPath("customerId").value("CUST16"));
	}
	
	@Test
	void test_getCustomerByCustomerIdentifier_ThrowCustomerIDException() throws Exception
	{
		BDDMockito.given(customerService.findCustomerByCustomerId(Mockito.anyString())).willThrow(new CustomerIdException());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/customer/CUST6"))
		.andExpect(status().isBadRequest());
	}
	

}
