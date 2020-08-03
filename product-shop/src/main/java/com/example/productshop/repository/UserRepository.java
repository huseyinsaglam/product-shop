package com.example.productshop.repository;

import com.example.productshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User getByUsernameAndPass(String username, String pass);

    User getByUsername(String username);

    List<User> findAll();




}
