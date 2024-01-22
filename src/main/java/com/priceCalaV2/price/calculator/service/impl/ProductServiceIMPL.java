package com.priceCalaV2.price.calculator.service.impl;

import com.priceCalaV2.price.calculator.dto.ProductDTO;
import com.priceCalaV2.price.calculator.entity.Product;
import com.priceCalaV2.price.calculator.repo.ProductRepo;
import com.priceCalaV2.price.calculator.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceIMPL implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProductDTO getProductbyId(int prodid) {
       if (productRepo.existsById(prodid)){
           Product product = productRepo.getReferenceById(prodid);
           ProductDTO productDTO = modelMapper.map(product,ProductDTO.class);
           return productDTO;
       }else{
           throw new RuntimeException("Product not Found");
       }
    }
}
