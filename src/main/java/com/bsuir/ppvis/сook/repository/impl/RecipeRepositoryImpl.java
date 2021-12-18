package com.bsuir.ppvis.сook.repository.impl;

import com.bsuir.ppvis.сook.exception.NoSuchRecipeException;
import com.bsuir.ppvis.сook.model.*;
import com.bsuir.ppvis.сook.question.Question;
import com.bsuir.ppvis.сook.repository.RecipeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RecipeRepositoryImpl implements RecipeRepository {

    Set<Recipe> recipeSet = new HashSet<>();

    public RecipeRepositoryImpl(){
        //Заполнение списка рецептов из файла или базы данныхф
        ExtendRecipe mashedPotatoes = new ExtendRecipe("Пюре", RecipeType.LUNCH);
        mashedPotatoes.addIngredient(new Ingredient(new Product("Картошка", ProductType.VEGETABLES), 600d));
        mashedPotatoes.addIngredient(new Ingredient(new Product("Сметана", ProductType.MILKY), 70d));

        //Добавляем количество порций
        mashedPotatoes.setAmountOfPeople(2);
        recipeSet.add(mashedPotatoes);
    }

    @Override
    public Set<Recipe> receiveAllRecipes() {
        return recipeSet;
    }

    @Override
    public Set<Recipe> receiveRecipes(List<Question> questions) {
        return recipeSet.stream()
                .filter(recipe -> questions.stream()
                        .allMatch(question -> question.checkRecipe(recipe)))
                .collect(Collectors.toSet());
    }

    @Override
    public Recipe receiveRecipe(String name) throws NoSuchRecipeException {
        for (Recipe recipe : recipeSet
             ) {
            if(recipe.getName().equals(name)) {
                return recipe;
            }
        }
        throw new NoSuchRecipeException("Рецепт не найден");
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return recipeSet.add(recipe);
    }
}
