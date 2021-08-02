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
import com.onlinesweetshopapi.domain.Sweet;
import com.onlinesweetshopapi.exception.SweetIDException;
import com.onlinesweetshopapi.service.SweetService;
import com.onlinesweetshopapi.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/sweets")
public class SweetContoller {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private SweetService sweetService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
		
	@GetMapping("/list")
	public Iterable<Sweet> getSweets(){
		logger.info("Sweet List is fetch");
		return sweetService.getSweets();
	}

	@PostMapping("/add")
	public ResponseEntity<?> createSweet(@Valid @RequestBody Sweet sweet, BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) 
		{
			logger.error("Error in adding Sweet");
			return errorMap;
		
		}
		Sweet sweet2 = sweetService.save(sweet);
		logger.info("Sweet is saved");
		return new ResponseEntity<Sweet>(sweet2, HttpStatus.CREATED);
	}
	
	@GetMapping("/{sweetIdentifier}")
	public ResponseEntity<?> getSweetBySweetIdentifier(@PathVariable String sweetIdentifier){
		
		Sweet sweet= sweetService.findSweetBySweetIdentifier(sweetIdentifier);
		if(sweet==null) {
			logger.error("Sweet data is not fetch");
			throw new SweetIDException("Sweet Identifier " +sweetIdentifier.toUpperCase()+" does not exist"); 
		}
		logger.info("Sweet data is not fetched");
		return new ResponseEntity<Sweet>(sweet,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{sweetIdentifier}")
	public ResponseEntity<?> deleteSweet(@PathVariable String sweetIdentifier){
		sweetService.deleteSweetBySweetIdentifier(sweetIdentifier);
		logger.info("Sweet is deleted");
		return new ResponseEntity<String>(sweetIdentifier.toUpperCase()+" deleted sucessfully",HttpStatus.OK);
	}
	

}
