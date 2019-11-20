package com.exilys.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.exilys.formation.entity.Ingredient;
import com.exilys.formation.entity.Recipe;

@Repository
public class RecipeDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void insertIngredient(Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		session.save(recipe);
	}

	public List<Recipe> gatAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Recipe> query = session.createQuery("from recipe",Recipe.class);
		return query.list();
	}

	@Transactional
	public void updateIngredient(Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		session.update(recipe);
		
	}

	public Recipe get(long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Recipe.class, id);
	}

	public void delete(Recipe recipe) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(recipe);
		
	}

}
