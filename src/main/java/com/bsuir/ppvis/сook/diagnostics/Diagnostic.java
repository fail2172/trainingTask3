package com.bsuir.ppvis.сook.diagnostics;

import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;

import java.util.Set;

public interface Diagnostic {

    Set<Recipe> pickUpRecipes();

    void uploadQuestion(Question question);

}
