package com.example.movieplanet.service;

import com.example.movieplanet.dao.UserRepository;
import com.example.movieplanet.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean validateUser(String email, String password) {
        return userRepository.existsByUserEmailAndPassword(email, password);
    }

    public Users registerUser(Users user) {
        return userRepository.save(user);
    }

    public boolean isUserVip(String email) {
        return userRepository.isUserVip(email);
    }

    public boolean isUserAdmin(String email) {
        return userRepository.isUserAdmin(email);
    }
}
