package com.bsuir.ppvis.сook.cook.impl;

import com.bsuir.ppvis.сook.cook.UserProductRepository;
import com.bsuir.ppvis.сook.model.Product;
import com.bsuir.ppvis.сook.model.ProductType;

import java.util.ArrayList;
import java.util.List;

public class UserProductRepositoryImpl implements UserProductRepository {

    private final List<Product> productList;

    public UserProductRepositoryImpl() {
        productList = new ArrayList<>();
        productList.add(new Product("картошка", ProductType.VEGETABLES));
        productList.add(new Product("сметана", ProductType.MILKY));
    }

    @Override
    public boolean haveProduct(Product product) {
        return productList.stream().anyMatch(availableProduct -> availableProduct.equals(product));
    }
}
