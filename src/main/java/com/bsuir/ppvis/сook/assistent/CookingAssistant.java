package com.bsuir.ppvis.сook.assistent;

import com.bsuir.ppvis.сook.exception.NoNextStepException;
import com.bsuir.ppvis.сook.exception.NoSuchRecipeException;
import com.bsuir.ppvis.сook.model.CookingStep;
import com.bsuir.ppvis.сook.model.Ingredient;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface CookingAssistant extends Serializable {

    Set<Ingredient> receiveIngredientSet();

    void addIngredient(Ingredient ingredient);

    Set<Recipe> receiveAllRecipes();

    boolean addRecipe(Recipe recipe);

    Recipe receiveRecipe(String name) throws NoSuchRecipeException;

    Set<Recipe> pickUpRecipes();

    void uploadRecipeParam(Question question);

    void clearRecipeParams();

    boolean weArePreparingNow();

    void startCooking(Recipe recipe);

    void finishCooking();

    boolean hasNext() throws NoNextStepException;

    CookingStep receiveNextStep() throws NoNextStepException;

    List<Ingredient> missingIngredients(Recipe recipe);

}
