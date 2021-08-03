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
import com.onlinesweetshopapi.domain.Sweet;
import com.onlinesweetshopapi.exception.SweetIDException;
import com.onlinesweetshopapi.service.OrderService;
import com.onlinesweetshopapi.service.SweetService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =OrderController.class)
class SweetsControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private SweetService sweetService;
	
	@MockBean
	private OrderService orderService;
	
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	
	@Test
	void test_getSweetBySweetIdentifier() throws Exception{
		BDDMockito.given(sweetService.findSweetBySweetIdentifier(Mockito.anyString())).willReturn(new Sweet("Petha","ST15","CT01","OFF23",50,508));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/sweets/ST15"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isMap())
				.andExpect(jsonPath("sweetIdentifier").value("ST15"));
	}
	
	@Test
	void test_getSweetBySweetId_ThrowOrderIDException() throws Exception
	{
		BDDMockito.given(sweetService.findSweetBySweetIdentifier(Mockito.anyString())).willThrow(new SweetIDException());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/sweets/ST15"))
		.andExpect(status().isBadRequest());
	}
	

}
