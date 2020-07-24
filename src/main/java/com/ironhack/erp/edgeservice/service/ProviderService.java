package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.ProviderClient;
import com.ironhack.erp.edgeservice.model.dto.ProviderDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProviderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    ProviderClient providerClient;


    public List<ProviderViewModel> findAll() {
        return providerClient.findAll();
    }

    public ProviderViewModel findById(Long id) {
        return providerClient.findById(id);
    }

    public ProviderViewModel create(ProviderDto provider) {
        return providerClient.create(provider);
    }

    public void delete(Long id) {
        providerClient.delete(id);
    }
}
