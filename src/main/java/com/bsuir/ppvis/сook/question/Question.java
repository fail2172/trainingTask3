package com.bsuir.ppvis.сook.question;

import com.bsuir.ppvis.сook.model.Recipe;

public interface Question <T> {

    String receiveQuestion();

    void giveAnAnswer(T t);

    T getAnswer();

    boolean checkRecipe(Recipe recipe);

}
