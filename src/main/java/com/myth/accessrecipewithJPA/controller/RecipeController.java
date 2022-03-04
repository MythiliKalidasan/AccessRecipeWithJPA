package com.myth.accessrecipewithJPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myth.accessrecipewithJPA.entity.Recipe;
import com.myth.accessrecipewithJPA.service.RecipeService;

@RestController
@RequestMapping("recipe")
public class RecipeController {
	
	private RecipeService recipeService;

	@Autowired
	public RecipeController(@Qualifier("rs")RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}
	
	@PostMapping
	public ResponseEntity<Optional<Recipe>> addNewRecipe( @RequestBody Recipe recipe) {
		Optional<Recipe> addMyRecipe;
		addMyRecipe = recipeService.addRecipe(recipe);
		if(addMyRecipe.isEmpty())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		return ResponseEntity.status(HttpStatus.CREATED).body(addMyRecipe);
	  }
	
	@PutMapping
	public ResponseEntity<List<Recipe>> updateRecipe( @RequestBody Recipe recipe) {
		//Optional<Recipe> updateRecipe;
		 recipe=recipeService.updateRecipe(recipe.getName());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(recipe);
	  }
	
	@GetMapping 
	public ResponseEntity <List<String>> getAvailableRecipeNames(){
		List <String> availableRecipeNames= recipeService.findAvailableRecipeName();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(availableRecipeNames);
	}
	
	@GetMapping ("/all")
	public ResponseEntity <List<Recipe>> getAllRecipes(){
		List <Recipe> allRecipes= recipeService.findAllRecipe();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(allRecipes);
	}
	
	@GetMapping (path ="/{name}")
	public ResponseEntity <List<Recipe>>getVacationPlacesByCountry (
			@PathVariable(value="name")String name) {
		List <Recipe> recipesByName = recipeService.findRecipeByName(name);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(recipesByName);
	}
	
	
//	@GetMapping (path ="/details/{name}")
//	public ResponseEntity <List<String>>getIngredientsForRecipe (
//			@PathVariable(value="name")String name) {
//		List <String> ingredientsForRecipe = recipeService.getIngredientsForRecipe(name);
//		
//		return ResponseEntity.status(HttpStatus.FOUND).body(ingredientsForRecipe);
//	}

}
