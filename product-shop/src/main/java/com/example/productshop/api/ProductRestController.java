package com.example.productshop.api;

import com.example.productshop.dto.ProductDto;
import com.example.productshop.service.impl.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private final ProductServiceImpl productService;

    public ProductRestController(ProductServiceImpl productService)
    {
        this.productService = productService;
    }


    @PostMapping(produces = "application/json")
    public ResponseEntity<ProductDto> createProject(@Valid @RequestBody ProductDto product)
    {

        return ResponseEntity.ok(productService.addProduct(product));

    }

    @DeleteMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(productService.delete(id));

    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ProductDto>> getAll()
    {
        List<ProductDto> data = productService.getAllProducts();
        return ResponseEntity.ok(data);
    }
}
