package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.ProviderDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProviderViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "provider-service", url = "https://prosales-provider.herokuapp.com")
public interface ProviderClient {
    @GetMapping("/providers")
    public List<ProviderViewModel> findAll();
    @GetMapping("/providers/{id}")
    public ProviderViewModel findById(@PathVariable Long id);
    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public ProviderViewModel create(@RequestBody ProviderDto provider);
    @DeleteMapping("/providers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id);
}
