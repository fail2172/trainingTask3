package com.bsuir.ppvis.сook.model;

import java.io.Serializable;

public class CookingStep implements Serializable {

    private final Ingredient ingredient;
    private final String action;

    public CookingStep(Ingredient ingredient, String action) {
        this.ingredient = ingredient;
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CookingStep that = (CookingStep) o;

        if (!ingredient.equals(that.ingredient)) return false;
        return action.equals(that.action);
    }

    @Override
    public int hashCode() {
        int result = ingredient.hashCode();
        result = 31 * result + action.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "cookingStep{" +
                "ingredient=" + ingredient +
                ", action='" + action + '\'' +
                '}';
    }
}
