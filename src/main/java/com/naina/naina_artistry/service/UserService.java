package com.naina.naina_artistry.service;

import com.naina.naina_artistry.model.User;
import com.naina.naina_artistry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public String login(String email, String password) {

        if (email == null || email.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            return "Invalid Credentials";
        }

        List<User> users = repo.findByEmail(email.trim());

        if (users.isEmpty()) {
            return "Invalid Credentials";
        }

        for (User user : users) {
            if (user.getPassword().equals(password.trim())) {
                return "Login Successful";
            }
        }

        return "Invalid Credentials";
    }

    // CHANGE PASSWORD
    public String changePassword(String email, String oldPassword, String newPassword) {

        List<User> users = repo.findByEmail(email);

        if (users.isEmpty()) {
            return "User not found";
        }

        User user = users.get(0);

        if (!user.getPassword().equals(oldPassword)) {
            return "Old password is incorrect";
        }

        user.setPassword(newPassword);
        repo.save(user);

        return "Password changed successfully";
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }
}