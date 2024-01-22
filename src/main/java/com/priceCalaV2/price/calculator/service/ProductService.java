package com.priceCalaV2.price.calculator.service;

import com.priceCalaV2.price.calculator.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductDTO getProductbyId(int prodid);
}
