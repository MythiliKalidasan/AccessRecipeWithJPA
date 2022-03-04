package com.myth.accessrecipewithJPA.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.myth.accessrecipewithJPA.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	
	List<Recipe> findByName(String name);
	
	@Query("SELECT rp.name FROM Recipe rp")
	List<String> findAvailableRecipeNames();
	
	
	
//	@Modifying
//	@Query("UPDATE Recipe rp SET rp.ingredients = :ingredients WHERE "
//	 		                           + "rp.id = :id")
//	List<Recipe> updateRecipe(@Param("id") UUID id, @Param("ingredients") String ingredients);
//	
//	@Query("SELECT rp.ingredients FROM Recipe rp WHERE rp.name = :name")
//	List<String> getIngredientsForRecipe(@Param("name")String name);

}
