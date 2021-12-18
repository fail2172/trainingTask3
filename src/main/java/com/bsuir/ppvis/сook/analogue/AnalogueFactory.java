package com.bsuir.ppvis.сook.analogue;

import com.bsuir.ppvis.сook.model.Product;

public interface AnalogueFactory {

    void addAnalogue(Product product, Product analogue);

    Product getAnalogue(Product product);

}
