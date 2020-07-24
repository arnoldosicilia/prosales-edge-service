package com.ironhack.erp.edgeservice.service;

import com.ironhack.erp.edgeservice.client.UserClient;
import com.ironhack.erp.edgeservice.model.dto.UserDto;
import com.ironhack.erp.edgeservice.model.viewModel.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserClient userClient;
    // USERS

    public List<UserViewModel> findAllUsers() {
        return userClient.findAllUsers();
    }
    public UserViewModel findUserById(Long id) {
        return userClient.findUserById(id);
    }
    public UserViewModel createClient(UserDto user) {
        return userClient.createClient(user);
    }
    public UserViewModel updateClient(Long id,UserDto user) {
        return userClient.updateClient(id, user);
    }
    public UserViewModel findByUsername(String username){return userClient.findByUsername(username);}
    public void deleteClient(Long id) {
        userClient.deleteClient(id);
    }
}