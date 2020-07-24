package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.ProductDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProductViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-service", url = "https://prosales-product.herokuapp.com")
public interface ProductClient {
    @GetMapping("/products")
    public List<ProductViewModel> findAll();
    @GetMapping("/products/{id}")
    public ProductViewModel findById(@PathVariable Long id);
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductViewModel createProduct(@RequestBody ProductDto product);
    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id);
    @PostMapping("products/{id}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void decreaseAmount(@PathVariable Long id, @PathVariable Integer amount);
}
