package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;

@Controller
public class StartController {

    @Autowired
    private ProductoService productoServicio;

    @GetMapping("/login")
    public String MostrarLogin() {
        return "login";
    }

    @GetMapping("/inicio")
    public String MostrarInicio(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<ProductoEntity> productos = productoServicio.findAllCustom(pageable);
        model.addAttribute("productos",
                productos.getContent());
        model.addAttribute("productosPage",
                productos);
        return "dashboard";
    }

    @PostMapping("/login/acceder")
    public String LoginWithAllowedCredentials() {
        return "redirect:/inicio";
    }
}
