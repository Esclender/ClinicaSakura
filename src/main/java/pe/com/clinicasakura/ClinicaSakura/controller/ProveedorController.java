package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProveedorService;

import java.util.List;

@Controller
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/proveedores")
    public String mostrarProveedores(Model model) {
        List<ProveedorEntity> proveedores = proveedorService.findAll();
        model.addAttribute("proveedores", proveedores);
        return "Proveedores/registroProveedores";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        List<DistritoEntity> distritos = distritoService.findAll();
        model.addAttribute("distritos", distritos);
        model.addAttribute("proveedor", new ProveedorEntity());
        return "Proveedores/registroProveedores";
    }

    @PostMapping("/registrar")
    public String registrarProveedor(@ModelAttribute("proveedor") ProveedorEntity proveedor) {
        proveedorService.add(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Long id, Model model) {
        ProveedorEntity proveedor = proveedorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de proveedor no válido: " + id));
        List<DistritoEntity> distritos = distritoService.findAll();
        model.addAttribute("distritos", distritos);
        model.addAttribute("proveedor", proveedor);
        return "Proveedores/registroProveedores";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("proveedor") ProveedorEntity proveedor) {
        proveedorService.update(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        ProveedorEntity proveedor = proveedorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de proveedor no válido: " + id));
        proveedorService.delete(proveedor);
        return "redirect:/proveedores";
    }

}
