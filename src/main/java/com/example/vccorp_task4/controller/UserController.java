package com.example.vccorp_task4.controller;

import com.example.vccorp_task4.model.User;
import com.example.vccorp_task4.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public void addUser(User user) {
        try {
            userService.addUser(user);
            System.out.println("User added successfully");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

    public void deleteUser(int id) {
        try {
            userService.deleteUser(id);
            System.out.println("User deleted successfully");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        }
    }

    public void updateUser(User user) {
        try {
            userService.updateUser(user);
            System.out.println("User updated successfully");
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Error updating user: " + e.getMessage());
        }
    }

    public User findById(int id) {
        try {
            return userService.findById(id);
        } catch (SQLException e) {
            System.err.println("Error finding user: " + e.getMessage());
            return null;
        }
    }

    public List<User> findByName(String name) {
        try {
            return userService.findByName(name);
        } catch (SQLException e) {
            System.err.println("Error finding users: " + e.getMessage());
            return null;
        }
    }

    public List<User> findByAddress(String address) {
        try {
            return userService.findByAddress(address);
        } catch (SQLException e) {
            System.err.println("Error finding users: " + e.getMessage());
            return null;
        }
    }

    public List<User> findAllSortedByName() {
        try {
            return userService.findAllSortedByName();
        } catch (SQLException e) {
            System.err.println("Error finding users: " + e.getMessage());
            return null;
        }
    }
}