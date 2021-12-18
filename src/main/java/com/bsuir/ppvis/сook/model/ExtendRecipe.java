package com.bsuir.ppvis.сook.model;

public class ExtendRecipe extends Recipe{

    private int amountOfPeople;

    public ExtendRecipe(String name, RecipeType recipeType) {
        super(name, recipeType);
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }
}
