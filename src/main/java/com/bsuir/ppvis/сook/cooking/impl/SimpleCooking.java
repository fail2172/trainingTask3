package com.bsuir.ppvis.сook.cooking.impl;

import com.bsuir.ppvis.сook.cooking.Cooking;
import com.bsuir.ppvis.сook.model.CookingStep;
import com.bsuir.ppvis.сook.model.Ingredient;
import com.bsuir.ppvis.сook.model.Recipe;

import java.util.Iterator;
import java.util.Set;

public class SimpleCooking implements Cooking {

    private final Recipe recipe;
    private final Iterator<CookingStep> cookingStepIterator;

    public SimpleCooking(Recipe recipe) {
        this.recipe = recipe;
        cookingStepIterator = recipe.getSteps().iterator();
    }

    @Override
    public Set<Ingredient> receiveIngredientSet() {
        return recipe.getIngredientList();
    }

    @Override
    public Set<CookingStep> receiveAllCookingSteps() {
        return recipe.getSteps();
    }

    @Override
    public CookingStep receiveNextStep() {
        return cookingStepIterator.next();
    }

    @Override
    public boolean hasNext() {
        return cookingStepIterator.hasNext();
    }
}
