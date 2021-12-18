package com.bsuir.ppvis.сook.repository;

import com.bsuir.ppvis.сook.model.Ingredient;

import java.io.Serializable;
import java.util.Set;

public interface IngredientRepository extends Serializable {

    Set<Ingredient> receiveIngredientSet();

    void addIngredient(Ingredient ingredient);

    boolean haveIngredient(Ingredient ingredient);

}
