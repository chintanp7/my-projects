package com.example.logindemo.controller;

import com.example.logindemo.entity.User;
import com.example.logindemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean checkLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (userService.getUserByEmailAndPassword(email, password) != null) {
            return true;
        }
        return false;
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:3000")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/get/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public User getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }
}
