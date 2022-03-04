package com.myth.accessrecipewithJPA.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myth.accessrecipewithJPA.entity.Recipe;
import com.myth.accessrecipewithJPA.repository.RecipeRepository;


@Service (value="rs")
@Transactional
public class RecipeServiceImpl implements RecipeService {
	
	 RecipeRepository recipeRepository;
	
	
	@Autowired
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Optional<Recipe> addRecipe(Recipe recipe) {
		List<Recipe> isRecipeAvailable=findRecipeByName(recipe.getName());
		if(isRecipeAvailable.isEmpty()) 
			recipe = recipeRepository.save(recipe);
		else
			recipe=null;
		Optional<Recipe> opt = Optional.ofNullable(recipe);
	    return opt;
	}

	@Override
	public List<Recipe> findAllRecipe() {
		Iterable <Recipe> allRecipes = recipeRepository.findAll();
		return (List<Recipe>) allRecipes;
	}

	@Override
	public List<Recipe> findRecipeByName(String name) {
		List<Recipe> recipesByName = recipeRepository.findByName(name);
		return recipesByName;
	}

	@Override
	public List<String> findAvailableRecipeName() {
		List<String> availableRecipesNames = recipeRepository.findAvailableRecipeNames();
		return availableRecipesNames;
	}

	@Override
	public List<Recipe> updateRecipe(String name) {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Override
//	public List<String> getIngredientsForRecipe(String name) {
//		recipeRepository.findByName(name);
//		List<String> getIngredientsForRecipe = recipeRepository.getIngredientsForRecipe( name);
//		return getIngredientsForRecipe;
//	}
		

}
