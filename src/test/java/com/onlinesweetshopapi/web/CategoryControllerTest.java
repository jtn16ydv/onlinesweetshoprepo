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


import com.onlinesweetshopapi.domain.Category;
import com.onlinesweetshopapi.service.CategoryService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers =CategoryController.class)
class CategoryControllerTest {
	
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CategoryService categoryService;
	
	@MockBean
	private MapValidationErrorService mapValidationErrorService;
	
	@Test
	void test_getCategoryByCategoryIdentifier() throws Exception{
		BDDMockito.given(categoryService.findCategoryByCategoryIdentifier(Mockito.anyString())).willReturn(new Category("Sw01","ChocolateSweets"));
		mockMvc.perform(MockMvcRequestBuilders.get("/api/Categories/SW01"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isMap())
				.andExpect(jsonPath("categoryIdentifier").value("SW01"));
		
	}

}
