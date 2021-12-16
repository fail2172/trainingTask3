package com.bsuir.ppvis.сook.repository;

import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;

import java.util.List;
import java.util.Set;

public interface Repository {

    Set<Recipe> receiveRecipes(List<Question> questions);

}
