package com.exilys.formation.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.exilys.formation.dto.RecipeDto;
import com.exilys.formation.dto.RecipeIngredientDto;
import com.exilys.formation.entity.Recipe;
import com.exilys.formation.entity.RecipeIngredient;

@Component
public class RecipeMapper {
	private RecipeIngredientMapper recipeIngredientMapper;

	public RecipeMapper(RecipeIngredientMapper recipeIngredientMapper) {
		this.recipeIngredientMapper = recipeIngredientMapper;
	}

	public Recipe dtoToRecipe(RecipeDto recipeDto) {
		Recipe recipe = new Recipe();
		recipe.setId(recipeDto.getId());
		recipe.setName(recipeDto.getName());
		recipe.setPicture(recipeDto.getPicture());
		recipe.setDescription(recipeDto.getDescription());
		List<RecipeIngredientDto> recipeIngredientDtos  = recipeDto.getIngredients();
		List<RecipeIngredient> recipeIngredients = recipeIngredientDtos.stream()
				.map(recipeIngredientDto -> recipeIngredientMapper.dtoToRecipeIngredient(recipeIngredientDto))
				.collect(Collectors.toList());
		recipe.setIngredients(new HashSet<RecipeIngredient>(recipeIngredients));
		recipe.setInstructions(new HashSet<String>(recipeDto.getInstructions()));
		return recipe;
	}

	public RecipeDto recipeToDto(Recipe recipe) {
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setId(recipe.getId());
		recipeDto.setName(recipe.getName());
		recipeDto.setPicture(recipe.getPicture());
		recipeDto.setDescription(recipe.getDescription());
		List<RecipeIngredient> recipeIngredients = new ArrayList<RecipeIngredient>(recipe.getIngredients());
		List<RecipeIngredientDto> ingredientDtos = recipeIngredients.stream()
				.map(recipeIngredient -> recipeIngredientMapper.recipeIngredientToDto(recipeIngredient))
				.collect(Collectors.toList());
		recipeDto.setIngredients(ingredientDtos);
		recipeDto.setInstructions(new ArrayList<String>(recipe.getInstructions()));
		return recipeDto;
	}

}
