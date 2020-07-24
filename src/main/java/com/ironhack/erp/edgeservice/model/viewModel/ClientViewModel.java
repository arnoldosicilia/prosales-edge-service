package com.ironhack.erp.edgeservice.model.viewModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class ClientViewModel {
    private Long id;
    private String nif;
    private String email;
    private String commercialName;
    private String fiscalName;
    private String address;
    private String city;
    private String province;
    private Integer zipCode;
    private String country;
    private String web;
    private String telNumber;
    private Long credit;
    private Date createdAt;

    public ClientViewModel(Long id, String nif, String email, String commercialName, String fiscalName, String address, String city, String province, Integer zipCode, String country, String web, String telNumber, Long credit, Date createdAt) {
        this.id = id;
        this.nif = nif;
        this.email = email;
        this.commercialName = commercialName;
        this.fiscalName = fiscalName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
        this.country = country;
        this.web = web;
        this.telNumber = telNumber;
        this.credit = credit;
        this.createdAt = createdAt;
    }


}
