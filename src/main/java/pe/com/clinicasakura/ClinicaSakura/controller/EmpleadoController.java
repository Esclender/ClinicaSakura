package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoController {
    
    @GetMapping("/empleados")
    public String RegistroEmpleado() {
        return "Empleados/registroEmpleados";
    }
}
