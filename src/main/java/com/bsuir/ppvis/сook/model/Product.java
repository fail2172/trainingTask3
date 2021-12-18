package com.bsuir.ppvis.сook.model;

import java.io.Serializable;

public class Product implements Serializable {

    private final String name;
    private final ProductType type;

    public Product(String name, ProductType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        return type == product.type;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
