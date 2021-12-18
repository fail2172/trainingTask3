package com.bsuir.ppvis.сook.analogue.impl;

import com.bsuir.ppvis.сook.analogue.AnalogueFactory;
import com.bsuir.ppvis.сook.model.Product;

import java.util.HashMap;
import java.util.Map;

public class AnalogueFactoryImpl implements AnalogueFactory {

    private final Map<Product, Product> analogueMap;

    public AnalogueFactoryImpl() {
        analogueMap = new HashMap<>();
    }

    @Override
    public void addAnalogue(Product product, Product analogue) {
        analogueMap.put(product, analogue);
    }

    @Override
    public Product getAnalogue(Product product) {
        return analogueMap.get(product);
    }
}
