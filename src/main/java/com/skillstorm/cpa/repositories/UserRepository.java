package com.skillstorm.cpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.cpa.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM users WHERE user_type = ?1", nativeQuery = true)
	public Iterable<User> findAllByType(String username);
}
