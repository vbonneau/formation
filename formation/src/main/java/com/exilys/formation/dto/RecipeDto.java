package com.exilys.formation.dto;

import java.util.List;

public class RecipeDto {
	
	private Long id;
    private String name;
    private String picture;
    private String description;
    private List<RecipeIngredientDto> ingredients;
    private List<String> instructions;

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPicture() {
		return picture;
	}
	public String getDescription() {
		return description;
	}
	public List<RecipeIngredientDto> getIngredients() {
		return ingredients;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setIngredients(List<RecipeIngredientDto> ingredients) {
		this.ingredients = ingredients;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
}
