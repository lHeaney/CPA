package com.skillstorm.cpa.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/*
 * this class represents an entity from our database
 * i.e., it corresponds to a single record from the Ingredient table
 */

// this specifies this class is a DB entity
// the second one maps it to a table; Hibernate will auto-find it if it matches, but it doesn't hurt to add it
@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id 				 									// specifies that this column is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// specifies that the DB will provide values for this column (auto-incremented)
	@Column(name = "id") 									// specifies which column this variable goes with
	private int id;
	
	@Column(name = "ingredient_name")
	private String ingredientName;
	
	@Column(name = "ingredient_type")
	private String ingredientType;
	
	@ManyToMany(mappedBy = "ingredients")
	@JsonIgnoreProperties("ingredients")
	private List<Recipe> recipes;
	
	// recommended to use the source menu to auto-generate constructors, getters/setters, toString, etc. to avoid conflicts/errors

	public Ingredient() {
		super();
	}

	public Ingredient(int id, String ingredientName, String ingredientType, List<Recipe> recipes) {
		super();
		this.id = id;
		this.ingredientName = ingredientName;
		this.ingredientType = ingredientType;
		this.recipes = recipes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getIngredientType() {
		return ingredientType;
	}

	public void setIngredientType(String ingredientType) {
		this.ingredientType = ingredientType;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredientName=" + ingredientName + ", ingredientType=" + ingredientType
				+ ", recipes=" + recipes + "]";
	}

}
