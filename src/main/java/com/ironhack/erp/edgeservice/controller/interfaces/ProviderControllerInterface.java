package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.ProviderDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProviderViewModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProviderControllerInterface {
    List<ProviderViewModel> findAll();
    ProviderViewModel findById(@PathVariable Long id);
    ProviderViewModel create(@RequestBody ProviderDto provider);
    void delete(@PathVariable Long id);
}
