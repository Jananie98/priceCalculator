package com.priceCalaV2.price.calculator.dto;

import com.priceCalaV2.price.calculator.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceDTO {

    private Integer numofunits;
    private Double baseprice;
    private Product prodit;
}
