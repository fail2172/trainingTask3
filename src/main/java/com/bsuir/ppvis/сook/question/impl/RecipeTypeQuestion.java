package com.bsuir.ppvis.сook.question.impl;

import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.model.RecipeType;
import com.bsuir.ppvis.сook.question.Question;

public class RecipeTypeQuestion implements Question<RecipeType> {
    
    private final String question;
    private RecipeType answer;

    public RecipeTypeQuestion() {
        question = "Что готовим? Завтрак, обед или ужин?";
    }

    @Override
    public String receiveQuestion() {
        return question;
    }

    @Override
    public void giveAnAnswer(RecipeType recipeType) {
        answer = recipeType;
    }

    public RecipeType getAnswer() {
        return answer;
    }

    @Override
    public boolean checkRecipe(Recipe recipe) {
        return recipe.getRecipeType().equals(answer);
    }
}
