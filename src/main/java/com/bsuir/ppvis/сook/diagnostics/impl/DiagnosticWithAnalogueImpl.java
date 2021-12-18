package com.bsuir.ppvis.сook.diagnostics.impl;

import com.bsuir.ppvis.сook.analogue.AnalogueFactory;
import com.bsuir.ppvis.сook.diagnostics.DiagnosticWithAnalogue;
import com.bsuir.ppvis.сook.model.Ingredient;
import com.bsuir.ppvis.сook.model.Product;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.repository.IngredientRepository;
import com.bsuir.ppvis.сook.repository.RecipeRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class DiagnosticWithAnalogueImpl extends SimpleDiagnostic implements DiagnosticWithAnalogue {

    private final AnalogueFactory analogueFactory;

    public DiagnosticWithAnalogueImpl(IngredientRepository ingredientRepository, RecipeRepository recipeRepository,
                                      AnalogueFactory analogueFactory) {
        super(ingredientRepository, recipeRepository);
        this.analogueFactory = analogueFactory;
    }

    @Override
    public Set<Recipe> pickUpRecipes() {
        Set<Recipe> sortedSet = recipeRepository.receiveRecipes(questions);
        return sortedSet.stream()
                .filter(recipe -> recipe.getIngredientList().stream()
                        .allMatch(ingredient -> ingredientRepository.haveIngredient(ingredient)
                                || ingredientRepository.haveIngredient(
                                        new Ingredient(analogueFactory.getAnalogue(ingredient.getProduct()), ingredient.getWeight())
                        )))
                .collect(Collectors.toSet());
    }

    @Override
    public void addAnalogue(Product product, Product analogue) {
        analogueFactory.addAnalogue(product, analogue);
    }
}
