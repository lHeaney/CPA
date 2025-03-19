package com.skillstorm.cpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.cpa.models.Record;
import com.skillstorm.cpa.models.User;


@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
	
	@Query(value = "SELECT * FROM records WHERE username = ?1", nativeQuery = true)
	public Iterable<Record> findAllByType(String username);
	
}
