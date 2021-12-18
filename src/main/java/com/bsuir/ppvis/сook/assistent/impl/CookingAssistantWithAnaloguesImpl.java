package com.bsuir.ppvis.сook.assistent.impl;

import com.bsuir.ppvis.сook.analogue.impl.AnalogueFactoryImpl;
import com.bsuir.ppvis.сook.assistent.CookingAssistantWithAnalogues;
import com.bsuir.ppvis.сook.diagnostics.DiagnosticWithAnalogue;
import com.bsuir.ppvis.сook.diagnostics.impl.DiagnosticWithAnalogueImpl;
import com.bsuir.ppvis.сook.model.Product;
import com.bsuir.ppvis.сook.model.Recipe;

import java.util.Set;

public class CookingAssistantWithAnaloguesImpl extends CookingAssistantImpl implements CookingAssistantWithAnalogues {

    private final DiagnosticWithAnalogue diagnosticWithAnalogue;

    public CookingAssistantWithAnaloguesImpl() {
        this.diagnosticWithAnalogue = new DiagnosticWithAnalogueImpl(ingredientRepository, recipeRepository,
                new AnalogueFactoryImpl());
    }

    @Override
    public Set<Recipe> pickUpRecipes() {
        return diagnosticWithAnalogue.pickUpRecipes();
    }

    @Override
    public void addAnalogue(Product product, Product analogue) {
        diagnosticWithAnalogue.addAnalogue(product, analogue);
    }
}
