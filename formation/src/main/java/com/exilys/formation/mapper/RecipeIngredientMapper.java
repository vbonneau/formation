package com.exilys.formation.mapper;

import org.springframework.stereotype.Component;

import com.exilys.formation.dto.RecipeIngredientDto;
import com.exilys.formation.entity.RecipeIngredient;

@Component
public class RecipeIngredientMapper {

	private IngredientMapper ingredientMapper;
	
	public RecipeIngredientMapper(IngredientMapper ingredientMapper) {
		this.ingredientMapper = ingredientMapper;
	}
	
	public RecipeIngredient dtoToRecipeIngredient(RecipeIngredientDto recipeIngredientDto) {
		RecipeIngredient recipeIngredient = new RecipeIngredient();
		recipeIngredient.setId(recipeIngredientDto.getId());
		recipeIngredient.setIngredient(ingredientMapper.dtoToIngredient(recipeIngredientDto.getIngredientDto()));
		recipeIngredient.setQuantity(recipeIngredientDto.getQuantity());
		recipeIngredient.setUnit(recipeIngredientDto.getUnit());
		return recipeIngredient;
	}
	
	public RecipeIngredientDto recipeIngredientToDto(RecipeIngredient RecipeIngredient) {
		RecipeIngredientDto recipeIngredientDto = new RecipeIngredientDto();
		recipeIngredientDto.setId(RecipeIngredient.getId());
		recipeIngredientDto.setIngredientDto(ingredientMapper.ingredientToDto(RecipeIngredient.getIngredient()));
		recipeIngredientDto.setQuantity(RecipeIngredient.getQuantity());
		recipeIngredientDto.setUnit(RecipeIngredient.getUnit());
		return recipeIngredientDto;
	}
}
