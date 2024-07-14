package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.clinicasakura.ClinicaSakura.dtos.salidas.RegistroSalidasResponseDto;
import pe.com.clinicasakura.ClinicaSakura.dtos.salidas.RegistroSalidasRestDto;
import pe.com.clinicasakura.ClinicaSakura.model.DestinoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DestinoRepository;
import pe.com.clinicasakura.ClinicaSakura.repository.EmpleadoRepository;
import pe.com.clinicasakura.ClinicaSakura.repository.ProductoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleSalidaService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroSalidaService;

@RestController
@RequestMapping("/api/v1/salida")
public class RegistroSalidaRestController {

    @Autowired
    private RegistroSalidaService service;

    @Autowired
    private DetalleSalidaService detalleService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DestinoRepository destinoRepository;

    @GetMapping
    public List<RegistroSalidaEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RegistroSalidaEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroSalidasResponseDto add(@RequestBody RegistroSalidasRestDto registro) {
        EmpleadoEntity empleado = empleadoRepository.findById(registro.getCodigoEmpleado()).get();
        ProductoEntity producto = productoRepository.findById(registro.getCodigoProducto()).get();
        DestinoEntity destino = destinoRepository.findById(registro.getCodigoDestino()).get();

        RegistroSalidaEntity registroSalida = new RegistroSalidaEntity();
        registroSalida.setFecha(registro.getFecha());
        registroSalida.setCodigoEmpleado(empleado);
        registroSalida.setCodigoDestino(destino);
        RegistroSalidaEntity objSaved = service.add(registroSalida);

        DetalleSalidaEntity detalles = new DetalleSalidaEntity();
        detalles.setCantidadProducto(registro.getCantidadProducto());
        detalles.setCodigoProducto(producto);
        detalles.setCodigoRegistroSalida(objSaved);
        detalleService.add(detalles);

        RegistroSalidasResponseDto response = new RegistroSalidasResponseDto();
        response.setFecha(registro.getFecha());
        response.setCodigo(objSaved.getCodigo());
        response.setEmpleado(empleado);
        response.setDestino(destino);
        response.setProducto(producto);
        response.setCantidadProducto(registro.getCantidadProducto());

        producto.decreaseCantidad(registro.getCantidadProducto());
        productoService.update(producto);

        return response;
    }

}
