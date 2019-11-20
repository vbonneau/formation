package com.exilys.formation.dto;

public class RecipeIngredientDto {
	
	private Long id;
	private IngredientDto ingredientDto;
	private Long quantity;
	private String unit;
	
	public Long getId() {
		return id;
	}
	public IngredientDto getIngredientDto() {
		return ingredientDto;
	}
	public Long getQuantity() {
		return quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIngredientDto(IngredientDto ingredientDto) {
		this.ingredientDto = ingredientDto;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
