package pe.com.clinicasakura.ClinicaSakura.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleSalidaService;

import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.ProveedorService;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroSalidaService;


@Controller
@RequestMapping("/salida")
public class DetalleSalidaController {

    @Autowired
    private DetalleSalidaService detalleSalidaService;

    @GetMapping("/mostrar")
    public String ListadoSalidas(
            Model model,  @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageable = PageRequest.of(page, size);
        Page<DetalleSalidaEntity> detalleSalida = detalleSalidaService.findAllCustom(pageable);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(new Date());

        // Agregar datos al modelo
        model.addAttribute("detalles", detalleSalida.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", detalleSalida.getTotalPages());
        model.addAttribute("totalItems", detalleSalida.getTotalElements());
        model.addAttribute("pageSize", size);

    
        model.addAttribute("fecha", formattedDate);

        return "Salida/listadoSalida"; 
    }
}
