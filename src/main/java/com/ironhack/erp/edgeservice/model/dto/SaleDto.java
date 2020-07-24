package com.ironhack.erp.edgeservice.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaleDto {
    private Long author;
    private Long client;
    private List<Long> products;
    private String paymentMethod;
    private BigDecimal deposited;
    private BigDecimal total;
    private BigDecimal remaining;
    private BigDecimal discount;
    private BigDecimal tax;

    public SaleDto(Long author, Long client, List<Long> products, String paymentMethod, BigDecimal deposited, BigDecimal total, BigDecimal remaining, BigDecimal discount, BigDecimal tax) {
        this.author = author;
        this.client = client;
        this.products = products;
        this.paymentMethod = paymentMethod;
        this.deposited = deposited;
        this.total = total;
        this.remaining = remaining;
        this.discount = discount;
        this.tax = tax;
    }


}
