package com.exilys.formation.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exilys.formation.dao.IngredientDao;
import com.exilys.formation.dao.RecipeDao;
import com.exilys.formation.dto.RecipeDto;
import com.exilys.formation.dto.RecipeIngredientDto;
import com.exilys.formation.entity.Ingredient;
import com.exilys.formation.entity.Recipe;
import com.exilys.formation.entity.RecipeIngredient;
import com.exilys.formation.mapper.RecipeMapper;

@Service
public class RecipeService {

	private RecipeDao recipeDao;
	private IngredientDao ingredientDao;
	private RecipeMapper recipeMapper;

	public RecipeService(RecipeDao recipeDao, RecipeMapper recipeMapper, IngredientDao ingredientDao) {
		this.recipeDao = recipeDao;
		this.recipeMapper = recipeMapper;
		this.ingredientDao = ingredientDao;
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
		deleteRecipe(getRecipe(recipeDto.getId()));
	}
	
	public void updateRecipe(RecipeDto recipeDto) {
		Recipe recipe = recipeMapper.dtoToRecipe(recipeDto);
		setupIngredients(recipe);
		recipeDao.updateIngredient(recipe);
	}

	public RecipeDto getRecipe(long id) {
		Recipe recipe = recipeDao.get(id);
		setupIngredients(recipe);
		return recipeMapper.recipeToDto(recipe);
		
	}
	
	public void deleteRecipe(long id) {
		Recipe recipe  = recipeDao.get(id);
		recipeDao.delete(recipe);
	}

	public void addIngredient(int id, RecipeIngredientDto recipeIngredientDto) {
		RecipeDto recipeDto = getRecipe(id);
		recipeDto.getIngredients().add(recipeIngredientDto);
		Recipe recipe = recipeMapper.dtoToRecipe(recipeDto);
		setupIngredients(recipe);
		
	}

	private void setupIngredients(Recipe recipe) {
		Set<RecipeIngredient> recipeIngredients = recipe.getIngredients();
		for(RecipeIngredient recipeIngredient : recipeIngredients) {
			ingredientDao.insertIngredient(recipeIngredient.getIngredient());
			Ingredient ingredient = ingredientDao.getIngredient(recipeIngredient.getIngredient().getId());
			recipeIngredient.setIngredient(ingredient);
		}
	}
}
