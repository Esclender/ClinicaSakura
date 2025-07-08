/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.ferreteriamas.FerreteriaMas.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.ferreteriamas.FerreteriaMas.model.CargoEntity;
import pe.com.ferreteriamas.FerreteriaMas.service.CargoService;

@RestController
@RequestMapping("/cargos")
public class CargoRestController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<CargoEntity>> list() {
        return new ResponseEntity<>(cargoService.findAll(null).getContent(), HttpStatus.OK);
    }
}
