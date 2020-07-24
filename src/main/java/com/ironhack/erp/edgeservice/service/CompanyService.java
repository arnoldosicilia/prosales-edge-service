package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.CompanyClient;
import com.ironhack.erp.edgeservice.model.dto.CompanyDto;
import com.ironhack.erp.edgeservice.model.viewModel.CompanyViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyClient companyClient;

    public List<CompanyViewModel> findAll() {
        return companyClient.findAll();
    }
    public CompanyViewModel findById(Long id) {
        return companyClient.findById(id);
    }

    public CompanyViewModel create(CompanyDto company) {
        return companyClient.create(company);
    }
    public void delete(Long id) {
        companyClient.delete(id);
    }

}
