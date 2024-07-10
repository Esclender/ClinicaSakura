package pe.com.clinicasakura.ClinicaSakura.model.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginAuthenticationRequestDTO {

  private String username;
  private String password;
  
}
