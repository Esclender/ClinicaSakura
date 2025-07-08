/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import pe.com.ferreteriamas.FerreteriaMas.model.DistritoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.DistritoService;

@RestController
@RequestMapping("/distritos")
public class DistritoRestController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public ResponseEntity<Page<DistritoEntity>> list(Pageable pageable) {
        return new ResponseEntity<>(distritoService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DistritoEntity> add(@RequestBody DistritoEntity distrito) {
        return new ResponseEntity<>(distritoService.add(distrito), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistritoEntity> update(@PathVariable long id, @RequestBody DistritoEntity distrito) {
        return new ResponseEntity<>(distritoService.update(distrito, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DistritoEntity> delete(@PathVariable long id) {
        return new ResponseEntity<>(distritoService.delete(id), HttpStatus.OK);
    }
}
