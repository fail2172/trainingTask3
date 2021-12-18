package com.bsuir.ppvis.сook.allergy;

import com.bsuir.ppvis.сook.model.ProductType;

public class Allergy {

    private final ProductType allergen;

    public Allergy(ProductType allergen) {
        this.allergen = allergen;
    }

    public ProductType getAllergen() {
        return allergen;
    }
}
