package com.example.productshop.controller;

import com.example.productshop.model.User;
import com.example.productshop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/user")
public class KullanicilarController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/kullanicilar")
    public String kullanicilarPage(Model model)
    {
        List<User> data = userService.getAllProducts();
        System.out.println(data);
        model.addAttribute("data",data);
        return "kullanicilarList";

    }
}
