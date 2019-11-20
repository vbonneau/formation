package com.exilys.formation.dto;

public class IngredientDto {

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "IngredientDto [id=" + id + ", name=" + name + "]";
	}
}
