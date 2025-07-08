
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
import pe.com.ferreteriamas.FerreteriaMas.model.ProveedorEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.ProveedorService;

@RestController
@RequestMapping("/proveedores")
public class ProveedorRestController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<Page<ProveedorEntity>> list(Pageable pageable) {
        return new ResponseEntity<>(proveedorService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProveedorEntity> add(@RequestBody ProveedorEntity proveedor) {
        return new ResponseEntity<>(proveedorService.add(proveedor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorEntity> update(@PathVariable long id, @RequestBody ProveedorEntity proveedor) {
        return new ResponseEntity<>(proveedorService.update(proveedor, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProveedorEntity> delete(@PathVariable long id) {
        return new ResponseEntity<>(proveedorService.delete(id), HttpStatus.OK);
    }
}
