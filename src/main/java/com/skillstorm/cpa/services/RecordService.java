package com.skillstorm.cpa.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.cpa.dtos.RecordDTO;
import com.skillstorm.cpa.models.Record;
import com.skillstorm.cpa.repositories.RecordRepository;



@Service
public class RecordService {
	
	private RecordRepository repo;

	public RecordService(RecordRepository repo) {
		this.repo = repo;
	}
	
	public ResponseEntity<Iterable<Record>> findAll(String type) {
		
		Iterable<Record> records;
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
	
	public ResponseEntity<Record> findById(int id) {
		Optional<Record> record = repo.findById(id);
		
		if (record.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(record.get());
	}

	public ResponseEntity<Record> createOne(RecordDTO recordDTO) { 

		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Record(0, recordDTO.owner(), recordDTO.type(), recordDTO.total_revenue(), recordDTO.taxes_owed(), recordDTO.taxes_paid(), recordDTO.status())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	public ResponseEntity<Record> updateOne(int id, RecordDTO recordDTO) {
		if (repo.existsById(id))
			return ResponseEntity.status(HttpStatus.OK)
					.body(repo.save(new Record(id,  recordDTO.owner(), recordDTO.type(), recordDTO.total_revenue(), recordDTO.taxes_owed(), recordDTO.taxes_paid(), recordDTO.status())));
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
