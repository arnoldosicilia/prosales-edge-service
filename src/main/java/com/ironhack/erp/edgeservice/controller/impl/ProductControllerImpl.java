package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.controller.interfaces.ProductControllerInterface;
import com.ironhack.erp.edgeservice.model.dto.ProductDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProductViewModel;
import com.ironhack.erp.edgeservice.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductControllerImpl implements ProductControllerInterface {
    @Autowired
    ProductService productService;

    @ApiOperation(value = "Get all the products")
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductViewModel> findAll() {
        return productService.findAll();
    }

    @ApiOperation(value = "Get a product by id if exists")
    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductViewModel findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @ApiOperation(value = "Insert a new product in the system")
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductViewModel createProduct(@RequestBody ProductDto product) {
        return productService.createProduct(product);
    }

    @ApiOperation(value = "Delete a product in the system by its id")
    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @ApiOperation(value = "Decrease the stock of a product . First param is the id of the product the second param is the amount you want to decrease")
    @PostMapping("products/{id}/{amount}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void decreaseAmount(@PathVariable Long id, @PathVariable Integer amount) {
        productService.decreaseAmount(id, amount);
    }
}
