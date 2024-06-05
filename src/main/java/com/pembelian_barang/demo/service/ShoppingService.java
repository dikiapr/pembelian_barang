package com.pembelian_barang.demo.service;

import com.pembelian_barang.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService {

    private List<Product> products;

    public ShoppingService() {
        products = new ArrayList<>();
        products.add(new Product("Keyboard", 25000));
        products.add(new Product("Keyboard", 40000));
        products.add(new Product("Mouse", 12000));
        products.add(new Product("Mouse", 20000));
        products.add(new Product("Mouse", 35000));
    }

    public List<Product> buyProducts(int money) {
        List<Product> purchasedProducts = new ArrayList<>();
        int remainingMoney = money;

        while (remainingMoney > 0) {
            Product bestProduct = null;
            int bestPriceDiff = Integer.MAX_VALUE;

            for (Product product : products) {
                int priceDiff = remainingMoney - product.getPrice();
                if (priceDiff >= 0 && priceDiff < bestPriceDiff) {
                    bestPriceDiff = priceDiff;
                    bestProduct = product;
                }
            }

            if (bestProduct != null) {
                purchasedProducts.add(bestProduct);
                remainingMoney -= bestProduct.getPrice();
            } else {
                break;
            }
        }

        return purchasedProducts;
    }
}

