package com.ironhack.erp.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.edgeservice.client.ClientClient;
import com.ironhack.erp.edgeservice.client.CompanyClient;
import com.ironhack.erp.edgeservice.model.dto.ClientDto;
import com.ironhack.erp.edgeservice.model.dto.CompanyDto;
import com.ironhack.erp.edgeservice.model.viewModel.ClientViewModel;
import com.ironhack.erp.edgeservice.model.viewModel.CompanyViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CompanyControllerImplTest {

    @Autowired
    CompanyControllerImpl companyController;

    @MockBean
    CompanyClient companyClient;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    CompanyDto companyDto;
    CompanyViewModel companyViewModel;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        companyDto = new CompanyDto("Companytest");
        companyViewModel = new CompanyViewModel((long)1,"Companytest" );

        when(companyClient.findAll()).thenReturn(Arrays.asList(companyViewModel));
        when(companyClient.findById((long) 1)).thenReturn(companyViewModel);
        when(companyClient.create(companyDto)).thenReturn(companyViewModel);
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/companies")).andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        mockMvc.perform(get("/companies/1")).andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/companies")
                .content(objectMapper.writeValueAsString(companyDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }


    @Test
    void deleteCompany() throws Exception{
        mockMvc.perform(delete("/companies/1")).andExpect(status().isOk());
    }
}