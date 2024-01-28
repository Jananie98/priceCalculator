package com.priceCalaV2.price.calculator.repo;

import com.priceCalaV2.price.calculator.StandardResponse;
import com.priceCalaV2.price.calculator.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PriceRepo extends JpaRepository<Price,Integer> {

    Price findByProdit(int prodid);

    Price findByProditEqualsAndItemcountEquals(int prodid , int itemcount) ;
    Price getPriceByProditEqualsAndItemcount(int prodid , int itemcount) ;



}
