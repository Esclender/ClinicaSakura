package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroEntradaService;
import pe.com.clinicasakura.ClinicaSakura.service.ProveedorService;
// import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.Date;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

@Controller
@RequestMapping("/entrada")
public class RegistroEntradaController {

    @Autowired
    private RegistroEntradaService registroEntradaService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping()
    public String mostrarRegistros(Model model) {
        model.addAttribute("registros", registroEntradaService.findAll());
        return "Entradas/registroEntradas"; // Nombre del archivo HTML o Thymeleaf
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registro", new RegistroEntradaEntity());
        model.addAttribute("proveedores", proveedorService.findAll());
        model.addAttribute("empleados", empleadoService.findAll());
        return "Entradas/registroEntradas"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/registrar")
    public String registrarRegistro(@ModelAttribute("registro") RegistroEntradaEntity registro) {
        registro.setFecha(new Date()); // Establece la fecha actual
        registroEntradaService.add(registro);
        return "redirect:/registroentrada/mostrar";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        RegistroEntradaEntity registro = registroEntradaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de registro de entrada inválido: " + id));
        model.addAttribute("registro", registro);
        model.addAttribute("proveedores", proveedorService.findAll());
        // model.addAttribute("empleados", empleadoService.findAll());
        return "registroentrada/actualizar_registro"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarRegistro(@PathVariable Long id, @ModelAttribute("registro") RegistroEntradaEntity registro) {
        registro.setCodigo(id); // Asegura que el ID coincida con el de la entidad
        registroEntradaService.update(registro);
        return "redirect:/registroentrada/mostrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable Long id) {
        RegistroEntradaEntity registro = registroEntradaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de registro de entrada inválido: " + id));
        registroEntradaService.delete(registro);
        return "redirect:/registroentrada/mostrar";
    }

    @ModelAttribute("registro")
    public RegistroEntradaEntity registroModel() {
        return new RegistroEntradaEntity();
    }
}
