package com.exilys.formation.mapper;

import org.springframework.stereotype.Component;

import com.exilys.formation.dto.IngredientDto;
import com.exilys.formation.entity.Ingredient;

@Component
public class IngredientMapper {

	public Ingredient dtoToIngredient(IngredientDto dto) {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(dto.getId());
		ingredient.setName(dto.getName());
		return ingredient;
	}
	
	public IngredientDto ingredientToDto(Ingredient ingredient) {
		IngredientDto dto = new IngredientDto();
		dto.setId(ingredient.getId());
		dto.setName(ingredient.getName());
		return dto;
	}
	
	
}
