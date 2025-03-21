package com.skillstorm.cpa.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.cpa.controllers.RecordController;
import com.skillstorm.cpa.dtos.RecordDTO;
import com.skillstorm.cpa.models.Record;
import com.skillstorm.cpa.repositories.RecordRepository;



@Service
public class RecordService {
	private Logger logger = LoggerFactory.getLogger(RecordService.class);
	
	private RecordRepository repo;

	public RecordService(RecordRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Record>> findAll(String type) {
		logger.info("Service looking for all records matching:"+type+"...");
		
		//We make an Iterable of Records
		//We do not need a more specific structure than Iterable, though it is almost certain we will be getting back arrays due to receiving JSON data
		Iterable<Record> records;
		//here we check type: if we received nothing or a null value, we just return all
		//This is not secure, but security cannot be implemented without user implementation which was cut due to time constraints
		//Otherwise, we filter get the records matching the type
		//To be clear, in this instance the type is the username. This was part of the defunct attempt to implement multiple users
		if (type == null) {
			records = repo.findAll();
		} else {
			records = repo.findAllByType(type);
		}
		
		if (!records.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(records);
		else
			return ResponseEntity.status(HttpStatus.OK).body(records);
		
	}
	
	//This is our method to get a records. Given an ID, we ask for the record matching it
	public ResponseEntity<Record> findById(int id) {
		Optional<Record> record = repo.findById(id);
		
		//if the record id is not found, we return "not found". otherwise we return the record
		if (record.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(record.get());
	}

	//This  is our method to create a new record. If there is any issue (such as connection issues with the database),
	//We return a 500-server error response
	public ResponseEntity<Record> createOne(RecordDTO recordDTO) { 

		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Record(0, recordDTO.owner(), recordDTO.type(), recordDTO.total_revenue(), recordDTO.taxes_owed(), recordDTO.taxes_paid(), recordDTO.status())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	//This is our method to update a record given the id and the values to place in it
	public ResponseEntity<Record> updateOne(int id, RecordDTO recordDTO) {
		//if the record exists, we update. We do not create a record if no record existed
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					.body(repo.save(new Record(id,  recordDTO.owner(), recordDTO.type(), recordDTO.total_revenue(), recordDTO.taxes_owed(), recordDTO.taxes_paid(), recordDTO.status())));
		else
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	
	// This method deletes a record from the database.
	//We do not return a body, only an HTTP code for success or failure
	public ResponseEntity<Void> deleteById(int id) {
		try {
			repo.deleteById(id); 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	
	
	
	
	
	

}
