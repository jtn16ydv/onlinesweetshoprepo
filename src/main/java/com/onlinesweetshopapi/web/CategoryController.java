package com.onlinesweetshopapi.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetshopapi.domain.Category;
import com.onlinesweetshopapi.exception.SweetIDException;
import com.onlinesweetshopapi.service.CategoryService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/Categories")
public class CategoryController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public Iterable<Category> getSweets(){
		logger.info("Catagories List is shown");
		return categoryService.getCategories();
	}
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/add")
	public ResponseEntity<?> createCategory(@Valid @RequestBody Category category,BindingResult bindingResult)
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(bindingResult);
		if (errorMap != null)
		{
			logger.error("Error in adding category");
			return errorMap;
		}
		Category category2 = categoryService.save(category);
		return new ResponseEntity<Category>(category2, HttpStatus.CREATED); 
	}
	@GetMapping("/{categoryIdentifier}")
	public ResponseEntity<?> getCategoryByCategoryIdentifier(@PathVariable String categoryIdentifier){
		
		Category category= categoryService.findCategoryByCategoryIdentifier(categoryIdentifier);
		if(category==null) {
			logger.error("Error in fetching category");
			throw new SweetIDException("Category " +categoryIdentifier+" does not exist"); 
		}
		logger.info("Catagories is fetch");
		return new ResponseEntity<Category>(category,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{categoryIdentifier}")
	public ResponseEntity<?> deleteCategory(@PathVariable String categoryIdentifier){
		categoryService.deleteCategoryByCategoryIdentifier(categoryIdentifier);
		logger.info("Deleted the category");
		return new ResponseEntity<String>(categoryIdentifier+" deleted sucessfully",HttpStatus.OK);
		
	}
	
	
}
