package com.exilys.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.exilys.formation.entity.Ingredient;

@Repository
public class IngredientDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public IngredientDao() {
		
	}
	
	public void insertIngredient(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		session.save(ingredient);
	}
	
	public List<Ingredient> gatAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Ingredient> query = session.createQuery("from Ingredient",Ingredient.class);
		return query.list();
	}
	
	@Transactional
	public void updateIngredient(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		session.update(ingredient);
	}
	
	@Transactional
	public void deleteIngredient(Ingredient ingredient) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(ingredient);
	}

	public Ingredient getIngredient(long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Ingredient.class, id);
	}
}
