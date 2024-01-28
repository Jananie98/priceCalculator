package com.priceCalaV2.price.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.priceCalaV2")
public class PriceCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceCalculatorApplication.class, args);
	}

}
