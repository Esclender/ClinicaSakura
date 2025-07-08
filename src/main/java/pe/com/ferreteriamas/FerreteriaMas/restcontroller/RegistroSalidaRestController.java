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
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.RegistroSalidaService;

@RestController
@RequestMapping("/salidas")
public class RegistroSalidaRestController {

    @Autowired
    private RegistroSalidaService registroSalidaService;

    @GetMapping
    public ResponseEntity<Page<RegistroSalidaEntity>> list(Pageable pageable) {
        return new ResponseEntity<>(registroSalidaService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistroSalidaEntity> add(@RequestBody RegistroSalidaEntity registroSalida) {
        return new ResponseEntity<>(registroSalidaService.add(registroSalida), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroSalidaEntity> update(@PathVariable long id, @RequestBody RegistroSalidaEntity registroSalida) {
        return new ResponseEntity<>(registroSalidaService.update(registroSalida, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroSalidaEntity> delete(@PathVariable long id) {
        return new ResponseEntity<>(registroSalidaService.delete(id), HttpStatus.OK);
    }
}
