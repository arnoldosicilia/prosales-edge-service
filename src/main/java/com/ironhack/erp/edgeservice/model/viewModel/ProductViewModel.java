package com.ironhack.erp.edgeservice.model.viewModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductViewModel {
    private Long id;
    private String name;
    private String provRef;
    private String ean;
    private String img;
    private BigDecimal pvd;
    private BigDecimal pvp;
    private Integer stock;
    private Date createdAt;

    public ProductViewModel(Long id, String name, String provRef, String ean, String img, BigDecimal pvd, BigDecimal pvp, Integer stock, Date createdAt) {
        this.id = id;
        this.name = name;
        this.provRef = provRef;
        this.ean = ean;
        this.img = img;
        this.pvd = pvd;
        this.pvp = pvp;
        this.stock = stock;
        this.createdAt = createdAt;
    }


}
