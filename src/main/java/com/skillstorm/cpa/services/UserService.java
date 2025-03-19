package com.skillstorm.cpa.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.cpa.dtos.UserDTO;
import com.skillstorm.cpa.models.User;
import com.skillstorm.cpa.repositories.UserRepository;



@Service
public class UserService {
	
	private UserRepository repo;

	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<User>> findAll(String type) {
		
		Iterable<User> users;
		if (type == null) {
			users = repo.findAll();
		} else {
			users = repo.findAllByType(type);
		}
		
		if (!users.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users);
		else
			return ResponseEntity.status(HttpStatus.OK).body(users);
		
	}
	
	public ResponseEntity<User> findById(int id) {
		Optional<User> user = repo.findById(id);
		
		if (user.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(user.get());
	}

	public ResponseEntity<User> createOne(UserDTO userDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new User(0, userDTO.userName(), userDTO.password(), userDTO.license())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<User> updateOne(int id, UserDTO userDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					.body(repo.save(new User(0, userDTO.userName(), userDTO.password(), userDTO.license())));
		else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	// delete one
	public ResponseEntity<Void> deleteById(int id) {
		try {
			repo.deleteById(id); 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	
	
	
	
	
	

}
