package com.ironhack.erp.edgeservice.security;

import com.ironhack.erp.edgeservice.model.viewModel.RoleViewModel;
import com.ironhack.erp.edgeservice.model.viewModel.UserViewModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Log4j2
public class CustomSecurityUser extends UserViewModel implements UserDetails {
  private static final long serialVersionUID = -4381938875186527688L;


  public CustomSecurityUser(UserViewModel user) {
    System.out.println(user);
    this.setRoles(user.getRoles());
    this.setId(user.getId());
    this.setPassword(user.getPassword());
    this.setUsername(user.getUsername());
    this.setCompanyId(user.getCompanyId());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new HashSet<>();
    Set<RoleViewModel> roles = this.getRoles();
    System.out.println(this);
    for(RoleViewModel role : roles) {
      log.info("Role: " + role.getRole());
      authorities.add( new SimpleGrantedAuthority(role.getRole()) );
    }
    return authorities;
  }


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
