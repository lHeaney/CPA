package com.skillstorm.cpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.cpa.models.Record;
import com.skillstorm.cpa.models.User;


@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
	
	//This is the SQL query where we get the list of records with a particular owner. It is not implemented, and we part of the multiple users implementation
	
	@Query(value = "SELECT * FROM records WHERE owner = ?1", nativeQuery = true)
	public Iterable<Record> findAllByType(String owner);
	
}
