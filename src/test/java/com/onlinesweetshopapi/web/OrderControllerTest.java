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

import com.onlinesweetshopapi.domain.Order;
import com.onlinesweetshopapi.exception.OrderIdException;
import com.onlinesweetshopapi.service.OrderService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =OrderController.class)
class OrderControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private OrderService orderService;
	
	@MockBean
	private MapValidationErrorService mapValidationErrorService;


	@Test
	void test_getOrderByOrderIdentifier() throws Exception{
		BDDMockito.given(orderService.findOrderByOrderId(Mockito.anyString())).willReturn(new Order("JAT16","cash", "ORD12","Alwar", "SWT16","1kg Barfi","Order Placed"));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/orders/ORD12"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isMap())
				.andExpect(jsonPath("orderId").value("ORD12"));
	}
	
	@Test
	void test_getOrderByOrderId_ThrowOrderIDException() throws Exception
	{
		BDDMockito.given(orderService.findOrderByOrderId(Mockito.anyString())).willThrow(new OrderIdException());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/orders/ORD12"))
		.andExpect(status().isBadRequest());
	}
	

}
