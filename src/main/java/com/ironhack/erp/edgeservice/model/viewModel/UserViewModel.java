package com.ironhack.erp.edgeservice.model.viewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserViewModel {
    private Long id;
    private String username;
    private String password;
    private Set<RoleViewModel> roles = new HashSet<>();
    private Long companyId;
}
