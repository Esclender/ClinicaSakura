package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StartController {
    
    @GetMapping("/login")
    public String MostrarLogin() {
        return "login";
    }

    @GetMapping("/inicio")
    public String MostrarInicio() {
        return "dashboard";
    }


    @PostMapping("/login/acceder")
    public String LoginWithAllowedCredentials() {
        return "redirect:/inicio";
    }
}
