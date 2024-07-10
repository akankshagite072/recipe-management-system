package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity,Long> {

	RecipeEntity update(RecipeEntity recipe);

	void editById(Long id);


}
