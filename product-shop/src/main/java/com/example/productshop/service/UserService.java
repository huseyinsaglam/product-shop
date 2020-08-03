package com.example.productshop.service;

import com.example.productshop.model.User;

import java.util.List;

public interface UserService {


    User getByUsernameAndPass(String username, String pass);

    User getByUsername(String username);

    User save(User user);

    List<User> findAll();

    List<User> getAllProducts();

}
