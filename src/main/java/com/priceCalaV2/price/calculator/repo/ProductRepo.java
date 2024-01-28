package com.priceCalaV2.price.calculator.repo;

import com.priceCalaV2.price.calculator.entity.Product;
import com.priceCalaV2.price.calculator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,Integer> {

Product findByProdit(int prodid);
}
