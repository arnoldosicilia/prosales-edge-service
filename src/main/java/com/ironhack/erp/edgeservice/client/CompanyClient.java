package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.CompanyDto;
import com.ironhack.erp.edgeservice.model.viewModel.CompanyViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "company-service", url = "https://prosales-company.herokuapp.com")
public interface CompanyClient {
    @GetMapping("/companies")
    public List<CompanyViewModel> findAll();

    @GetMapping("/companies/{id}")
    public CompanyViewModel findById(@PathVariable Long id);

    @PostMapping("/companies")
    public CompanyViewModel create(@RequestBody CompanyDto company);

    @DeleteMapping("/companies/{id}")
    public void delete(@PathVariable Long id);
}
