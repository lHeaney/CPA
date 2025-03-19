package com.skillstorm.cpa.dtos;

import java.util.List;

import com.skillstorm.food.models.Recipe;

/*
 * A DTO (Data Transfer Object) is useful for moving data between client/server with less than a full object's worth of data
 * this object will only include ingredient values, NOT its id
 * 
 * A record is a very fast way of creating a class
 * The properties are immutable -- once initialized, they cannot be changed
 * However, with very little syntax, they have a constructor, a toString method, hashCode/equals, private properties with getters
 */

public record IngredientDTO(String ingredientName, String ingredientType, List<Recipe> recipes) {}
