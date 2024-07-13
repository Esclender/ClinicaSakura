package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;

@RestController
@RequestMapping("/api/v1/distrito")
public class DistritoRestController {

    @Autowired
    private DistritoService service;

    @GetMapping
    public List<DistritoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DistritoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
