package com.example.productshop.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    private Long id;

    @NotNull
    private String productCode;

    @NotNull
    @Size(min = 3)
    private String name;

    private double unit_price;
    private String description;
    private String manufacturer;
    private String status;
    private String category;

    @Min(10)
    private long unitsInStock;
}
