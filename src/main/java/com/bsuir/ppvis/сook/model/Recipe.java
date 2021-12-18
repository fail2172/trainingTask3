package com.bsuir.ppvis.сook.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recipe implements Serializable {

    private final String name;
    private final Set<Ingredient> ingredientList;
    private final Set<CookingStep> steps;
    private final RecipeType recipeType;

    public Recipe(String name, RecipeType recipeType) {
        this.name = name;
        this.recipeType = recipeType;
        this.ingredientList = new HashSet<>();
        this.steps = new HashSet<>();
    }

    public boolean addIngredient(Ingredient ingredient) {
        return ingredientList.add(ingredient);
    }

    public void addIngredients(List<Ingredient> ingredients){
        ingredientList.addAll(ingredients);
    }

    public String getName() {
        return name;
    }

    public Set<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public Set<CookingStep> getSteps() {
        return steps;
    }

    public boolean thereIsAnProduct(Product product) {
        return ingredientList.stream().
                anyMatch(ingredient -> ingredient.getProduct().equals(product));
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }
}
