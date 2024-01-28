package com.priceCalaV2.price.calculator.controller;

import com.priceCalaV2.price.calculator.dto.ProductDTO;
import com.priceCalaV2.price.calculator.entity.Product;
import com.priceCalaV2.price.calculator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product")
@CrossOrigin
public class ProductController {
   @Autowired
    private ProductService productService;

   @GetMapping(path = "/getbyid",params = "id")
    public Product findByProdit(@RequestParam(value = "id") int prodid){
       Product product = productService.findByProdit(prodid);
       System.out.println(product);
       return product;
   }
}
