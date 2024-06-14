package pe.com.clinicasakura.ClinicaSakura.controller;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleEntradaService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProveedorService;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroEntradaService;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.Date;
import pe.com.clinicasakura.ClinicaSakura.dtos.RegistroEntradaDto;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;

@Controller
//@RequestMapping("/entrada")
public class RegistroEntradaController {

    @Autowired
    private DetalleEntradaService detalleEntradaService;

    @Autowired
    private RegistroEntradaService registroEntradaService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private ProductoService productoService; // Inyecta el servicio de productos

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Formatear la fecha
        String formattedDate = dateFormat.format(new Date());
        model.addAttribute("registro", new RegistroEntradaDto());
        model.addAttribute("proveedores", proveedorService.findAll());
        model.addAttribute("fecha", formattedDate);
        model.addAttribute("productos", productoService.findAll());

        model.addAttribute("empleados", empleadoService.findAll()); // Agrega los productos al modelo
        return "Entradas/registroEntradas"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/registrar")
    public String registrarRegistro(@ModelAttribute("registro") RegistroEntradaDto registro) {

        System.out.println(registro);

        return "redirect:/entrada/mostrar";
    }

    @ModelAttribute("registro")
    public RegistroEntradaDto registroModel() {
        return new RegistroEntradaDto();
    }
}