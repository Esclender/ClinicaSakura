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
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.RegistroEntradaService;

@RestController
@RequestMapping("/entradas")
public class RegistroEntradaRestController {

    @Autowired
    private RegistroEntradaService registroEntradaService;

    @GetMapping
    public ResponseEntity<Page<RegistroEntradaEntity>> list(Pageable pageable) {
        return new ResponseEntity<>(registroEntradaService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistroEntradaEntity> add(@RequestBody RegistroEntradaEntity registroEntrada) {
        return new ResponseEntity<>(registroEntradaService.add(registroEntrada), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroEntradaEntity> update(@PathVariable long id, @RequestBody RegistroEntradaEntity registroEntrada) {
        return new ResponseEntity<>(registroEntradaService.update(registroEntrada, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroEntradaEntity> delete(@PathVariable long id) {
        return new ResponseEntity<>(registroEntradaService.delete(id), HttpStatus.OK);
    }
}
