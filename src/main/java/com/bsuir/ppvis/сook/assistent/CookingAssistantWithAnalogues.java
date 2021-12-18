package com.bsuir.ppvis.сook.assistent;

import com.bsuir.ppvis.сook.model.Product;

public interface CookingAssistantWithAnalogues extends CookingAssistant{
    void addAnalogue(Product product, Product analogue);
}
