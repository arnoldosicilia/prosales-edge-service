package com.ironhack.erp.edgeservice.controller.interfaces;

import com.ironhack.erp.edgeservice.model.dto.UserDto;
import com.ironhack.erp.edgeservice.model.viewModel.UserViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserControllerInterface {
    // USERS

    public List<UserViewModel> findAllUsers();
    public UserViewModel findUserById(@PathVariable Long id);
    public UserViewModel createClient(@RequestBody UserDto user);
    public UserViewModel updateClient(@PathVariable Long id, @RequestBody UserDto user);
    public void deleteClient(@PathVariable Long id);
}
