package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.ProductClient;
import com.ironhack.erp.edgeservice.model.dto.ProductDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductClient productClient;

    public List<ProductViewModel> findAll() {
        return productClient.findAll();
    }

    public ProductViewModel findById(Long id) {
        return productClient.findById(id);
    }

    public ProductViewModel createProduct(ProductDto product) {
        return productClient.createProduct(product);
    }

    public void deleteProduct(Long id) {
        productClient.deleteProduct(id);
    }

    public void decreaseAmount(Long id, Integer amount) {
        productClient.decreaseAmount(id, amount);
    }
}
