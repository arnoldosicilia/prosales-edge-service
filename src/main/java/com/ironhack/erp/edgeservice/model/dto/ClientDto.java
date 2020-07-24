package com.ironhack.erp.edgeservice.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {
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

    public ClientDto(String nif, String email, String commercialName, String fiscalName, String address, String city, String province, Integer zipCode, String country, String web, String telNumber, Long credit) {
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
    }


}
