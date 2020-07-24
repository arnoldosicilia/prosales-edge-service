package com.ironhack.erp.edgeservice.model.viewModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProviderViewModel {
    private Long id;
    private String nif;
    private String email;
    private String commercialName;
    private String fiscalName;
    private String address;
    private Date createdAt;

    public ProviderViewModel(Long id, String nif, String email, String commercialName, String fiscalName, String address, Date createdAt) {
        this.id = id;
        this.nif = nif;
        this.email = email;
        this.commercialName = commercialName;
        this.fiscalName = fiscalName;
        this.address = address;
        this.createdAt = createdAt;
    }


}
