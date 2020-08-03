package com.example.productshop.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productCode;
    private String name;

    private double unit_price;
    private String description;
    private String manufacturer;
    private String status;
    private String category;
    private long unitsInStock;
}
