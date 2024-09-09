package com.example.myapplication.Interfaces;

import com.example.myapplication.RealmClasses.ProductsRealm;

public interface ProductListenerInterface {
    void onProductAdd(ProductsRealm productsRealm);

    void onProductMinus(ProductsRealm productsRealm);
}
