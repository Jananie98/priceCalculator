package com.priceCalaV2.price.calculator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "prodit")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer prodit;

    @Enumerated(EnumType.STRING)
    @Column(name = "prodname")
    private ProductType prodname;
}
