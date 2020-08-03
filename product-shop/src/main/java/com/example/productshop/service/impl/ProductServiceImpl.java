package com.example.productshop.service.impl;

import com.example.productshop.dto.ProductDto;
import com.example.productshop.model.Product;
import com.example.productshop.repository.ProductRepository;
import com.example.productshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository,ModelMapper modelMapper)
    {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> data =  productRepository.findAll();
        List<ProductDto> projectDto = Arrays.asList(modelMapper.map(data, ProductDto[].class));
        return projectDto;
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product =  productRepository.getOne(productId);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    @Override
    public List<ProductDto> getProductsByCategory(String categoryName) {

        List<Product> products =  productRepository.getProductsByCategory(categoryName);
        List<ProductDto> productDto = Arrays.asList(modelMapper.map(products, ProductDto[].class));
        return productDto;
    }


    @Override
    public ProductDto addProduct(ProductDto product) {

        Product productCheck = productRepository.getByProductCode(product.getProductCode());

        if (productCheck != null) {
            throw new IllegalArgumentException("Product Code Already Exist");
        }

        Product productData = modelMapper.map(product, Product.class);

        productData = productRepository.save(productData);

        return product;

    }

    @Override
    public Boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;
    }



    @Override
    public ProductDto update(Long id, ProductDto product) {

        Product productdb = productRepository.getOne(id);

        if (productdb == null) {
            throw new IllegalArgumentException("Product Does Not Exist ID:" + id);
        }

        // Ayni product kodu ile birden fazla proje kaydi olusturmamak icin kontrol yaptik..
        // product Kodu su olan (project.getProductCode() ) ve Id' si suan mevcut duzenlemeye calistigimiz
        // id olmayan ve bize parametre gelen ( productCheck ) varsa hata ver
        Product productCheck = productRepository.getByProductCodeAndIdNot(product.getProductCode(), id);

        if (productCheck != null) {
            throw new IllegalArgumentException("Product Code Already Exist");
        }

        productdb.setProductCode(product.getProductCode());
        productdb.setName(product.getName());

        productRepository.save(productdb);

        return modelMapper.map(productdb,ProductDto.class);
    }

    @Override
    public List<Product> getProductsByBrands(List<String> brands) {
        List<Product> productsByBrands = new ArrayList<>();
        List<Product> data =  productRepository.findAll();

		for (String brand : brands) {
			for (Product product : data) {
				if (brand.equalsIgnoreCase(product.getCategory())) {
					productsByBrands.add(product);
				}
			}
		}

		return productsByBrands;
    }


}
