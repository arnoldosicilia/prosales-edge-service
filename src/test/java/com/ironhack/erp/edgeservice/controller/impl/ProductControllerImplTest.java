package com.ironhack.erp.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.edgeservice.client.ProductClient;
import com.ironhack.erp.edgeservice.model.dto.ProductDto;
import com.ironhack.erp.edgeservice.model.viewModel.ProductViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProductControllerImplTest {

    @Autowired
    ProductControllerImpl productController;

    @MockBean
    ProductClient productClient;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    ProductDto productDto;
    ProductViewModel productViewModel;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        productDto = new ProductDto("test", "provider", "ean", "img", new BigDecimal("100"), new BigDecimal("110"), 5);;
        productViewModel = new ProductViewModel((long) 1, "book", "author", "ean", "img", new BigDecimal(100), new BigDecimal("110"),5, new Date());

        when(productClient.findAll()).thenReturn(Arrays.asList(productViewModel));
        when(productClient.findById((long) 1)).thenReturn(productViewModel);
        when(productClient.createProduct(productDto)).thenReturn(productViewModel);
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/product/1")).andExpect(status().isOk());
    }

    @Test
    void createProduct() throws Exception {
        mockMvc.perform(post("/product")
                .content(objectMapper.writeValueAsString(productDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateProduct() throws Exception {
        mockMvc.perform(put("/product/1")
                .content(objectMapper.writeValueAsString(productDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(post("/product")
                .content(objectMapper.writeValueAsString(productDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void decreaseAmount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/product/1")).andExpect(status().isNoContent());
    }

    @Test
    void testDecreaseAmount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/product/1/3")).andExpect(status().isNoContent());
    }
}