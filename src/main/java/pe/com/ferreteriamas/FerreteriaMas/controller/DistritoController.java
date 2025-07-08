package pe.com.ferreteriamas.FerreteriaMas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.ferreteriamas.FerreteriaMas.model.DistritoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.DistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/mostrar")
    public String mostrarDistritos(Model model) {
        model.addAttribute("distritos", distritoService.findAll(null).getContent());
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
        DistritoEntity distrito = distritoService.findById(id);
        model.addAttribute("distrito", distrito);
        return "distrito/actualizar_distrito"; // Nombre del archivo HTML o Thymeleaf
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarDistrito(@PathVariable Long id, @ModelAttribute("distrito") DistritoEntity distrito) {
        distritoService.update(distrito, id);
        return "redirect:/distrito/mostrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDistrito(@PathVariable Long id) {
        distritoService.delete(id);
        return "redirect:/distrito/mostrar";
    }

    @ModelAttribute("distrito")
    public DistritoEntity distritoModel() {
        return new DistritoEntity();
    }
}
