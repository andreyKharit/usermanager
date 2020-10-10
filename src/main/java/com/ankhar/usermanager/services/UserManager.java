package com.ankhar.usermanager.services;

import com.ankhar.usermanager.entities.User;
import com.ankhar.usermanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbUserService {
    private final UserRepository userRepository;

    @Autowired
    public DbUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name, String title, Long security) {
        User testUser = new User();
        testUser.setName(name);
        if (title != null) testUser.setTitle(title);
        testUser.setSecureNumber(security);
        userRepository.save(testUser);
    }
}
