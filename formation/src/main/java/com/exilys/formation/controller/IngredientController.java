package com.exilys.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exilys.formation.dto.IngredientDto;
import com.exilys.formation.service.IngredientService;

@RestController
@RequestMapping
public class IngredientController {
	
	private IngredientService ingredientService;
	
	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}
	
	@GetMapping("/ingredients")
	public List<IngredientDto> getAll() {
		return ingredientService.getAll();
	}

	@PostMapping("/ingredients")
	public void insert(@RequestBody String name) {
		IngredientDto ingredientDto = new IngredientDto();
		ingredientDto.setName(name);
		ingredientService.insertIngredient(ingredientDto);
	}
	
	@PutMapping("/ingredients")
	public void update(@RequestBody IngredientDto ingredientDto){
		ingredientService.updateIngredient(ingredientDto);
	}
	
	@DeleteMapping("/ingredients")
	public void delete(@RequestBody IngredientDto ingredientDto){
		ingredientService.deleteIngredient(ingredientDto);
	}
	
	@GetMapping("/ingredients/{id}")
	public IngredientDto get(@PathVariable(value="id") int id){
		return ingredientService.getIngredient(id);
	}
	
	@DeleteMapping("/ingredients/{id}")
	public void delete(@PathVariable(value="id") int id){
		ingredientService.deleteIngredient(id);
	}
	
}
