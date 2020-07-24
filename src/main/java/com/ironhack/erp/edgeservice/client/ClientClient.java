package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("client-service")
public interface ClientClient {
    @GetMapping("/clients")
    public List<ClientViewModel> findAll();
    @GetMapping("/clients/{id}")
    public ClientViewModel findById(@PathVariable Long id);
    @PostMapping("/clients")
    public ClientViewModel createClient(@RequestBody ClientDto client);
    @PostMapping("/clients")
    public ClientViewModel updateClient(@RequestBody ClientDto client,@PathVariable Long id );

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id);

}
