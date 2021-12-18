package com.bsuir.ppvis.сook;

import com.bsuir.ppvis.сook.assistent.CookingAssistantWithAnalogues;
import com.bsuir.ppvis.сook.assistent.impl.CookingAssistantWithAnaloguesImpl;
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
        //Теперь используется асистент с функцией добавления аналога продукта
        CookingAssistantWithAnalogues assistant = new CookingAssistantWithAnaloguesImpl();

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

        //Сообщаем асистенту о возможных аналогах
        Product analogue = new Product("Батат", ProductType.VEGETABLES);
        assistant.addAnalogue(mainProduct, analogue);

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
