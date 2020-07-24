package com.ironhack.erp.edgeservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.erp.edgeservice.client.SalesClient;
import com.ironhack.erp.edgeservice.client.UserClient;
import com.ironhack.erp.edgeservice.model.dto.UserDto;
import com.ironhack.erp.edgeservice.model.viewModel.UserViewModel;
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
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UserControllerImplTest {

    @Autowired
    UserControllerImpl userController;

    @MockBean
    UserClient userClient;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    UserDto userDto;
    UserViewModel userViewModel;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        userDto = new UserDto("test", "test", "test", (long)1);
        userViewModel = new UserViewModel((long)1,"test", "test", "test", (long)1, new Date());

        when(userClient.findAllUsers()).thenReturn(Arrays.asList(userViewModel));
        when(userClient.findUserById((long)1)).thenReturn(userViewModel);
        when(userClient.createClient(userDto)).thenReturn(userViewModel);
    }
    @Test
    void findAllUsers() throws Exception {
        mockMvc.perform(get("/users")).andExpect(status().isOk());
    }

    @Test
    void findUserById() throws Exception {
        mockMvc.perform(get("/users/1")).andExpect(status().isOk());
    }

    @Test
    void findUserByUsername() throws Exception{
        mockMvc.perform(get("/username/test")).andExpect(status().isOk());
    }

    @Test
    void createClient() throws Exception {
        mockMvc.perform(post("/users")
                .content(objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void updateUser() throws Exception {
        mockMvc.perform(put("/users/1")
                .content(objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

    @Test
    void deleteUser() throws Exception {
        mockMvc.perform(delete("/users/1")).andExpect(status().isNoContent());
    }
}