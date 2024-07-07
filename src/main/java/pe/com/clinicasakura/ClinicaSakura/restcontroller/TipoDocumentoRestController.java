
package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.TipoDocumentoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.TipoDocumentoService;

@RestController
@RequestMapping("/rest/tipodocumento")
public class TipoDocumentoRestController {
    
    @Autowired
    private TipoDocumentoService service;
    
    @GetMapping
    public List<TipoDocumentoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<TipoDocumentoEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public Optional<TipoDocumentoEntity> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public TipoDocumentoEntity add(@RequestBody TipoDocumentoEntity t) {
        return service.add(t);
    }

    @PutMapping("/{id}")
    public TipoDocumentoEntity update(@PathVariable long id, @RequestBody TipoDocumentoEntity t) {
        return service.update(t);
    }

    @DeleteMapping("/{id}")
    public TipoDocumentoEntity delete(@PathVariable long id, @RequestBody TipoDocumentoEntity t) {
        return service.delete(t);
    }

    @PutMapping("/enable/{id}")
    public TipoDocumentoEntity enable(@PathVariable long id, @RequestBody TipoDocumentoEntity t) {
        return service.enable(t);
    }
}
