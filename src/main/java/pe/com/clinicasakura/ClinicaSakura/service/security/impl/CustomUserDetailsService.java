package pe.com.clinicasakura.ClinicaSakura.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.clinicasakura.ClinicaSakura.model.security.UserCredentials;
import pe.com.clinicasakura.ClinicaSakura.model.security.UserCredentialsDetails;
import pe.com.clinicasakura.ClinicaSakura.repository.security.UserCredentialsRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserCredentialsRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserCredentials credentials = repository.findByUsername(username);

    if (credentials == null) {
      throw new UsernameNotFoundException("No user found with username: " + username);
    }

    return new UserCredentialsDetails(credentials);
  }

}
