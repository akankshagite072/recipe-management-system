package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}