package com.example.productshop.service.impl;

import com.example.productshop.model.User;
import com.example.productshop.repository.UserRepository;
import com.example.productshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getByUsernameAndPass(String username, String pass) {
        return userRepository.getByUsernameAndPass(username,pass);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllProducts() {
        return userRepository.findAll();
    }


}
