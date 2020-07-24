package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.SaleDto;
import com.ironhack.erp.edgeservice.model.viewModel.SaleViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SaleControllerInterface {
    public List<SaleViewModel> findAllSales();
    public SaleViewModel findSaleById(@PathVariable String id);
    public SaleViewModel createSale(@RequestBody SaleDto sale);
    public void deleteSale(@PathVariable String id);
}
