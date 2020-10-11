package com.ankhar.usermanager.services;

import com.ankhar.usermanager.entities.User;
import com.ankhar.usermanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserManager implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUser(Long id, String name, String title, Long code) {
        User newUser = userRepository.findById(id).orElseGet(User::new);
        newUser.setName(name);
        if (title != null) newUser.setTitle(title);
        newUser.setSecureNumber(code);
        userRepository.save(newUser);
    }

    public User createUser(String name, String title, Long code) {
        User newUser = new User();
        newUser.setName(name);
        if (title != null) newUser.setTitle(title);
        newUser.setSecureNumber(code);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
    }
}
