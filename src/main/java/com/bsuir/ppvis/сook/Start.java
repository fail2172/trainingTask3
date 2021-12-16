package com.bsuir.ppvis.сook;

import com.bsuir.ppvis.сook.cook.impl.UserProductRepositoryImpl;
import com.bsuir.ppvis.сook.cooking.Cooking;
import com.bsuir.ppvis.сook.cooking.impl.SimpleCooking;
import com.bsuir.ppvis.сook.diagnostics.Diagnostic;
import com.bsuir.ppvis.сook.diagnostics.impl.SimpleDiagnostic;
import com.bsuir.ppvis.сook.model.*;
import com.bsuir.ppvis.сook.question.Question;
import com.bsuir.ppvis.сook.question.impl.MainIngredientQuestion;
import com.bsuir.ppvis.сook.question.impl.RecipeTypeQuestion;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        //Главный продукт
        Product potato = new Product("Картошка", ProductType.VEGETABLES);

        //Задаём два вопроса
        Question<Product> mainProductQuestion = new MainIngredientQuestion();
        mainProductQuestion.giveAnAnswer(potato);

        Question<RecipeType> recipeTypeQuestion = new RecipeTypeQuestion();
        recipeTypeQuestion.giveAnAnswer(RecipeType.LUNCH);

        Diagnostic diagnostic = new SimpleDiagnostic(new UserProductRepositoryImpl());
        diagnostic.uploadQuestion(mainProductQuestion);
        diagnostic.uploadQuestion(recipeTypeQuestion);

        List<Recipe> recipes = (List<Recipe>) diagnostic.pickUpRecipes();

        Cooking cooking = new SimpleCooking(recipes.get(0));

        while (cooking.hasNext()){
            CookingStep step = cooking.receiveNextStep();

            System.out.println(step.toString());
        }
    }
}
