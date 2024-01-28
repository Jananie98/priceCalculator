package com.priceCalaV2.price.calculator.service;

import com.priceCalaV2.price.calculator.dto.ProductDTO;
import com.priceCalaV2.price.calculator.entity.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    Product findByProdit(int prodid);
}
