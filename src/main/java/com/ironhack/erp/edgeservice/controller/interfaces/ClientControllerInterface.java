package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientControllerInterface {
    public List<ClientViewModel> findAll();
    public ClientViewModel findById(Long id);
    public ClientViewModel createClient(ClientDto client);
    public void deleteClient(Long id);
}
