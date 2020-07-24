package com.ironhack.erp.edgeservice.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProviderDto {
    private String nif;
    private String email;
    private String commercialName;
    private String fiscalName;
    private String address;

    public ProviderDto(String nif, String email, String commercialName, String fiscalName, String address) {
        this.nif = nif;
        this.email = email;
        this.commercialName = commercialName;
        this.fiscalName = fiscalName;
        this.address = address;
    }
}
