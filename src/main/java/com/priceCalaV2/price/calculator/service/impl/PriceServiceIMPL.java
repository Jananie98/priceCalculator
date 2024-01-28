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
    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public Price findByProdit(int prodid) {
        return null;
    }

    @Override
    public PriceDTO getPriceByProditEqualsAndItemcount(int prodid , int itemcount) {
        Price price = priceRepo.findByProdit(prodid);
//        System.out.println(prodid);
        //Variable initialization and declaration
        double baseprice = price.getBaseprice();
//        System.out.println(baseprice);
        int numofunits = price.getNumofunits();
//        System.out.println(numofunits);
        int requiredqty = itemcount;
//        System.out.println("XOXO");
//        System.out.println(requiredqty);
//        System.out.println("XOXO - param");
//        System.out.println(itemcount);
        double cartonPrice = 0.00;
        double singleUnitsPrice = 0.00;
        double totalPrice = 0.00;

        if (requiredqty != 0){
            int numOfCarton = requiredqty / numofunits;

            System.out.println(numOfCarton);
            int singleUnits = requiredqty - (numOfCarton * numofunits);
            System.out.println(singleUnits);

            if (numOfCarton > 2 && singleUnits != 0){
                cartonPrice = baseprice*0.8;
                singleUnitsPrice = baseprice*singleUnits*1.2;
                totalPrice = cartonPrice+singleUnitsPrice;
                System.out.println("Methana newei");
                System.out.println(cartonPrice);
                System.out.println(singleUnits);
                System.out.println(totalPrice);
            }else if (numOfCarton > 2 && singleUnits == 0) {
                cartonPrice = baseprice*0.8;
                totalPrice = cartonPrice;
                System.out.println("Methanath newei");
                System.out.println(cartonPrice);
//                System.out.println(singleUnits);
                System.out.println(totalPrice);
            } else if (numOfCarton == 0) {
                singleUnitsPrice = baseprice*singleUnits*1.2;
                totalPrice = singleUnitsPrice;
                System.out.println("Menna methana");
                System.out.println();
                System.out.println(singleUnitsPrice);
                System.out.println(totalPrice);
            }
        }else{
            throw new RuntimeException("Invalid Count");
        }

        System.out.println(totalPrice);
        price.setTotalprice(totalPrice);
        PriceDTO priceDTO = modelMapper.map(price,PriceDTO.class);
        System.out.println("Methenta ennawada??");
        return priceDTO;

    }

}
