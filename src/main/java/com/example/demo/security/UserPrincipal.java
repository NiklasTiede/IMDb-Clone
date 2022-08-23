package com.example.demo.security;

import com.example.demo.entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String firstName;

  private String lastName;

  private String username;

  @JsonIgnore private String email;

  @JsonIgnore private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserPrincipal(
      Long id,
      String firstName,
      String lastName,
      String username,
      String email,
      String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.password = password;

    if (authorities == null) {
      this.authorities = null;
    } else {
      this.authorities = new ArrayList<>(authorities);
    }
  }

  public static UserPrincipal create(Account account) {
    System.out.println(account.getRoles());
    List<GrantedAuthority> authorities =
        account.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());

    return new UserPrincipal(
        account.getId(),
        account.getFirstName(),
        account.getLastName(),
        account.getUsername(),
        account.getEmail(),
        account.getPassword(),
        authorities);
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities == null ? null : new ArrayList<>(authorities);
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
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

  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    UserPrincipal that = (UserPrincipal) object;
    return Objects.equals(id, that.id);
  }

  public int hashCode() {
    return Objects.hash(id);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}