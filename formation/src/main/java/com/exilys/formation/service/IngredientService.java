package com.exilys.formation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exilys.formation.dao.IngredientDao;
import com.exilys.formation.dto.IngredientDto;
import com.exilys.formation.entity.Ingredient;
import com.exilys.formation.mapper.IngredientMapper;

@Service
public class IngredientService {

	private IngredientDao ingredientDao;
	private IngredientMapper ingredientMapper;

	public IngredientService(IngredientDao ingredientDao, IngredientMapper ingredientMapper) {
		this.ingredientDao = ingredientDao;
		this.ingredientMapper = ingredientMapper;
	}

	public void insertIngredient(IngredientDto ingredientDto) {
		ingredientDao.insertIngredient(ingredientMapper.dtoToIngredient(ingredientDto));
	}

	public List<IngredientDto> getAll() {
		List<Ingredient> list = ingredientDao.gatAll();
		return list.stream().map(ingredient -> ingredientMapper.ingredientToDto(ingredient))
				.collect(Collectors.toList());
	}
	
	public void deleteIngredient(IngredientDto ingredientDto) {
		deleteIngredient(ingredientDto.getId());
	}
	
	public void updateIngredient(IngredientDto ingredientDto) {
		ingredientDao.updateIngredient(ingredientMapper.dtoToIngredient(ingredientDto));
	}

	public IngredientDto getIngredient(int id) {
		return ingredientMapper.ingredientToDto(ingredientDao.getIngredient(id));
		
	}
	
	public void deleteIngredient(long id) {
		Ingredient ingredient = ingredientDao.getIngredient(id);
		ingredientDao.deleteIngredient(ingredient);
	}
}
