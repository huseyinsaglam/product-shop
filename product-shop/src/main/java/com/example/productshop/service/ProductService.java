package com.example.productshop.service;

import com.example.productshop.dto.ProductDto;
import com.example.productshop.model.Product;

import java.util.List;

public interface ProductService {

     List<ProductDto> getAllProducts();

     ProductDto getProductById(Long productId);

     List<ProductDto> getProductsByCategory(String categoryName);

     ProductDto addProduct(ProductDto product);

     Boolean delete(Long id);

     ProductDto update(Long id, ProductDto project);

     List<Product> getProductsByBrands(List<String> brands);

}
