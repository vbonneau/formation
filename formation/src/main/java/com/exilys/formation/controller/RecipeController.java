package com.exilys.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exilys.formation.dto.IngredientDto;
import com.exilys.formation.dto.RecipeDto;
import com.exilys.formation.service.RecipeService;

@RestController
@RequestMapping
public class RecipeController {
	
	private RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping("/recipe")
	public List<RecipeDto> getAll() {
		return recipeService.getAll();
	}

	@PostMapping("/recipe")
	public void insert(@RequestBody RecipeDto recipeDto) {
		recipeService.insertRecipe(recipeDto);
	}
	
	@PutMapping("/recipe")
	public void update(@RequestBody RecipeDto recipeDto){
		recipeService.updateRecipe(recipeDto);
	}
	
	@DeleteMapping("/recipe")
	public void delete(@RequestBody RecipeDto recipeDto){
		recipeService.deleteRecipe(recipeDto);
	}
	
	@GetMapping("/recipe/{id}")
	public RecipeDto get(@PathVariable(value="id") int id){
		return recipeService.getRecipe(id);
	}
	
	@DeleteMapping("/recipe/{id}")
	public void delete(@PathVariable(value="id") int id){
		recipeService.deleteRecipe(id);
	}
	
	@PatchMapping("/recipe/ingredient")
	public void addIngredint(@RequestBody IngredientDto ingredientDto) {
		recipeService.addIngredient(ingredientDto);
	}

}
