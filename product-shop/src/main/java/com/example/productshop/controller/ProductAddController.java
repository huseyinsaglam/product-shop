package com.example.productshop.controller;

import com.example.productshop.dto.ProductDto;
import com.example.productshop.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductAddController {


    @Autowired
    ProductServiceImpl productService;

    @ModelAttribute("categoryList")
    public List<String> prepareCategories() {
        System.out.println("categoryList#invoked!");
        return Arrays.asList("Tablet","Laptop","SmartPhone");
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    //JSp sayfasindaki modelAttribute ile ayni isimde olmalidi! yoksa exception verir!
    public String addProductPage(@ModelAttribute("newProduct") ProductDto productToAdded) {
        System.out.println("addProductPage#get invoked!");

        return "productAdd";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProductPageSubmit(@ModelAttribute("newProduct") @Valid ProductDto productToAdded)  {

        productService.addProduct(productToAdded);
        return "redirect:/products";
    }
}
