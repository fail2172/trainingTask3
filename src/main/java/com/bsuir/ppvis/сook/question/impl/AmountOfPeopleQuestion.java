package com.bsuir.ppvis.сook.question.impl;

import com.bsuir.ppvis.сook.model.ExtendRecipe;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;

public class AmountOfPeopleQuestion implements Question<Integer> {

    private final String question;
    private Integer answer;

    public AmountOfPeopleQuestion() {
        this.question = "На скольких человек готовим?";
    }

    @Override
    public String receiveQuestion() {
        return question;
    }

    @Override
    public void giveAnAnswer(Integer integer) {
        answer = integer;
    }

    @Override
    public Integer getAnswer() {
        return answer;
    }

    @Override
    public boolean checkRecipe(Recipe recipe) {
        return answer < ((ExtendRecipe)recipe).getAmountOfPeople();
    }
}