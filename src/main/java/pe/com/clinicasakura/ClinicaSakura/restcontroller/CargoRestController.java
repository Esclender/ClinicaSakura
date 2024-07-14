package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;

@RestController
@RequestMapping("/api/v1/cargo")
public class CargoRestController {

    @Autowired
    private CargoService service;

    @GetMapping
    public List<CargoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<CargoEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public CargoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CargoEntity add(@RequestBody CargoEntity t) {
        return service.add(t);
    }

    @PutMapping("/{id}")
    public CargoEntity update(@PathVariable long id, @RequestBody CargoEntity t) {
        return service.update(t);
    }

    @DeleteMapping("/{id}")
    public CargoEntity delete(@PathVariable long id, @RequestBody CargoEntity t) {
        return service.delete(t);
    }

    @PutMapping("/enable/{id}")
    public CargoEntity enable(@PathVariable long id, @RequestBody CargoEntity t) {
        return service.enable(t);
    }
}
