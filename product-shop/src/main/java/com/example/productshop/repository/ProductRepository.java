package com.example.productshop.repository;

import com.example.productshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> getProductsByCategory(String categoryName);
    Product getByProductCode(String productCode);
    Product getByProductCodeAndIdNot(String productCode, Long id);


}
