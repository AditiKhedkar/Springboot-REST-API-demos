package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static Map<Integer, String> userDB = new HashMap<>();
    static {
        userDB.put(1, "Alice");
        userDB.put(2, "Bob");
    }

    @GetMapping
    public Map<Integer, String> getAllUsers() {
        return userDB;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return userDB.getOrDefault(id, "User not found");
    }

    @PostMapping
    public String createUser(@RequestBody Map.Entry<Integer, String> user) {
        userDB.put(user.getKey(), user.getValue());
        return "User created";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userDB.remove(id) != null ? "User deleted" : "User not found";
    }
}
