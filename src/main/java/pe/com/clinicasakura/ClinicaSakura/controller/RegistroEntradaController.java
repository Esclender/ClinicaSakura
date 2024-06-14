package pe.com.clinicasakura.ClinicaSakura.controller;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleEntradaService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProveedorService;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroEntradaService;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.Date;
import pe.com.clinicasakura.ClinicaSakura.dtos.RegistroEntradaDto;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;

@Controller
// @RequestMapping("/entrada")
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

    @PostMapping("/entrada/registrar")
    public String registrarRegistro(@ModelAttribute("registro") RegistroEntradaDto registro) {
        RegistroEntradaEntity registroEntrada = new RegistroEntradaEntity();
        registroEntrada.setCodigoEmpleado(registro.getEmpleado());
        registroEntrada.setCodigoProveedor(registro.getProveedor());
        registroEntrada.setFecha(new Date());
        RegistroEntradaEntity objSaved = registroEntradaService.add(registroEntrada);

        System.out.println(objSaved);

        DetalleEntradaEntity detalles = new DetalleEntradaEntity();
        detalles.setCantidadProducto(registro.getCantidadProducto());
        detalles.setCodigoProducto(registro.getProducto());
        detalles.setPrecioProducto(registro.getPrecioProducto());
        detalles.setCodigoRegistroEntrada(objSaved);
        detalleEntradaService.add(detalles);

        return "redirect:/entrada";
    }

    @GetMapping("/entrada/eliminar/{id}")
    public String EliminarEntrada(@PathVariable Long id) {
        RegistroEntradaEntity rt = registroEntradaService.findById(id).get();
        // EmpleadoEntity empleadoEntity = repositorio.findById(id).get();

        registroEntradaService.delete(rt);
        return "redirect:/entrada";
    }

    @GetMapping("/entrada/habilitar/{id}")
    public String HabilitarEntrada(@PathVariable Long id) {
        RegistroEntradaEntity rt = registroEntradaService.findById(id).get();
        // EmpleadoEntity empleadoEntity = repositorio.findById(id).get();

        registroEntradaService.enable(rt);
        return "redirect:/entrada";
    }

    @ModelAttribute("registro")
    public RegistroEntradaDto registroModel() {
        return new RegistroEntradaDto();
    }
}