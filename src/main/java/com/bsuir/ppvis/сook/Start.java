package com.bsuir.ppvis.сook;

import com.bsuir.ppvis.сook.assistent.CookingAssistant;
import com.bsuir.ppvis.сook.assistent.impl.CookingAssistantImpl;
import com.bsuir.ppvis.сook.exception.NoNextStepException;
import com.bsuir.ppvis.сook.model.Product;
import com.bsuir.ppvis.сook.model.ProductType;
import com.bsuir.ppvis.сook.model.Recipe;
import com.bsuir.ppvis.сook.model.RecipeType;
import com.bsuir.ppvis.сook.question.Question;
import com.bsuir.ppvis.сook.question.impl.MainIngredientQuestion;
import com.bsuir.ppvis.сook.question.impl.RecipeTypeQuestion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Start {

    private final static Logger LOGGER = LogManager.getLogger(Start.class);

    public static void main(String[] args) {
        CookingAssistant assistant = new CookingAssistantImpl();

        //Если мы хотим продолжить готовить
        if (assistant.weArePreparingNow()){
            try {
                while (assistant.hasNext()) {
                    System.out.println(assistant.receiveNextStep());
                }
            } catch (NoNextStepException e) {
                LOGGER.error("Ошибка во время приготовления",e);
            }

            //Заканчиваем готовить
            assistant.finishCooking();
            return;
        }

        //Создаём необходимые критерии
        Question<Product> mainProductQuestion = new MainIngredientQuestion();
        Product mainProduct = new Product("Картошка", ProductType.VEGETABLES);
        mainProductQuestion.giveAnAnswer(mainProduct);

        Question<RecipeType> recipeTypeQuestion = new RecipeTypeQuestion();
        recipeTypeQuestion.giveAnAnswer(RecipeType.LUNCH);

        //Называем асистенту необходимые параметры
        assistant.uploadRecipeParam(mainProductQuestion);
        assistant.uploadRecipeParam(recipeTypeQuestion);

        List<Recipe> recipes = (List<Recipe>) assistant.pickUpRecipes();

        //Выбираем понравившийся рецепт
        assistant.startCooking(recipes.get(0));

        //Начинаем готовить
        try {
            while (assistant.hasNext()) {
                System.out.println(assistant.receiveNextStep());
            }
        } catch (NoNextStepException e) {
            LOGGER.error("Ошибка во время приготовления",e);
        }

        //Заканчиваем готовить
        assistant.finishCooking();
    }
}
