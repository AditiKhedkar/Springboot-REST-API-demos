package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Map<Integer, String> orderDB = new HashMap<>();
    static {
        orderDB.put(1, "Order #1 - Laptop");
        orderDB.put(2, "Order #2 - Phone");
    }

    @GetMapping
    public Collection<String> getAllOrders() {
        return orderDB.values();
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable int id) {
        return orderDB.getOrDefault(id, "Order not found");
    }

    @PostMapping
    public String createOrder(@RequestBody Map.Entry<Integer, String> order) {
        orderDB.put(order.getKey(), order.getValue());
        return "Order created";
    }

    @PutMapping("/{id}")
    public String replaceOrder(@PathVariable int id, @RequestBody String description) {
        orderDB.put(id, description);
        return "Order replaced";
    }

    @PatchMapping("/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody String partialUpdate) {
        orderDB.put(id, orderDB.getOrDefault(id, "") + " (updated: " + partialUpdate + ")");
        return "Order patched";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        return orderDB.remove(id) != null ? "Order deleted" : "Order not found";
    }
}
