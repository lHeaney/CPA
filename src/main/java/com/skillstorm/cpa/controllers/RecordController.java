package com.skillstorm.cpa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.cpa.dtos.RecordDTO;
import com.skillstorm.cpa.services.RecordService;
import com.skillstorm.cpa.models.Record;


@RestController
@RequestMapping("/records")
public class RecordController {
	
	private Logger logger = LoggerFactory.getLogger(RecordController.class);
	
	private RecordService service;
	
	public RecordController(RecordService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Record>> findAll(@RequestParam(required = false) String type) {
		logger.atInfo().log("Get request for records matching: "+type);
		return service.findAll(type);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Record> findById(@PathVariable int id) {
		logger.atInfo().log("Get request for records id= "+id);
		return service.findById(id);
	}
	@PostMapping
	public ResponseEntity<Record> createOne(@RequestBody RecordDTO recordDTO) {
		logger.atInfo().log("Post request to create a new record: "+recordDTO.toString());
		return service.createOne(recordDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Record> updateOne(@PathVariable int id, @RequestBody RecordDTO recordDTO) {
		logger.atInfo().log("Put request to update a record: "+recordDTO.toString());
		return service.updateOne(id, recordDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		logger.atInfo().log("Delete request to delete a record id= "+id);
		return service.deleteById(id);
	}
	
	
	
	
	
	

}
