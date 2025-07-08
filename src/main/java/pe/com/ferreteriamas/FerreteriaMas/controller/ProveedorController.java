package pe.com.ferreteriamas.FerreteriaMas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.ferreteriamas.FerreteriaMas.model.DistritoEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.EmpleadoEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.ProveedorEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.DistritoService;
import pe.com.ferreteriamas.FerreteriaMas.service.ProveedorService;

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

    @GetMapping()
    public String mostrarProveedores(Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size) {

        PageRequest pageable = PageRequest.of(page, size);
        Page<ProveedorEntity> proveedores = proveedorService.findAll(pageable);
        // List<ProveedorEntity> proveedores = proveedorService.findAll();
        model.addAttribute("proveedores", proveedores.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", proveedores.getTotalPages());
        model.addAttribute("totalItems", proveedores.getTotalElements());
        model.addAttribute("pageSize", size);

        return "Proveedores/listadoProveedores";
    }

    @GetMapping("/habilitar")
    public String habilitarProveedores(Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size) {

        PageRequest pageable = PageRequest.of(page, size);
        Page<ProveedorEntity> proveedores = proveedorService.findAll(pageable);
        // List<ProveedorEntity> proveedores = proveedorService.findAll();
        model.addAttribute("proveedores", proveedores.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", proveedores.getTotalPages());
        model.addAttribute("totalItems", proveedores.getTotalElements());
        model.addAttribute("pageSize", size);

        return "Proveedores/habilitarProveedores";
    }

    @GetMapping("/registrar")
    public String mostrarFormularioRegistrar(Model model) {
        List<DistritoEntity> distritos = distritoService.findAll(null).getContent();
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
        ProveedorEntity proveedor = proveedorService.findById(id);
        List<DistritoEntity> distritos = distritoService.findAll(null).getContent();
        model.addAttribute("distritos", distritos);
        model.addAttribute("proveedor", proveedor);
        return "Proveedores/actualizarProveedor";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProveedor(@PathVariable Long id, @ModelAttribute("proveedor") ProveedorEntity proveedor) {
        proveedorService.update(proveedor, id);
        return "redirect:/proveedor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorService.delete(id);
        return "redirect:/proveedor";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarProveedor(@PathVariable Long id) {
        proveedorService.enable(id);
        return "redirect:/proveedor";
    }

}
