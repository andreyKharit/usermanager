package com.ankhar.usermanager.services;

import com.ankhar.usermanager.entities.User;

import java.util.List;

public interface UserService {
    void updateUser(Long id, String name, String title, Long code);

    User initializeNewUser();

    List<User> getAllUsers();

    User getById(Long id);

    void deleteById(Long id);
}
