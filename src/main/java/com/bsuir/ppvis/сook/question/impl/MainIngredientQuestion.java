package com.bsuir.ppvis.сook.question.impl;

import com.bsuir.ppvis.сook.model.Product;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;

public class MainIngredientQuestion implements Question<Product> {

    private final String question;
    private Product answer;

    public MainIngredientQuestion() {
        question = "Какой главный ингредиент блюда";
    }

    @Override
    public String receiveQuestion() {
        return question;
    }

    @Override
    public void giveAnAnswer(Product product) {
        answer = product;
    }

    public Product getAnswer() {
        return answer;
    }

    @Override
    public boolean checkRecipe(Recipe recipe) {
        return recipe.thereIsAnProduct(answer);
    }
}
