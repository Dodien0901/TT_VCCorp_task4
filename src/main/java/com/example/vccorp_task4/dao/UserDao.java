package com.example.vccorp_task4.dao;

import com.example.vccorp_task4.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void addUser(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
    void updateUser(User user) throws SQLException;
    User findById(int id) throws SQLException;
    List<User> findByName(String name) throws SQLException;
    List<User> findByAddress(String address) throws SQLException;
    List<User> findAll() throws SQLException;
}