package com.myth.accessrecipewithJPA.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable=false, length=200)
	private String name;
	
	@ElementCollection
	@CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
	private List<String> ingredients;
	
	@ElementCollection
	@CollectionTable(name = "recipe_instructions", joinColumns = @JoinColumn(name = "recipe_id"))
	private List<String> instructions;
	
	
	protected Recipe() {}
	
	public Recipe(UUID id, String name, List<String> ingredients, List<String> instructions) {
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	

}
