package com.example.productshop.controller;

import com.example.productshop.dto.ProductDto;
import com.example.productshop.model.Product;
import com.example.productshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    public static String url = "http://localhost:8080/products";

    @Autowired
    ProductService productService;



/*    @RequestMapping
    public String defaultPage(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "redirect:/products/all";
    }*/


    @RequestMapping
    public String defaultPage(Model model, HttpServletRequest request) {
        model.addAttribute("user",request.getSession().getAttribute("user"));
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }


    @RequestMapping("/all")
    public String allProducts(Model model,HttpServletRequest request) {
        model.addAttribute("user",request.getSession().getAttribute("user"));
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam(name = "id") Long productId, Model model,HttpServletRequest request) {
        model.addAttribute("user",request.getSession().getAttribute("user"));
        ProductDto product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "productDetail";
    }

    @RequestMapping("/category/{categoryName}")
    public String listProductsByCategoryNamed(@PathVariable(name = "categoryName") String categoryName, Model model,HttpServletRequest request) {
        model.addAttribute("user",request.getSession().getAttribute("user"));
        List<ProductDto> products = productService.getProductsByCategory(categoryName);
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/brand/{brands}")
    public String listProductsByBrands(@MatrixVariable(pathVar = "brands") List<String> brands, Model model,HttpServletRequest request) {
        model.addAttribute("user",request.getSession().getAttribute("user"));
        List<Product> products = productService.getProductsByBrands(brands);
        model.addAttribute("products", products);
        return "productList";
    }


}
