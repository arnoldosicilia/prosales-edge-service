package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.CompanyControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.CompanyDto;
import com.ironhack.erp.edgeservice.model.viewModel.CompanyViewModel;
import com.ironhack.erp.edgeservice.service.CompanyService;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CompanyControllerImpl implements CompanyControllerInterface {

    @Autowired
    CompanyService companyService;

    @ApiOperation(value = "Get all the companies")
    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyViewModel> findAll() {
        return companyService.findAll();
    }

    @ApiOperation(value = "Get a contact by its ID if exists")
    @GetMapping("/companies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyViewModel findById(@PathVariable Long id) {
        return companyService.findById(id);
    }

    @ApiOperation(value = "Insert a new company in the system")
    @PostMapping("/companies")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyViewModel create(@RequestBody CompanyDto company) {
        return companyService.create(company);
    }

    @ApiOperation(value = "Delete a company if exists in the system")
    @DeleteMapping("/companies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }
}
