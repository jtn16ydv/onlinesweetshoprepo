package com.onlinesweetshopapi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetshopapi.domain.Event;
import com.onlinesweetshopapi.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private EventService eventService;
	
	@PostMapping
	public ResponseEntity<Event> createEvent(@Validated @RequestBody Event event){
		Event createdEvent= eventService.saveOrUpdate(event);
		logger.info("Event added/updated sucessfully");
		return new ResponseEntity<Event>(createdEvent, HttpStatus.CREATED);
	}

}