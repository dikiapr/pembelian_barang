package com.pembelian_barang.demo.controller;

import com.pembelian_barang.demo.dto.MoneyRequest;
import com.pembelian_barang.demo.model.Product;
import com.pembelian_barang.demo.service.ShoppingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ShoppingController {
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @PostMapping("/buy")
    public List<Product> buy(@RequestBody MoneyRequest moneyRequest) {
        return shoppingService.buyProducts(moneyRequest.getMoney());
    }
}