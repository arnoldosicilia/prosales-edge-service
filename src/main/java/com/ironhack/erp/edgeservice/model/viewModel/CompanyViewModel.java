package com.ironhack.erp.edgeservice.model.viewModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyViewModel {
    private Long id;
    private String name;

    public CompanyViewModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
