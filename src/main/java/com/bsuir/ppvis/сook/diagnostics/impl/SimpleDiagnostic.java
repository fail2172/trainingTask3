package com.bsuir.ppvis.сook.diagnostics.impl;

import com.bsuir.ppvis.сook.cook.UserProductRepository;
import com.bsuir.ppvis.сook.diagnostics.Diagnostic;
import com.bsuir.ppvis.сook.model.Ingredient;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;
import com.bsuir.ppvis.сook.repository.Repository;
import com.bsuir.ppvis.сook.repository.impl.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleDiagnostic implements Diagnostic {

    private final List<Question> questions;
    private final Repository repository;
    private final UserProductRepository userRepository;

    public SimpleDiagnostic(UserProductRepository userRepository) {
        this.userRepository = userRepository;
        questions = new ArrayList<>();
        repository = new RecipeRepository();
    }

    @Override
    public Set<Recipe> pickUpRecipes() {
        Set<Recipe> sortedSet = repository.receiveRecipes(questions);
        return sortedSet.stream()
                .filter(recipe -> {
                    for (Ingredient ingredient : recipe.getIngredientList()
                         ) {
                        if(!userRepository.haveProduct(ingredient.getProduct())){
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toSet());
    }

    public void uploadQuestion(Question question) {
        questions.add(question);
    }
}
