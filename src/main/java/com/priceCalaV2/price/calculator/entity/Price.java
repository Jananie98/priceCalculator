package com.priceCalaV2.price.calculator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="price")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {
    @Id
    @Column(name = "priceid")
    private Integer priceid;

    @Column(name = "numofunits")
    private Integer numofunits;

    @Column(name = "baseprice")
    private Double baseprice;

    @Column(name = "totalprice")
    private Double totalprice;

    @Column(name = "itemcount")
    private Integer itemcount;

    @Column(name = "prodit")
    private Integer prodit;

//    @JoinColumn(name = "prodit" , referencedColumnName ="prodit")
//    @OneToOne(optional = false, fetch = FetchType.EAGER)
//    private Product prodit;
}
