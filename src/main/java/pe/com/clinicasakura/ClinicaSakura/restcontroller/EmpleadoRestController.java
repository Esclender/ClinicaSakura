
package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

@RestController
@RequestMapping("rest/empleado")
public class EmpleadoRestController {
    @Autowired
    private EmpleadoService service;
    
    @GetMapping
    public List<EmpleadoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<EmpleadoEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public Optional<EmpleadoEntity> findById(@PathVariable Long id) {
        return service.findById(id);
    }

   @PostMapping
    public EmpleadoEntity add(@RequestBody EmpleadoEntity t) {
        return service.add(t);
    }

  @PutMapping("/{id}")
    public EmpleadoEntity update(@PathVariable long id, @RequestBody EmpleadoEntity t) {
        return service.update(t);
    }

   @DeleteMapping("/{id}")
    public EmpleadoEntity delete(@PathVariable long id, @RequestBody EmpleadoEntity t) {
        return service.delete(t);
    }

   @PutMapping("/enable/{id}")
    public EmpleadoEntity enable(@PathVariable long id, @RequestBody EmpleadoEntity t) {
        return service.enable(t);
    }
}
