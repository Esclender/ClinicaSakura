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
import pe.com.ferreteriamas.FerreteriaMas.model.ProductoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.ProductoService;

@RestController
@RequestMapping("/almacen")
public class AlmacenRestController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Page<ProductoEntity>> list(Pageable pageable) {
        return new ResponseEntity<>(productoService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoEntity> add(@RequestBody ProductoEntity producto) {
        return new ResponseEntity<>(productoService.add(producto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoEntity> update(@PathVariable long id, @RequestBody ProductoEntity producto) {
        return new ResponseEntity<>(productoService.update(producto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoEntity> delete(@PathVariable long id) {
        return new ResponseEntity<>(productoService.delete(id), HttpStatus.OK);
    }
}
