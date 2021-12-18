package com.bsuir.ppvis.сook.repository;

import com.bsuir.ppvis.сook.exception.NoSuchRecipeException;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface RecipeRepository extends Serializable {

    Set<Recipe> receiveAllRecipes();

    Set<Recipe> receiveRecipes(List<Question> questions);

    Recipe receiveRecipe(String name) throws NoSuchRecipeException;

    boolean addRecipe(Recipe recipe);

}
