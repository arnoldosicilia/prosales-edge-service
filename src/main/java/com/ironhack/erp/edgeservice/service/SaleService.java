package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.SalesClient;
import com.ironhack.erp.edgeservice.model.dto.SaleDto;
import com.ironhack.erp.edgeservice.model.viewModel.SaleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    SalesClient salesClient;

    public List<SaleViewModel> findAllSales() {
        return salesClient.findAllSales();
    }

    public SaleViewModel findSaleById(String id) {
        return salesClient.findSaleById(id);
    }

    public SaleViewModel createSale(SaleDto sale) {
        return salesClient.createSale(sale);
    }

    public void deleteSale(String id) {
        salesClient.deleteSale(id);
    }
}
