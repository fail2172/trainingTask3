package com.bsuir.ppvis.сook.model;

public class Ingredient {

    private final Product product;
    private final Double weight;

    public Ingredient(Product product, Double weight) {
        this.product = product;
        this.weight = weight;
    }

    public Product getProduct() {
        return product;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (!product.equals(that.product)) return false;
        return weight.equals(that.weight);
    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + weight.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "product=" + product +
                ", weight=" + weight +
                '}';
    }
}
