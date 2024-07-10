package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.clinicasakura.ClinicaSakura.model.security.LoginAuthenticationRequestDTO;
import pe.com.clinicasakura.ClinicaSakura.model.security.LoginAuthenticationResponse;
import pe.com.clinicasakura.ClinicaSakura.utils.JwtUtil;

@Controller
@RequestMapping("/api/v1/auth")
public class AuthRestController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginAuthenticationRequestDTO loginRequest) {
    try {
      // Authenticate the user
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

      // Retrieve user details
      UserDetails userDetails = (UserDetails) authentication.getPrincipal();

      // Generate JWT token
      String jwt = jwtUtil.generateToken(userDetails);

      // Return the JWT token in the response
      return ResponseEntity.ok(new LoginAuthenticationResponse(jwt));
    } catch (BadCredentialsException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
  }

}
