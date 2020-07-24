package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.SaleControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.SaleDto;
import com.ironhack.erp.edgeservice.model.viewModel.SaleViewModel;
import com.ironhack.erp.edgeservice.service.SaleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SalesControllerImpl implements SaleControllerInterface {
    @Autowired
    SaleService saleService;

    @ApiOperation(value = "Get all the sales")
    @GetMapping("/sales")
    @ResponseStatus(HttpStatus.OK)
    public List<SaleViewModel> findAllSales() {
        return saleService.findAllSales();
    }

    @ApiOperation(value = "Get a sale by a given id")
    @GetMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SaleViewModel findSaleById(@PathVariable String id) {
        return saleService.findSaleById(id);
    }

    @ApiOperation(value = "Insert a new sale in the system")
    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public SaleViewModel createSale(@RequestBody SaleDto sale) {
        return saleService.createSale(sale);
    }

    @ApiOperation(value = "Delete a sale if exist by a given id")
    @DeleteMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable String id) {
        saleService.deleteSale(id);
    }
}
