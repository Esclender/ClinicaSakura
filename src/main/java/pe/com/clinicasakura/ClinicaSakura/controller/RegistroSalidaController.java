package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroSalidaService;
// import pe.com.clinicasakura.ClinicaSakura.service.DestinoService;
// import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.Date;

@Controller
@RequestMapping("/registrosalida")
public class RegistroSalidaController {

    @Autowired
    private RegistroSalidaService registroSalidaService;

    // @Autowired
    // private DestinoService destinoService;

    // @Autowired
    // private EmpleadoService empleadoService;

    @GetMapping("/mostrar")
    public String mostrarRegistros(Model model) {
        model.addAttribute("registros", registroSalidaService.findAll());
        return "registrosalida/mostrar_registros"; // Nombre del archivo HTML o Thymeleaf
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registro", new RegistroSalidaEntity());
        //model.addAttribute("destinos", destinoService.findAll());
        //model.addAttribute("empleados", empleadoService.findAll());
        return "registrosalida/registrar_registro"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/registrar")
    public String registrarRegistro(@ModelAttribute("registro") RegistroSalidaEntity registro) {
        registro.setFecha(new Date()); // Establece la fecha actual
        registroSalidaService.add(registro);
        return "redirect:/registrosalida/mostrar";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        RegistroSalidaEntity registro = registroSalidaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de registro de salida inválido: " + id));
        model.addAttribute("registro", registro);
        // model.addAttribute("destinos", destinoService.findAll());
        // model.addAttribute("empleados", empleadoService.findAll());
        return "registrosalida/actualizar_registro"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarRegistro(@PathVariable Long id, @ModelAttribute("registro") RegistroSalidaEntity registro) {
        registro.setCodigo(id); // Asegura que el ID coincida con el de la entidad
        registroSalidaService.update(registro);
        return "redirect:/registrosalida/mostrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRegistro(@PathVariable Long id) {
        RegistroSalidaEntity registro = registroSalidaService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de registro de salida inválido: " + id));
        registroSalidaService.delete(registro);
        return "redirect:/registrosalida/mostrar";
    }

    @ModelAttribute("registro")
    public RegistroSalidaEntity registroModel() {
        return new RegistroSalidaEntity();
    }
}
