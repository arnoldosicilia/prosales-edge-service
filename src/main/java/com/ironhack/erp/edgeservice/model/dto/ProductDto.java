package com.ironhack.erp.edgeservice.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String provRef;
    private String ean;
    private String img;
    private BigDecimal pvd;
    private BigDecimal pvp;
    private Integer stock;

    public ProductDto(String name, String provRef, String ean, String img, BigDecimal pvd, BigDecimal pvp, Integer stock) {
        this.name = name;
        this.provRef = provRef;
        this.ean = ean;
        this.img = img;
        this.pvd = pvd;
        this.pvp = pvp;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvRef() {
        return provRef;
    }

    public void setProvRef(String provRef) {
        this.provRef = provRef;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getPvd() {
        return pvd;
    }

    public void setPvd(BigDecimal pvd) {
        this.pvd = pvd;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
