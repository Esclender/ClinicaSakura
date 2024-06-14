package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;
import pe.com.clinicasakura.ClinicaSakura.service.TipoDocumentoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private EmpleadoService repositorio;

    @GetMapping()
    public String MostrarEmpleados(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageable = PageRequest.of(page, size);
        Page<EmpleadoEntity> empleados = repositorio.findAllCustom(pageable);

        model.addAttribute("empleados", empleados.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", empleados.getTotalPages());
        model.addAttribute("totalItems", empleados.getTotalElements());
        model.addAttribute("pageSize", size);

        return "Empleados/listadoEmpleados";
    }

    @GetMapping("/registro")
    public String RegistroEmpleado(Model model) {
        model.addAttribute("distritos", distritoService.findAll());
        model.addAttribute("cargos", cargoService.findAll());
        model.addAttribute("tiposDocumentos", tipoDocumentoService.findAll());

        return "Empleados/registroEmpleados";
    }

    // modelo
    @ModelAttribute("empleado")
    public EmpleadoEntity ModeloProducto() {
        return new EmpleadoEntity();
    }

    @PostMapping("/registro")
    public String RegistroEmpleado(
            @ModelAttribute("empleado") EmpleadoEntity empleadoEntity) {
        repositorio.add(empleadoEntity);
        return "redirect:/empleados";
    }

    @GetMapping("/actualizar/{id}")
    public String MostrarActualizarProducto(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("empleado", repositorio.findById(id).get());
        // modelo.addAttribute("categoriaProducto", repositorio.findAll());
        return "Almacen/actualizarProducto";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarProducto(@PathVariable Long id,
            @ModelAttribute("producto") EmpleadoEntity empleadoEntity) {

        repositorio.update(empleadoEntity);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String MostrarEliminarArtefacto(@PathVariable Long id) {
        EmpleadoEntity empleadoEntity = repositorio.findById(id).get();
        System.out.println(empleadoEntity);
        repositorio.delete(empleadoEntity);
        return "redirect:/productos";
    }
}
