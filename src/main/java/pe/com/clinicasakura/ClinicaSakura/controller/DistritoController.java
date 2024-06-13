package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/mostrar")
    public String mostrarDistritos(Model model) {
        model.addAttribute("distritos", distritoService.findAll());
        return "distrito/mostrar_distritos"; // Nombre del archivo HTML o Thymeleaf
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("distrito", new DistritoEntity());
        return "distrito/registrar_distrito"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/registrar")
    public String registrarDistrito(@ModelAttribute("distrito") DistritoEntity distrito) {
        distritoService.add(distrito);
        return "redirect:/distrito/mostrar";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        DistritoEntity distrito = distritoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de distrito inválido: " + id));
        model.addAttribute("distrito", distrito);
        return "distrito/actualizar_distrito"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarDistrito(@PathVariable Long id, @ModelAttribute("distrito") DistritoEntity distrito) {
        distrito.setCodigo(id); // Aseguramos que el ID coincida con el de la entidad
        distritoService.update(distrito);
        return "redirect:/distrito/mostrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDistrito(@PathVariable Long id) {
        DistritoEntity distrito = distritoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id de distrito inválido: " + id));
        distritoService.delete(distrito);
        return "redirect:/distrito/mostrar";
    }

    @ModelAttribute("distrito")
    public DistritoEntity distritoModel() {
        return new DistritoEntity();
    }
}
