package com.ironhack.erp.edgeservice.controller.impl;


import com.ironhack.erp.edgeservice.controller.interfaces.ClientControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import com.ironhack.erp.edgeservice.service.ClientService;
import com.netflix.ribbon.proxy.annotation.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ClientControllerImpl implements ClientControllerInterface {

    @Autowired
    ClientService clientService;

    @Operation(summary = "Find All clients",
            description = "This end-point provides the list of all clients")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientViewModel> findAll(){ return clientService.findAll();}

    @Operation(summary = "Find client by Id",
            description = "This end-point provides a client with the same Id as given")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful operation")})
    @GetMapping("/client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientViewModel findById(@PathVariable Long id){ return clientService.findById(id);}


    @Operation(summary = "Create a new client ",
            description = "This end-point provides a client with the same Id as given")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successful operation")})
    @PostMapping("/client")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel createClient(@RequestBody ClientDto client){ return clientService.createClient(client);}


    @Operation(summary = "Update a client",
            description = "This end-point provides a client with the same Id as given")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successful operation")})
    @PutMapping("/client/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientViewModel updateClient(@RequestBody ClientDto client, @PathVariable Long id){ return clientService.updateClient(client, id);}


    @Operation(summary = "Delete a client",
            description = "This end-point delete the client with the same Id as given")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successful operation")})
    @DeleteMapping("/client/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id){ clientService.deleteClient(id);}

}
