/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;

@RestController
@RequestMapping("/rest/cargo")
public class CargoRestController {

    @Autowired
    private CargoService service;
    
    @GetMapping
    public List<CargoEntity> findAll() {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public CargoEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CargoEntity add(@RequestBody CargoEntity t) {
        return service.save(t);
    }

    
}
