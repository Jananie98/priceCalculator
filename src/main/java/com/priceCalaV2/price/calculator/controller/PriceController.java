package com.priceCalaV2.price.calculator.controller;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.dto.PriceDTO;
import com.priceCalaV2.price.calculator.repo.PriceRepo;
import com.priceCalaV2.price.calculator.service.PriceService;
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
    @GetMapping(path = "/getbyid" , params = {"id","count"})
    public ResponseEntity<StandardResponse> getTotalPrice(@RequestParam(value = "id") int prodid, @RequestParam(value = "count") int itemcount){
        ResponseEntity<StandardResponse> response = priceService.getTotalPrice(prodid,itemcount);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",response),
                HttpStatus.OK
        );
    }
}
