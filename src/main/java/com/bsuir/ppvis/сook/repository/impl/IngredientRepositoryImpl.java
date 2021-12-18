package com.bsuir.ppvis.сook.repository.impl;

import com.bsuir.ppvis.сook.model.Ingredient;
import com.bsuir.ppvis.сook.repository.IngredientRepository;
import com.bsuir.ppvis.сook.model.Product;
import com.bsuir.ppvis.сook.model.ProductType;

import java.util.HashSet;
import java.util.Set;

public class IngredientRepositoryImpl implements IngredientRepository {

    private final Set<Ingredient> ingredientSet;

    public IngredientRepositoryImpl() {
        //Заполнение списка продуктов из файла или базы данныхф
        ingredientSet = new HashSet<>();
        ingredientSet.add(new Ingredient(new Product("картошка", ProductType.VEGETABLES), 1000d));
        ingredientSet.add(new Ingredient(new Product("сметана", ProductType.MILKY), 500d));
    }

    @Override
    public Set<Ingredient> receiveIngredientSet() {
        return ingredientSet;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        for (Ingredient availableIngredient : ingredientSet
             ) {
            if (availableIngredient.getProduct().equals(ingredient.getProduct())) {
                availableIngredient.addIngredient(ingredient);
                return;
            }
        }
        ingredientSet.add(ingredient);
    }

    @Override
    public boolean haveIngredient(Ingredient ingredient) {
        return ingredientSet.stream()
                .anyMatch(availableIngredient ->
                        availableIngredient.getProduct().equals(ingredient.getProduct())
                                && availableIngredient.getWeight() > ingredient.getWeight()
                );
    }
}
