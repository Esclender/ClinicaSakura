package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntradaController {

    @GetMapping("/entradas")
    public String RegistrarEntrada() {
        return "Entradas/registroEntradas";
    }
}
