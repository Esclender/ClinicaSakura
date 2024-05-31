package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlmacenController {
    
    
    @GetMapping("/productos")
    public String ListarProductos() {
        return "Almacen/listadoProductos";
    }
}
