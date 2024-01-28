package com.priceCalaV2.price.calculator.service.impl;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.dto.PriceDTO;
import com.priceCalaV2.price.calculator.entity.Price;
import com.priceCalaV2.price.calculator.entity.Product;
import com.priceCalaV2.price.calculator.repo.PriceRepo;
import com.priceCalaV2.price.calculator.service.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

//where we develop the logic
public class PriceServiceIMPL implements PriceService {
    @Autowired
    private PriceRepo priceRepo;

    @Override
    public Price getByProdit(int prodid) {
        Price price = priceRepo.getByProdit(prodid);
        return price;
    }

    @Override
    public ResponseEntity getPriceByProdit(int prodid , int itemcount) {
        Price price = priceRepo.getByProdit(prodid);

        //Variable initialization and declaration
        double baseprice = price.getBaseprice();
        int numofunits = price.getNumofunits();
        int requiredqty = itemcount;
        double cartonPrice = 0.00;
        double singleUnitsPrice = 0.00;
        double totalPrice = 0.00;

        if (requiredqty != 0){
            int numOfCarton = requiredqty % numofunits;
            int singleUnits = requiredqty - (numOfCarton * numofunits);

            if (numOfCarton > 2 && singleUnits != 0){
                cartonPrice = baseprice*0.8;
                singleUnitsPrice = baseprice*singleUnits*1.2;
                totalPrice = cartonPrice+singleUnitsPrice;
            }else if (numOfCarton > 2 && singleUnits == 0) {
                cartonPrice = baseprice*0.8;
                totalPrice = cartonPrice;
            } else if (numOfCarton == 0) {
                singleUnitsPrice = baseprice*singleUnits*1.2;
                totalPrice = singleUnitsPrice;
                System.out.println(totalPrice);
            }
        }else{
            throw new RuntimeException("Invalid Count");
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",totalPrice),
                HttpStatus.OK
        );
    }

}
