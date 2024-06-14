package pe.com.clinicasakura.ClinicaSakura.controller;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.Date;
import pe.com.clinicasakura.ClinicaSakura.dtos.RegistroEntradaDto;
import pe.com.clinicasakura.ClinicaSakura.dtos.RegistroSalidaDto;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DestinoService;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleSalidaService;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroSalidaService;

@Controller
// @RequestMapping("/salida")
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

    @GetMapping("/salida/registrar")
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

    @PostMapping("/salida/registrar")
    public String registrarSalida(@ModelAttribute("registro") RegistroSalidaDto registro) {

        RegistroSalidaEntity registroSalida = new RegistroSalidaEntity();

        registroSalida.setCodigoEmpleado(registro.getEmpleado());
        registroSalida.setCodigoDestino(registro.getDestino());
        registroSalida.setFecha(new Date());
        RegistroSalidaEntity objSaved = registroSalidaService.add(registroSalida);

        System.out.println(objSaved);

        DetalleSalidaEntity detalles = new DetalleSalidaEntity();
        detalles.setCantidadProducto(registro.getCantidadProducto());
        detalles.setCodigoProducto(registro.getProducto());
        detalles.setCodigoRegistroSalida(objSaved);
        detalleSalidaService.add(detalles);

        return "redirect:/salida";
    }

    @GetMapping("/salida/eliminar/{id}")
    public String EliminarSalida(@PathVariable Long id) {
        RegistroSalidaEntity rt = registroSalidaService.findById(id).get();
        // EmpleadoEntity empleadoEntity = repositorio.findById(id).get();

        registroSalidaService.delete(rt);
        return "redirect:/salida";
    }

    @GetMapping("/salida/habilitar/{id}")
    public String HabilitarSalida(@PathVariable Long id) {
        RegistroSalidaEntity rt = registroSalidaService.findById(id).get();
        // EmpleadoEntity empleadoEntity = repositorio.findById(id).get();

        registroSalidaService.enable(rt);
        return "redirect:/salida";
    }

    @ModelAttribute("registro")
    public RegistroSalidaDto registroModel() {
        return new RegistroSalidaDto();
    }
}