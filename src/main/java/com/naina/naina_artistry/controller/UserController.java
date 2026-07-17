package com.naina.naina_artistry.controller;


import com.naina.naina_artistry.model.User;
import com.naina.naina_artistry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.naina.naina_artistry.model.ChangePasswordRequest;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    @Autowired
    private UserService service;

    // Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user.getEmail(), user.getPassword());

    }

    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordRequest request) {

        return service.changePassword(
                request.getEmail(),
                request.getOldPassword(),
                request.getNewPassword()
        );
    }

    @GetMapping
    public java.util.List<User> getAllUsers() {
        return service.getAllUsers();
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }



}