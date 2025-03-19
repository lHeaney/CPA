package com.skillstorm.cpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.food.models.Ingredient;

/*
 * A repository interface will automatically provide a host of pre-baked methods we can use to interact with the corresponding table
 * We DO NOT need to spell these out BUT we can create custom methods as needed
 * 
 * This is a Component/Bean that we can inject elsewhere
 * The @Repository annotation sets this up as an injectable repo AND allows @ComponentScan to find it
 * We extend an existing repo type and provide this interface with a model type and the type of its primary key
 */

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
	
	// a custom Query to select Ingredients based on their ingredientType
	// if you have nativeQuery = true, you can write the query in regular ol' SQL syntax
	// you can plant in variables from the method parameters, with ?1, ?2, ?3, etc.
	// ?1 is the first parameter, and so on
	@Query(value = "SELECT * FROM ingredient WHERE ingredient_type = ?1", nativeQuery = true)
	public Iterable<Ingredient> findAllByType(String type);
}
