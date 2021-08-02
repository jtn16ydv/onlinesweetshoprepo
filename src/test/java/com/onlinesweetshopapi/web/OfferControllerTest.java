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

import com.onlinesweetshopapi.domain.Offer;
import com.onlinesweetshopapi.exception.OfferIdException;
import com.onlinesweetshopapi.service.OfferService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =OfferController.class)
class OfferControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private OfferService offerService;
	
	@MockBean
	private MapValidationErrorService mapValidationErrorService;


	@Test
	void test_getAdminByCustomerIdentifier() throws Exception{
		BDDMockito.given(offerService.findOfferByOfferId(Mockito.anyString())).willReturn(new Offer("OFF15","Diwali",50));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/offers/OFF15"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isMap())
				.andExpect(jsonPath("offerId").value("OFF15"));
	}
	
	@Test
	void test_getAdminByAdminIdentifier_ThrowAdminIDException() throws Exception
	{
		BDDMockito.given(offerService.findOfferByOfferId(Mockito.anyString())).willThrow(new OfferIdException());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/offers/OFF15"))
		.andExpect(status().isBadRequest());
	}
	
}
