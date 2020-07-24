package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.SaleDto;
import com.ironhack.erp.edgeservice.model.viewModel.SaleViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "sales-service", url = "https://prosales-sales.herokuapp.com")
public interface SalesClient {
    @GetMapping("/sales")
    public List<SaleViewModel> findAllSales();
    @GetMapping("/sales/{id}")
    public SaleViewModel findSaleById(@PathVariable String id);
    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public SaleViewModel createSale(@RequestBody SaleDto sale);
    @DeleteMapping("/sales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(@PathVariable String id);
}
