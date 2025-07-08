package pe.com.ferreteriamas.FerreteriaMas.controller;

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

import pe.com.ferreteriamas.FerreteriaMas.model.EmpleadoEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.ProductoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.CargoService;
import pe.com.ferreteriamas.FerreteriaMas.service.DistritoService;
import pe.com.ferreteriamas.FerreteriaMas.service.EmpleadoService;
import pe.com.ferreteriamas.FerreteriaMas.service.TipoDocumentoService;

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
            @RequestParam(defaultValue = "7") int size) {

        PageRequest pageable = PageRequest.of(page, size);
        Page<EmpleadoEntity> empleados = repositorio.findAllCustom(pageable);

        model.addAttribute("empleados", empleados.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", empleados.getTotalPages());
        model.addAttribute("totalItems", empleados.getTotalElements());
        model.addAttribute("pageSize", size);

        return "Empleados/listadoEmpleados";
    }

    @GetMapping("/habilitar")
    public String habilitarEmpleado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size,
            Model model) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<EmpleadoEntity> productos = repositorio.findAll(pageable);

        model.addAttribute("empleados", productos.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productos.getTotalPages());
        model.addAttribute("totalItems", productos.getTotalElements());
        model.addAttribute("pageSize", size);
        return "Empleados/habilitarEmpleados";
    }

    @GetMapping("/registro")
    public String RegistroEmpleado(Model model) {
        model.addAttribute("distritos", distritoService.findAll(null).getContent());
        model.addAttribute("cargos", cargoService.findAll(null).getContent());
        model.addAttribute("tiposDocumentos", tipoDocumentoService.findAll(null).getContent());

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
        modelo.addAttribute("empleado", repositorio.findById(id));
        modelo.addAttribute("distritos", distritoService.findAll(null).getContent());
        modelo.addAttribute("cargos", cargoService.findAll(null).getContent());
        modelo.addAttribute("tiposDocumentos", tipoDocumentoService.findAll(null).getContent());
        return "Empleados/actualizarEmpleado";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarEmpleado(@PathVariable Long id,
            @ModelAttribute("empleado") EmpleadoEntity empleadoEntity) {
        repositorio.update(empleadoEntity, id);
        return "redirect:/empleados";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarEmpleado(@PathVariable Long id) {
        repositorio.delete(id);
        return "redirect:/empleados";
    }

    @GetMapping("/habilitar/{id}")
    public String HabilitarEmpleado(@PathVariable Long id) {
        repositorio.enable(id);
        return "redirect:/empleados";
    }

}
