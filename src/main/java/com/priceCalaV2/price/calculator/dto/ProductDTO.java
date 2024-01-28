package com.priceCalaV2.price.calculator.dto;

import com.priceCalaV2.price.calculator.entity.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private int prodit;
    private ProductType prodname;
}
