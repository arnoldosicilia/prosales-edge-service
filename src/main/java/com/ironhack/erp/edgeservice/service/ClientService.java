package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.ClientClient;
import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientClient clientClient;

    public List<ClientViewModel> findAll(){ return clientClient.findAll();}
    public ClientViewModel findById(@PathVariable Long id){ return clientClient.findById(id);}
    public ClientViewModel createClient(@RequestBody ClientDto client){ return clientClient.createClient(client);}
    public ClientViewModel updateClient(@RequestBody ClientDto client, Long id){return clientClient.updateClient(client, id);}
    public void deleteClient(@PathVariable Long id){ clientClient.deleteClient(id);}

}
