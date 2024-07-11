package pe.com.clinicasakura.ClinicaSakura.dtos;

import lombok.Data;

@Data
public class LoginAuthenticationResponse {
  private String token;

  public LoginAuthenticationResponse(String jwtToken) {
    this.token = jwtToken;
  }
}
