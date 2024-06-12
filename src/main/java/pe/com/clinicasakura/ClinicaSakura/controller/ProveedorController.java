package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProveedorController {
    @GetMapping("/proveedores")
    public String RegistroProveedores() {
        return "Proveedores/registroProveedores";
    }
}
