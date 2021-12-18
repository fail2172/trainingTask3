package com.bsuir.ppvis.сook.diagnostics.impl;

import com.bsuir.ppvis.сook.repository.IngredientRepository;
import com.bsuir.ppvis.сook.diagnostics.Diagnostic;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;
import com.bsuir.ppvis.сook.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleDiagnostic implements Diagnostic {

    private final List<Question> questions;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public SimpleDiagnostic(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        questions = new ArrayList<>();
    }

    @Override
    public Set<Recipe> pickUpRecipes() {
        Set<Recipe> sortedSet = recipeRepository.receiveRecipes(questions);
        return sortedSet.stream()
                .filter(recipe -> recipe.getIngredientList().stream()
                            .allMatch(ingredientRepository::haveIngredient))
                .collect(Collectors.toSet());
    }

    public void uploadQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void clearQuestionList() {
        questions.clear();
    }


}
