package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.ProductDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProductViewModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductControllerInterface {
    public List<ProductViewModel> findAll();
    public ProductViewModel findById(@PathVariable Long id);
    public ProductViewModel createProduct(@RequestBody ProductDto product);
    public void deleteProduct(@PathVariable Long id);
    public void decreaseAmount(Long id, Integer amount);
}
