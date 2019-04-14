package com.olehpodolin.recipeproject.bootstrap;

import com.olehpodolin.recipeproject.domain.*;
import com.olehpodolin.recipeproject.repositories.RecipeRepository;
import com.olehpodolin.recipeproject.services.CategoryService;
import com.olehpodolin.recipeproject.services.UnitOfMeasureService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryService categoryService;
    private UnitOfMeasureService unitOfMeasureService;

    public Bootstrap(RecipeRepository recipeRepository, CategoryService categoryService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Recipe guacamole = new Recipe();

        guacamole.getCategories().add(categoryService.getCategory("Mexican"));
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setPrepTime(10);
        guacamole.setCookTime(10);
        guacamole.setServings(3);
        guacamole.setSource("Mexico");

        guacamole.setDescription("Perfect Guacamole");

        guacamole.getIngredients().add(new Ingredient(new BigDecimal(2), unitOfMeasureService.getUnitOfMeasure("Each"),
                "ripe avocados", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(.5), unitOfMeasureService.getUnitOfMeasure("Teaspoon"),
                "kosher salt", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(1), unitOfMeasureService.getUnitOfMeasure("Tablespoon"),
                "fresh lime juice or lemon juice", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(2), unitOfMeasureService.getUnitOfMeasure("Tablespoon"),
                "minced red onion or thinly sliced green onion", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(2), unitOfMeasureService.getUnitOfMeasure("Each"),
                "serrano chiles, stems and seeds removed, minced", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(2), unitOfMeasureService.getUnitOfMeasure("Tablespoon"),
                "cilantro (leaves and tender stems), finely chopped", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(1), unitOfMeasureService.getUnitOfMeasure("Dash"),
                "freshly grated black pepper", guacamole));
        guacamole.getIngredients().add(new Ingredient(new BigDecimal(.5), unitOfMeasureService.getUnitOfMeasure("Each"),
                "ripe tomato, seeds and pulp removed, chopped", guacamole));

        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. \n" +
                "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl. \n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.) \n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will \n provide some " +
                "balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. \n" +
                "So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. \n" +
                "Start with this recipe and adjust to your taste. " +
                "4 Cover with plastic and chill to store: Place plastic wrap  on the surface of \n the guacamole cover it and to prevent " +
                "air reaching it. (The oxygen in the air causes oxidation which will \n turn the guacamole brown.) Refrigerate until " +
                "ready to serve. \n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");

        guacamole.setNotes(new Notes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                                                " The simplest version of guacamole is just mashed avocados with salt. \n" +
                                                "Don't let the lack of availability of other ingredients stop you from making guacamole.", guacamole));
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        recipeRepository.save(guacamole);

        Recipe spicyGrilledChickenTacos = new Recipe();

        spicyGrilledChickenTacos.getCategories().add(categoryService.getCategory("Mexican"));
        spicyGrilledChickenTacos.setDifficulty(Difficulty.EASY);
        spicyGrilledChickenTacos.setPrepTime(20);
        spicyGrilledChickenTacos.setCookTime(15);
        spicyGrilledChickenTacos.setServings(5);
        spicyGrilledChickenTacos.setSource("Mexico");

        spicyGrilledChickenTacos.setDescription("Spicy Grilled Chicken Tacos");

        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(2), unitOfMeasureService.getUnitOfMeasure("Tablespoon"),
                "ancho chili powder", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(1), unitOfMeasureService.getUnitOfMeasure("Teaspoon"),
                "dried oregano", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(1), unitOfMeasureService.getUnitOfMeasure("Teaspoon"),
                "dried cumin", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(1), unitOfMeasureService.getUnitOfMeasure("Teaspoon"),
                "sugar", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(.5), unitOfMeasureService.getUnitOfMeasure("Teaspoon"),
                "salt", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(1), unitOfMeasureService.getUnitOfMeasure("Each"),
                "clove garlic, finely chopped", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(1), unitOfMeasureService.getUnitOfMeasure("Tablespoon"),
                "finely grated orange zest", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(2), unitOfMeasureService.getUnitOfMeasure("Tablespoon"),
                "fresh-squeezed orange juice", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(2), unitOfMeasureService.getUnitOfMeasure("Tablespoon"),
                "olive oil", spicyGrilledChickenTacos));
        spicyGrilledChickenTacos.getIngredients().add(new Ingredient(new BigDecimal(6), unitOfMeasureService.getUnitOfMeasure("Each"),
                "skinless, boneless chicken thighs (1 1/4 pounds)", spicyGrilledChickenTacos));

        spicyGrilledChickenTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, \n" +
                "cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. \n" +
                "Add the chicken to the bowl and toss to coat all over. Set aside to marinate while the grill heats " +
                "and you \n prepare the rest of the toppings. 3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, \n" +
                "or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see\n" +
                " pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side. Wrap warmed \n" +
                "tortillas in a tea towel to keep them warm until serving. 5 Assemble the tacos: Slice the chicken into strips. On each tortilla,\n " +
                "place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the \n" +
                "thinned sour cream. Serve with lime wedges.");

        spicyGrilledChickenTacos.setNotes(new Notes("I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes,\n" +
                " tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always \n" +
                " seem to have some in the fridge and I think it adds a nice green crunch to the tacos.", spicyGrilledChickenTacos));

        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

        recipeRepository.save(spicyGrilledChickenTacos);

    }
}
