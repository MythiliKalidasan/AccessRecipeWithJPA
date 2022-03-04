package com.myth.accessrecipewithJPA.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.myth.accessrecipewithJPA.entity.Recipe;

public interface RecipeService {
	
	Optional<Recipe> addRecipe(Recipe recipe);
	
	List<Recipe> findAllRecipe(); 
	
	List<Recipe> findRecipeByName(String name);
	
	List<String> findAvailableRecipeName();
	
	List<Recipe> updateRecipe(String name);
//	
//	List<String> getIngredientsForRecipe(String name);

}
