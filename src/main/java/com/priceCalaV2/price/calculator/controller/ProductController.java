package com.priceCalaV2.price.calculator.controller;

import com.priceCalaV2.price.calculator.dto.ProductDTO;
import com.priceCalaV2.price.calculator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/item")
@CrossOrigin
public class ProductController {
   @Autowired
    private ProductService productService;

   @GetMapping(path = "/getbyid",params = "id")
    public ProductDTO getProductbyId(@RequestParam(value = "id") int prodid){
       ProductDTO productDTO = productService.getProductbyId(prodid);
       return productDTO;
   }
}
