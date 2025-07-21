package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private static final Map<Integer, String> customerDB = new HashMap<>();
    static {
        customerDB.put(101, "Alice");
        customerDB.put(102, "Bob");
    }

    @GetMapping
    public Collection<String> getAllCustomers() {
        return customerDB.values();
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable int id) {
        return customerDB.getOrDefault(id, "Customer not found");
    }

    @PostMapping
    public String addCustomer(@RequestBody Map.Entry<Integer, String> customer) {
        customerDB.put(customer.getKey(), customer.getValue());
        return "Customer added";
    }

    @PutMapping("/{id}")
    public String replaceCustomer(@PathVariable int id, @RequestBody String name) {
        customerDB.put(id, name);
        return "Customer replaced";
    }

    @PatchMapping("/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody String nameFragment) {
        String current = customerDB.getOrDefault(id, "");
        customerDB.put(id, current + " (updated: " + nameFragment + ")");
        return "Customer patched";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return customerDB.remove(id) != null ? "Customer deleted" : "Customer not found";
    }
}
