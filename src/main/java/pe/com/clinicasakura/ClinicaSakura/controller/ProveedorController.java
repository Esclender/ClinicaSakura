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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/mostrar")
    public String mostrarProveedores(Model model, 
         @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        PageRequest pageable = PageRequest.of(page, size);
        Page<ProveedorEntity> proveedores = proveedorService.findAllCustom(pageable);
        //List<ProveedorEntity> proveedores = proveedorService.findAll();
        model.addAttribute("proveedores", proveedores.getContent());
         model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", proveedores.getTotalPages());
        model.addAttribute("totalItems", proveedores.getTotalElements());
        model.addAttribute("pageSize", size);
        
        return "Proveedores/listadoProveedores";
    }

    @GetMapping()
    public String mostrarFormularioRegistrar(Model model) {
        List<DistritoEntity> distritos = distritoService.findAll();
        model.addAttribute("distritos", distritos);
        model.addAttribute("proveedor", new ProveedorEntity());
        return "Proveedores/registroProveedores";
    }

    @PostMapping("/registrar")
    public String registrarProveedor(@ModelAttribute("proveedor") ProveedorEntity proveedor) {
        System.out.println(proveedor);
        proveedorService.add(proveedor);
        return "redirect:/proveedor";
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
