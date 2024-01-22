package com.priceCalaV2.price.calculator.service.impl;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.dto.PriceDTO;
import com.priceCalaV2.price.calculator.entity.Price;
import com.priceCalaV2.price.calculator.repo.PriceRepo;
import com.priceCalaV2.price.calculator.service.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//where we develop the logic
public class PriceServiceIMPL implements PriceService {
    @Autowired
    private PriceRepo priceRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<StandardResponse> getTotalPrice(int prodid, int itemcount) {
        if (priceRepo.existsById(prodid)){
            int baseprice = priceRepo.getByBasepriceEquals(prodid);
            int numofunits = priceRepo.getByNumofunitsEquals(prodid);
            double cartonPrice ;
            double singleUnitsPrice;
            double totalPrice = 0.00;

            if (numofunits != 0){
                int numOfCarton = itemcount % numofunits;
                int singleUnits = itemcount - (numOfCarton * numofunits);

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
                }
            }else{
                throw new RuntimeException("Invalid Count");
            }

            // calculation done
            // need to send total price to frontend through response
            // may be a response dto?

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"Success",totalPrice),
                    HttpStatus.OK
            );

        }else{
            throw new RuntimeException("Product do not Exists");
        }
    }
}
