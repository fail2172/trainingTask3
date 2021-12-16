package com.bsuir.ppvis.сook.repository.impl;

import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.model.RecipeType;
import com.bsuir.ppvis.сook.question.Question;
import com.bsuir.ppvis.сook.repository.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RecipeRepository implements Repository {

    Set<Recipe> recipeSet = new HashSet<>();

    public RecipeRepository(){
        Recipe mashedPotatoes = new Recipe(RecipeType.LUNCH);
    }

    @Override
    public Set<Recipe> receiveRecipes(List<Question> questions) {
        return recipeSet.stream()
                .filter(recipe -> questions.stream()
                        .allMatch(question -> question.checkRecipe(recipe)))
                .collect(Collectors.toSet());
    }
}
