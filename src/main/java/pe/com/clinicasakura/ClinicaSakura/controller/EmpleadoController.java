package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

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

    @GetMapping("/registrar")
    public String RegistroEmpleado() {
        return "Empleados/registroEmpleados";
    }
}
