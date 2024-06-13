package pe.com.clinicasakura.ClinicaSakura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.clinicasakura.ClinicaSakura.model.TipoDocumentoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.TipoDocumentoService;

import java.util.List;

@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumentoEntity> getAll() {
        return tipoDocumentoService.findAll();
    }
}
