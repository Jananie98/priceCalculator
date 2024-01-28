package com.priceCalaV2.price.calculator.service.impl;

import com.priceCalaV2.price.calculator.dto.ProductDTO;
import com.priceCalaV2.price.calculator.entity.Product;
import com.priceCalaV2.price.calculator.repo.ProductRepo;
import com.priceCalaV2.price.calculator.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductServiceIMPL implements ProductService {
    @Autowired
    private ProductRepo productRepo ;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Product findByProdit(int prodid) {
        System.out.println(prodid);
        Product product = productRepo.findByProdit(prodid);
        System.out.println(product);
//        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return product;
    }
}
