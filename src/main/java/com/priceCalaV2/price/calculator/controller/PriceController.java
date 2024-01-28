package com.priceCalaV2.price.calculator.controller;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.dto.PriceDTO;
import com.priceCalaV2.price.calculator.entity.Price;
import com.priceCalaV2.price.calculator.service.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/price")
@CrossOrigin
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping(path ="/gettotalprice",params = {"id","count"})
    public PriceDTO getPriceByProditEqualsAndItemcount(@RequestParam(value = "id") int prodid, @RequestParam(value = "count") int itemcount){
        PriceDTO priceDTO = priceService.getPriceByProditEqualsAndItemcount(prodid,itemcount);
        return priceDTO;
    }

}
