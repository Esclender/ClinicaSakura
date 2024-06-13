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
import pe.com.clinicasakura.ClinicaSakura.dtos.RegistroSalidaDto;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DestinoService;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleSalidaService;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroSalidaService;

@Controller
@RequestMapping("/salidas")
public class RegistroSalidaController {
    
    @Autowired
    private RegistroSalidaService registroSalidaService;

    @Autowired
    private DetalleSalidaService detalleSalidaService;

    @Autowired
    private DestinoService destinoService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private EmpleadoService empleadoService;

    

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        // Formatear la fecha
        String formattedDate = dateFormat.format(new Date());
        model.addAttribute("registro", new RegistroSalidaDto());
        model.addAttribute("cantidadProductos", productoService.findAll());
        model.addAttribute("fecha", formattedDate);
        model.addAttribute("destinos", destinoService.findAll());
        model.addAttribute("empleados", empleadoService.findAll());
        model.addAttribute("productos", productoService.findAll());
        
        model.addAttribute("empleados", empleadoService.findAll()); // Agrega los productos al modelo
        return "Salida/registroSalidas"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/registrar")
    public String registrarRegistro(@ModelAttribute("registro") RegistroSalidaDto registro){
  
        System.out.println(registro);
    

    return "redirect:/salida/registrar";
    }

    @ModelAttribute("registro")
    public RegistroSalidaDto registroModel() {
        return new RegistroSalidaDto();
    }
}