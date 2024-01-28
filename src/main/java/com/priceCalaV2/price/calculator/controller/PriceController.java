package com.priceCalaV2.price.calculator.controller;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.entity.Price;
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

    @GetMapping(path ="/gettotalprice",params = {"id","count"})
    public ResponseEntity<StandardResponse> getPriceByProdit(@RequestParam(value = "id") int prodid, @RequestParam(value = "count") int itemcount){
        ResponseEntity response = priceService.getPriceByProdit(prodid,itemcount);
        System.out.println(response);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",response),
                HttpStatus.OK
        );
    }

}
