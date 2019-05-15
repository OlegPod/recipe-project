package com.olehpodolin.recipeproject.services;

import com.olehpodolin.recipeproject.commands.IngredientCommand;
import com.olehpodolin.recipeproject.converters.IngredientToIngredientCommand;
import com.olehpodolin.recipeproject.domain.Recipe;
import com.olehpodolin.recipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientService(IngredientToIngredientCommand ingredientToIngredientCommand,
                             RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            // todo implement error handling
            log.error("Recipe Id not found, Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            // todo implement error handling
            log.error("Ingredient Id not found, Id: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
