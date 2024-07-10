package pe.com.clinicasakura.ClinicaSakura.model.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserCredentialsDetails implements UserDetails {

  private final UserCredentials credentials;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return credentials.getRoles().stream().map(
        authority -> new SimpleGrantedAuthority(authority.getNombreRol())).collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return credentials.getPassword();

  }

  @Override
  public String getUsername() {
    return credentials.getUsername();

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
