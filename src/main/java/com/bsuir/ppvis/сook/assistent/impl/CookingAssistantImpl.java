package com.bsuir.ppvis.сook.assistent.impl;

import com.bsuir.ppvis.сook.assistent.CookingAssistant;
import com.bsuir.ppvis.сook.cooking.Cooking;
import com.bsuir.ppvis.сook.cooking.impl.SimpleCooking;
import com.bsuir.ppvis.сook.diagnostics.Diagnostic;
import com.bsuir.ppvis.сook.diagnostics.impl.SimpleDiagnostic;
import com.bsuir.ppvis.сook.exception.NoNextStepException;
import com.bsuir.ppvis.сook.exception.NoSuchRecipeException;
import com.bsuir.ppvis.сook.model.CookingStep;
import com.bsuir.ppvis.сook.model.Ingredient;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.question.Question;
import com.bsuir.ppvis.сook.repository.IngredientRepository;
import com.bsuir.ppvis.сook.repository.RecipeRepository;
import com.bsuir.ppvis.сook.repository.impl.IngredientRepositoryImpl;
import com.bsuir.ppvis.сook.repository.impl.RecipeRepositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CookingAssistantImpl implements Serializable, CookingAssistant {

    protected final IngredientRepository ingredientRepository;
    protected final RecipeRepository recipeRepository;
    protected final Diagnostic diagnostic;
    protected Optional<Cooking> cooking;

    public CookingAssistantImpl() {
        ingredientRepository = new IngredientRepositoryImpl();
        recipeRepository = new RecipeRepositoryImpl();
        diagnostic = new SimpleDiagnostic(ingredientRepository, recipeRepository);
        cooking = Optional.empty();
    }

    @Override
    public boolean weArePreparingNow() {
        return cooking.isPresent();
    }

    @Override
    public void startCooking(Recipe recipe) {
        cooking = Optional.of(new SimpleCooking(recipe));
    }

    @Override
    public void finishCooking() {
        cooking = Optional.empty();
    }

    @Override
    public CookingStep receiveNextStep() throws NoNextStepException {
        if (cooking.isPresent()) {
            return cooking.get().receiveNextStep();
        } else {
            throw new NoNextStepException("Не удалось найти следующий шаг приготовления!");
        }
    }

    @Override
    public List<Ingredient> missingIngredients(Recipe recipe) {
        List<Ingredient> missingIngredients = new ArrayList<>();
        recipe.getIngredientList()
                .forEach(ingredient -> {
                    if(!ingredientRepository.haveIngredient(ingredient)) {
                        missingIngredients.add(ingredient);
                    }
                });
        return missingIngredients;
    }

    @Override
    public boolean hasNext() throws NoNextStepException {
        if (cooking.isPresent()) {
            return cooking.get().hasNext();
        } else {
            throw new NoNextStepException("Готовка не начата!");
        }
    }

    @Override
    public Set<Ingredient> receiveIngredientSet() {
        return ingredientRepository.receiveIngredientSet();
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientRepository.addIngredient(ingredient);
    }

    @Override
    public Set<Recipe> receiveAllRecipes() {
        return recipeRepository.receiveAllRecipes();
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return recipeRepository.addRecipe(recipe);
    }

    @Override
    public Recipe receiveRecipe(String name) throws NoSuchRecipeException {
        return recipeRepository.receiveRecipe(name);
    }

    @Override
    public Set<Recipe> pickUpRecipes() {
        return diagnostic.pickUpRecipes();
    }

    @Override
    public void uploadRecipeParam(Question question) {
        diagnostic.uploadQuestion(question);
    }

    @Override
    public void clearRecipeParams() {
        diagnostic.clearQuestionList();
    }

}
