package com.bsuir.ppvis.сook.model;

public enum ProductType {
    MEAT("meat"),
    MILKY("milky"),
    VEGETABLES("vegetable"),
    FRUIT("fruit"),
    BREAD("bread"),
    CEREALS("cereals"),
    DEFAULT("default");

    private final String type;

    ProductType(String type) {
        this.type = type;
    }

    public static ProductType instance(String type) {
        for (ProductType productType : values()){
            if(productType.type.equals(type)){
                return productType;
            }
        }
        return DEFAULT;
    }
}
