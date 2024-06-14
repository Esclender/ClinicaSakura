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
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleEntradaService;

@Controller
@RequestMapping("/entrada")
public class DetalleEntradaController {

    @Autowired
    private DetalleEntradaService detalleEntradaService;

    @GetMapping()
    public String ListadoEntradas(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size) {

        PageRequest pageable = PageRequest.of(page, size);
        Page<DetalleEntradaEntity> detalleEntrada = detalleEntradaService.findAllCustom(pageable);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(new Date());

        // Agregar datos al modelo
        model.addAttribute("detalles", detalleEntrada.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", detalleEntrada.getTotalPages());
        model.addAttribute("totalItems", detalleEntrada.getTotalElements());
        model.addAttribute("pageSize", size);
        model.addAttribute("fecha", formattedDate);

        return "Entradas/listadoEntradas";
    }

    @GetMapping("/habilitar")
    public String HabilitarEntradas(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size) {

        PageRequest pageable = PageRequest.of(page, size);
        Page<DetalleEntradaEntity> detalleEntrada = detalleEntradaService.obtenerPaginas(pageable);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(new Date());

        // Agregar datos al modelo
        model.addAttribute("detalles", detalleEntrada.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", detalleEntrada.getTotalPages());
        model.addAttribute("totalItems", detalleEntrada.getTotalElements());
        model.addAttribute("pageSize", size);
        model.addAttribute("fecha", formattedDate);

        return "Entradas/habilitarEntradas";
    }
}
