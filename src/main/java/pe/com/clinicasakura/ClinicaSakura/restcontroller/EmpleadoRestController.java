
package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pe.com.clinicasakura.ClinicaSakura.dtos.RegistroEmpleadoDto;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.TipoDocumentoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;
import pe.com.clinicasakura.ClinicaSakura.service.TipoDocumentoService;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService service;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public List<EmpleadoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<EmpleadoEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public EmpleadoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoEntity add(@RequestBody RegistroEmpleadoDto t) {
        CargoEntity cargo = cargoService.findById(t.getCodigoCargo());
        TipoDocumentoEntity tipoDocumento = tipoDocumentoService.findById(t.getCodigoTipoDocumento());
        DistritoEntity distrito = distritoService.findById(t.getCodigoDistrito());

        return service.add(t.ToEmpleadoEntity(cargo, distrito, tipoDocumento));
    }

    @PutMapping("/{id}")
    public EmpleadoEntity update(@PathVariable long id, @RequestBody EmpleadoEntity t) {
        return service.update(t, id);
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
