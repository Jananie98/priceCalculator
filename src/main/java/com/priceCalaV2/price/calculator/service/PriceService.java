package com.priceCalaV2.price.calculator.service;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.dto.PriceDTO;
import com.priceCalaV2.price.calculator.entity.Price;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface PriceService {

    Price findByProdit(int prodid);
    PriceDTO getPriceByProditEqualsAndItemcount(int prodid , int itemcount);


}
