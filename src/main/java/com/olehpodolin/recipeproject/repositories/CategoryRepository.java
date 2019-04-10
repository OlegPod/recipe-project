package com.olehpodolin.recipeproject.repositories;

import com.olehpodolin.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
