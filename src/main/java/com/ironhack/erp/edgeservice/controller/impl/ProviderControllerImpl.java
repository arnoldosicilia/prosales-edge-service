package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.model.dto.ProviderDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProviderViewModel;
import com.ironhack.erp.edgeservice.service.ProviderService;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProviderControllerImpl implements com.ironhack.erp.edgeservice.controller.interfaces.ProviderControllerInterface {

    @Autowired
    ProviderService providerService;

    @Override
    @ApiOperation(value = "Get all providers in the system")
    @GetMapping("/providers")
    public List<ProviderViewModel> findAll() {
        return providerService.findAll();
    }

    @Override
    @ApiOperation(value = "Get a provider by id if it is in the system")
    @GetMapping("/providers/{id}")
    public ProviderViewModel findById(@PathVariable Long id) {
        return providerService.findById(id);
    }

    @Override
    @ApiOperation(value = "Insert a new provider in the system")
    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public ProviderViewModel create(@RequestBody ProviderDto provider) {
        return providerService.create(provider);
    }

    @Override
    @ApiOperation(value = "Delete a provider in the system by its id")
    @DeleteMapping("/providers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        providerService.delete(id);
    }
}
