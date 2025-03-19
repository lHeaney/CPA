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

import com.skillstorm.cpa.dtos.UserDTO;
import com.skillstorm.cpa.models.User;
import com.skillstorm.cpa.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<User>> findAll(@RequestParam(required = false) String type) {
		return service.findAll(type);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> findById(@PathVariable("userid") int id) {
		return service.findById(id);
	}
	@PostMapping
	public ResponseEntity<User> createOne(@RequestBody UserDTO userDTO) {
		return service.createOne(userDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateOne(@PathVariable int id, @RequestBody UserDTO userDTO) {
		return service.updateOne(id, userDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	
	
	
	
	

}
