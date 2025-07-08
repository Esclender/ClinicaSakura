package pe.com.ferreteriamas.FerreteriaMas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.ferreteriamas.FerreteriaMas.model.TipoDocumentoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.TipoDocumentoService;

import java.util.List;

@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumentoEntity> getAll() {
        return tipoDocumentoService.findAll(null).getContent();
    }
}
