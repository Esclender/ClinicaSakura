package pe.com.clinicasakura.ClinicaSakura.repository.security;

import pe.com.clinicasakura.ClinicaSakura.model.security.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {

  public UserCredentials findByUsername(String username);
}
