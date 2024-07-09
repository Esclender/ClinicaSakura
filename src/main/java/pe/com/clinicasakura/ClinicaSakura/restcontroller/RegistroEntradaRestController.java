package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroEntradaService;

@RestController
@RequestMapping("/api/v1/entrada")
public class RegistroEntradaRestController {

  @Autowired
  private RegistroEntradaService service;
  
    @GetMapping
    public List<RegistroEntradaEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<RegistroEntradaEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public Optional<RegistroEntradaEntity> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public RegistroEntradaEntity add(@RequestBody RegistroEntradaEntity t) {
        return service.add(t);
    }

    @PutMapping("/{id}")
    public RegistroEntradaEntity update(@PathVariable long id, @RequestBody RegistroEntradaEntity t) {
        return service.update(t);
    }

    @DeleteMapping("/{id}")
    public RegistroEntradaEntity delete(@PathVariable long id, @RequestBody RegistroEntradaEntity t) {
        return service.delete(t);
    }

    @PutMapping("/enable/{id}")
    public RegistroEntradaEntity enable(@PathVariable long id, @RequestBody RegistroEntradaEntity t) {
        return service.enable(t);
    }

}
