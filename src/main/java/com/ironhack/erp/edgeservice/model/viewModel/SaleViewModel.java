package com.ironhack.erp.edgeservice.model.viewModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SaleViewModel {
    private String id;
    private Long author;
    private Long client;
    private List<Long> products;
    private String paymentMethod;
    private BigDecimal deposited;
    private BigDecimal total;
    private BigDecimal remaining;
    private BigDecimal discount;
    private BigDecimal tax;
    private Date createdAt;

    public SaleViewModel(String id, Long author, Long client, List<Long> products, String paymentMethod, BigDecimal deposited, BigDecimal total, BigDecimal remaining, BigDecimal discount, BigDecimal tax, Date createdAt) {
        this.id = id;
        this.author = author;
        this.client = client;
        this.products = products;
        this.paymentMethod = paymentMethod;
        this.deposited = deposited;
        this.total = total;
        this.remaining = remaining;
        this.discount = discount;
        this.tax = tax;
        this.createdAt = createdAt;
    }


}
