
package pe.com.clinicasakura.ClinicaSakura.utils;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private static final Logger logger = Logger.getLogger(CustomAuthenticationFailureHandler.class.getName());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.warning("Authentication failed: " + exception.getMessage());
        response.sendRedirect("/login?error=true"); // Redirect to the login page with an error parameter
    }
}