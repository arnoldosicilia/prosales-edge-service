package com.ironhack.erp.edgeservice.controller.impl;

import com.ironhack.erp.edgeservice.model.dto.UserDto;
import com.ironhack.erp.edgeservice.model.viewModel.UserViewModel;
import com.ironhack.erp.edgeservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserControllerImpl {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Get all the user")
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserViewModel> findAllUsers() {
        return userService.findAllUsers();
    }

    @ApiOperation(value = "Get a user by id")
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserViewModel findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @ApiOperation(value = "Insert a user by id")
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel createClient(@RequestBody UserDto user) {
        return userService.createClient(user);
    }

    @ApiOperation(value = "update a user by id")
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel updateClient(@PathVariable Long id, @RequestBody UserDto user) {
        return userService.updateClient(id, user);
    }

    @ApiOperation(value = "find a user by username")
    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserViewModel findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }


    @ApiOperation(value = "Delete a user by id")
    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        userService.deleteClient(id);
    }
}
