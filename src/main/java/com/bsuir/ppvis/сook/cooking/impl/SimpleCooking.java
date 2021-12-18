package com.bsuir.ppvis.сook.cooking.impl;

import com.bsuir.ppvis.сook.cooking.Cooking;
import com.bsuir.ppvis.сook.model.CookingStep;
import com.bsuir.ppvis.сook.model.Recipe;

import java.util.Iterator;

public class SimpleCooking implements Cooking {

    private final Iterator<CookingStep> cookingStepIterator;

    public SimpleCooking(Recipe recipe) {
        cookingStepIterator = recipe.getSteps().iterator();
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
