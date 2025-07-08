
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
import pe.com.ferreteriamas.FerreteriaMas.model.TipoDocumentoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.TipoDocumentoService;

@RestController
@RequestMapping("/tipos-documento")
public class TipoDocumentoRestController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public ResponseEntity<Page<TipoDocumentoEntity>> list(Pageable pageable) {
        return new ResponseEntity<>(tipoDocumentoService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TipoDocumentoEntity> add(@RequestBody TipoDocumentoEntity tipoDocumento) {
        return new ResponseEntity<>(tipoDocumentoService.add(tipoDocumento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumentoEntity> update(@PathVariable long id, @RequestBody TipoDocumentoEntity tipoDocumento) {
        return new ResponseEntity<>(tipoDocumentoService.update(tipoDocumento, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoDocumentoEntity> delete(@PathVariable long id) {
        return new ResponseEntity<>(tipoDocumentoService.delete(id), HttpStatus.OK);
    }
}
