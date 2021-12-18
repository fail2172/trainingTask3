package com.bsuir.ppvis.сook.question.impl;

import com.bsuir.ppvis.сook.allergy.Allergy;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;

public class AllergyQuestion implements Question<Allergy> {

    private final String question;
    private Allergy answer;

    public AllergyQuestion() {
        question = "На какой тип продуктов есть алергия";
    }

    @Override
    public String receiveQuestion() {
        return question;
    }

    @Override
    public void giveAnAnswer(Allergy allergy) {
        answer = allergy;
    }

    @Override
    public Allergy getAnswer() {
        return answer;
    }

    @Override
    public boolean checkRecipe(Recipe recipe) {
        return recipe.getIngredientList().stream()
                .anyMatch(ingredient -> ingredient.getProduct().getType().equals(answer.getAllergen()));
    }
}
