
package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;
import pe.com.clinicasakura.ClinicaSakura.service.ProveedorService;

@RestController
@RequestMapping("rest/proveedor")
public class ProveedorRestController {
    @Autowired
    private ProveedorService service;
    
    @GetMapping
    public List<ProveedorEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<ProveedorEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public Optional<ProveedorEntity> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ProveedorEntity add(@RequestBody ProveedorEntity t) {
        return service.add(t);
    }

    @PutMapping("/{id}")
    public ProveedorEntity update(@PathVariable long id, @RequestBody ProveedorEntity t) {
        return service.update(t);
    }

    @DeleteMapping("/{id}")
    public ProveedorEntity delete(@PathVariable long id, @RequestBody ProveedorEntity t) {
        return service.delete(t);
    }

    @PutMapping("/enable/{id}")
    public ProveedorEntity enable(@PathVariable long id, @RequestBody ProveedorEntity t) {
        return service.enable(t);
    }
}
