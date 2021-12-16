package com.bsuir.ppvis.сook.cooking;

import com.bsuir.ppvis.сook.model.CookingStep;
import com.bsuir.ppvis.сook.model.Ingredient;

import java.io.Serializable;
import java.util.Set;

public interface Cooking extends Serializable {

    Set<Ingredient> receiveIngredientSet();

    Set<CookingStep> receiveAllCookingSteps();

    CookingStep receiveNextStep();

    boolean hasNext();

}
