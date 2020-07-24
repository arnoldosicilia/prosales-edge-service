package com.ironhack.erp.edgeservice.client;

import com.ironhack.erp.edgeservice.model.dto.UserDto;
import com.ironhack.erp.edgeservice.model.viewModel.UserViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user-service")
public interface UserClient {
    // USERS
    @GetMapping("/users")
    public List<UserViewModel> findAllUsers();

    @GetMapping("/users/{id}")
    public UserViewModel findUserById(@PathVariable Long id);

    @GetMapping("/username/{username}")
    public UserViewModel findByUsername(@PathVariable String username);

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel createClient(@RequestBody UserDto user);

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public UserViewModel updateClient(@PathVariable Long id, @RequestBody UserDto user);

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id);
}
