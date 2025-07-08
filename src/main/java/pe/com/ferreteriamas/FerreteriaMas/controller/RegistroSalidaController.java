package pe.com.ferreteriamas.FerreteriaMas.controller;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.ProductoService;
import pe.com.ferreteriamas.FerreteriaMas.service.EmpleadoService;

import java.util.Date;
import pe.com.ferreteriamas.FerreteriaMas.dtos.RegistroEntradaDto;
import pe.com.ferreteriamas.FerreteriaMas.dtos.RegistroSalidaDto;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.ProveedorEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.DestinoService;
import pe.com.ferreteriamas.FerreteriaMas.service.DetalleSalidaService;
import pe.com.ferreteriamas.FerreteriaMas.service.RegistroSalidaService;

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
        model.addAttribute("cantidadProductos", productoService.findAll(null).getContent());
        model.addAttribute("fecha", formattedDate);
        model.addAttribute("destinos", destinoService.findAll(null).getContent());
        model.addAttribute("empleados", empleadoService.findAll(null).getContent());
        model.addAttribute("productos", productoService.findAll(null).getContent());

        model.addAttribute("empleados", empleadoService.findAll(null).getContent()); // Agrega los productos al modelo
        return "Salida/registroSalidas"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/salida/registrar")
    public String registrarSalida(@ModelAttribute("registro") RegistroSalidaDto registro) {

        RegistroSalidaEntity objSaved = registroSalidaService.add(registro.getRegistroSalida());

        System.out.println(objSaved);

        for (DetalleSalidaEntity detalle : registro.getDetalleSalida()) {
            detalle.setRegistroSalida(objSaved);
            detalleSalidaService.add(detalle);
        }

        return "redirect:/salida";
    }

    @GetMapping("/salida/eliminar/{id}")
    public String EliminarSalida(@PathVariable Long id) {
        registroSalidaService.delete(id);
        return "redirect:/salida";
    }

    @GetMapping("/salida/habilitar/{id}")
    public String HabilitarSalida(@PathVariable Long id) {
        registroSalidaService.enable(id);
        return "redirect:/salida";
    }

    @ModelAttribute("registro")
    public RegistroSalidaDto registroModel() {
        return new RegistroSalidaDto();
    }
}