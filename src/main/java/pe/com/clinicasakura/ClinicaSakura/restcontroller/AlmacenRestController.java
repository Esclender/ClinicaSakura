/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;

@RestController
@RequestMapping("rest/productos")
public class AlmacenRestController {
    @Autowired
    private ProductoService service;
    
    @GetMapping
    public List<ProductoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<ProductoEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable Long id) {
        return service.findById(id);
    }

   @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity t) {
        return service.add(t);
    }

  @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable long id, @RequestBody ProductoEntity t) {
        return service.update(t);
    }

   @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable long id, @RequestBody ProductoEntity t) {
        return service.delete(t);
    }

   @PutMapping("/enable/{id}")
    public ProductoEntity enable(@PathVariable long id, @RequestBody ProductoEntity t) {
        return service.enable(t);
    }
}
