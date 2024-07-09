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

import pe.com.clinicasakura.ClinicaSakura.model.RegistroSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroSalidaService;

@RestController
@RequestMapping("/api/v1/salida")
public class RegistroSalidaRestController {
  
  @Autowired
  private RegistroSalidaService service;
  
    @GetMapping
    public List<RegistroSalidaEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<RegistroSalidaEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public Optional<RegistroSalidaEntity> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public RegistroSalidaEntity add(@RequestBody RegistroSalidaEntity t) {
        return service.add(t);
    }

    @PutMapping("/{id}")
    public RegistroSalidaEntity update(@PathVariable long id, @RequestBody RegistroSalidaEntity t) {
        return service.update(t);
    }

    @DeleteMapping("/{id}")
    public RegistroSalidaEntity delete(@PathVariable long id, @RequestBody RegistroSalidaEntity t) {
        return service.delete(t);
    }

    @PutMapping("/enable/{id}")
    public RegistroSalidaEntity enable(@PathVariable long id, @RequestBody RegistroSalidaEntity t) {
        return service.enable(t);
    }


}
