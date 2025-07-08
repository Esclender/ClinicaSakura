
package pe.com.ferreteriamas.FerreteriaMas.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.ferreteriamas.FerreteriaMas.model.EmpleadoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<Page<EmpleadoEntity>> list(Pageable pageable) {
        return new ResponseEntity<>(empleadoService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmpleadoEntity> add(@RequestBody EmpleadoEntity empleado) {
        return new ResponseEntity<>(empleadoService.add(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> update(@PathVariable long id, @RequestBody EmpleadoEntity empleado) {
        return new ResponseEntity<>(empleadoService.update(empleado, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> delete(@PathVariable long id) {
        return new ResponseEntity<>(empleadoService.delete(id), HttpStatus.OK);
    }
}
