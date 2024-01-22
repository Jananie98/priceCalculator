package com.priceCalaV2.price.calculator.service;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.dto.PriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {
    ResponseEntity<StandardResponse> getTotalPrice(int prodid, int itemcount);
}
