package com.exilys.formation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exilys.formation.dao.RecipeDao;
import com.exilys.formation.dto.IngredientDto;
import com.exilys.formation.dto.RecipeDto;
import com.exilys.formation.entity.Recipe;
import com.exilys.formation.mapper.RecipeMapper;

@Service
public class RecipeService {

	private RecipeDao recipeDao;
	private RecipeMapper recipeMapper;

	public RecipeService(RecipeDao recipeDao, RecipeMapper recipeMapper) {
		this.recipeDao = recipeDao;
		this.recipeMapper = recipeMapper;
	}

	public void insertRecipe(RecipeDto recipeDto) {
		recipeDao.insertIngredient(recipeMapper.dtoToRecipe(recipeDto));
	}

	public List<RecipeDto> getAll() {
		List<Recipe> list = recipeDao.gatAll();
		return list.stream().map(recipe -> recipeMapper.recipeToDto(recipe))
				.collect(Collectors.toList());
	}
	
	public void deleteRecipe(RecipeDto recipeDto) {
		deleteRecipe(recipeDto.getId());
	}
	
	public void updateRecipe(RecipeDto recipeDto) {
		recipeDao.updateIngredient(recipeMapper.dtoToRecipe(recipeDto));
	}

	public RecipeDto getRecipe(long id) {
		return recipeMapper.recipeToDto(recipeDao.get(id));
		
	}
	
	public void deleteRecipe(long id) {
		Recipe recipe  = recipeDao.get(id);
		recipeDao.delete(recipe);
	}

	public void addIngredient(IngredientDto ingredientDto) {
		
		
	}
}
