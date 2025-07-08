package pe.com.ferreteriamas.FerreteriaMas.controller;

import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.ferreteriamas.FerreteriaMas.service.DetalleEntradaService;
import pe.com.ferreteriamas.FerreteriaMas.service.ProductoService;
import pe.com.ferreteriamas.FerreteriaMas.service.ProveedorService;
import pe.com.ferreteriamas.FerreteriaMas.service.RegistroEntradaService;
import pe.com.ferreteriamas.FerreteriaMas.service.EmpleadoService;

import java.util.Date;
import pe.com.ferreteriamas.FerreteriaMas.dtos.RegistroEntradaDto;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.EmpleadoEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroEntradaEntity;

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
        model.addAttribute("proveedores", proveedorService.findAll(null).getContent());
        model.addAttribute("fecha", formattedDate);
        model.addAttribute("productos", productoService.findAll(null).getContent());

        model.addAttribute("empleados", empleadoService.findAll(null).getContent()); // Agrega los productos al modelo
        return "Entradas/registroEntradas"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/entrada/registrar")
    public String registrarRegistro(@ModelAttribute("registro") RegistroEntradaDto registro) {
        
        RegistroEntradaEntity objSaved = registroEntradaService.add(registro.getRegistroEntrada());

        System.out.println(objSaved);

        for (DetalleEntradaEntity detalle : registro.getDetalleEntrada()) {
            detalle.setRegistroEntrada(objSaved);
            detalleEntradaService.add(detalle);
        }


        return "redirect:/entrada";
    }

    @GetMapping("/entrada/eliminar/{id}")
    public String EliminarEntrada(@PathVariable Long id) {
        registroEntradaService.delete(id);
        return "redirect:/entrada";
    }

    @GetMapping("/entrada/habilitar/{id}")
    public String HabilitarEntrada(@PathVariable Long id) {
        registroEntradaService.enable(id);
        return "redirect:/entrada";
    }

    @ModelAttribute("registro")
    public RegistroEntradaDto registroModel() {
        return new RegistroEntradaDto();
    }
}