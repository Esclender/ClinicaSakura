/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;

/**
 *
 * @author Rachel
 */
public class DistritoRestController {
    
    @Autowired
    private DistritoService service;
    
    @GetMapping
    public List<DistritoEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<DistritoEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public Optional<DistritoEntity> findById(Long id) {
        return service.findById(id);
    }

   @PostMapping
    public DistritoEntity add(DistritoEntity t) {
        return service.add(t);
    }

  @PutMapping("/{id}")
    public DistritoEntity update(@PathVariable long id, @RequestBody DistritoEntity t) {
        return service.update(t);
    }

   @DeleteMapping("/{id}")
    public DistritoEntity delete(@PathVariable long id, @RequestBody DistritoEntity t) {
        return service.delete(t);
    }

   @PutMapping("/enable/{id}")
    public DistritoEntity enable(@PathVariable long id, @RequestBody DistritoEntity t) {
        return service.enable(t);
    }
    
}
