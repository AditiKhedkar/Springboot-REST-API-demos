package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static Map<Integer, String> productDB = new HashMap<>();
    static {
        productDB.put(101, "Laptop");
        productDB.put(102, "Smartphone");
    }

    @GetMapping
    public Map<Integer, String> getAllProducts() {
        return productDB;
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable int id) {
        return productDB.getOrDefault(id, "Product not found");
    }

    @PostMapping
    public String addProduct(@RequestBody Map.Entry<Integer, String> product) {
        productDB.put(product.getKey(), product.getValue());
        return "Product added";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productDB.remove(id) != null ? "Product deleted" : "Product not found";
    }
}
