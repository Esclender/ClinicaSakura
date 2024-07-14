package pe.com.clinicasakura.ClinicaSakura.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.clinicasakura.ClinicaSakura.dtos.entradas.RegistroEntradaResponseDto;
import pe.com.clinicasakura.ClinicaSakura.dtos.entradas.RegistroEntradaRestDto;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.EmpleadoRepository;
import pe.com.clinicasakura.ClinicaSakura.repository.ProductoRepository;
import pe.com.clinicasakura.ClinicaSakura.repository.ProveedorRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleEntradaService;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroEntradaService;

@RestController
@RequestMapping("/api/v1/entrada")
public class RegistroEntradaRestController {

    @Autowired
    private RegistroEntradaService service;

    @Autowired
    private DetalleEntradaService detalleEntradaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<RegistroEntradaEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/custom")
    public Page<RegistroEntradaEntity> findAllCustom(Pageable pageable) {
        return service.findAllCustom(pageable);
    }

    @GetMapping("/{id}")
    public RegistroEntradaEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroEntradaResponseDto add(@RequestBody RegistroEntradaRestDto registro) {
        ProveedorEntity proveedor = proveedorRepository.findById(registro.getCodigoProveedor()).get();
        EmpleadoEntity empleado = empleadoRepository.findById(registro.getCodigoEmpleado()).get();
        ProductoEntity producto = productoRepository.findById(registro.getCodigoProducto()).get();

        RegistroEntradaEntity registroEntrada = new RegistroEntradaEntity();
        registroEntrada.setCodigoEmpleado(empleado);
        registroEntrada.setCodigoProveedor(proveedor);
        registroEntrada.setFecha(registro.getFecha());
        RegistroEntradaEntity objSaved = service.add(registroEntrada);

        DetalleEntradaEntity detalles = new DetalleEntradaEntity();
        detalles.setCantidadProducto(registro.getCantidadProducto());
        detalles.setCodigoProducto(producto);
        detalles.setPrecioProducto(registro.getPrecioProducto());
        detalles.setCodigoRegistroEntrada(objSaved);
        detalleEntradaService.add(detalles);

        RegistroEntradaResponseDto response = new RegistroEntradaResponseDto();
        response.setCodigo(objSaved.getCodigo());
        response.setFecha(registro.getFecha());
        response.setProveedor(proveedor);
        response.setEmpleado(empleado);
        response.setProducto(producto);
        response.setCantidadProducto(registro.getCantidadProducto());
        response.setPrecioProducto(registro.getPrecioProducto());

        producto.increaseCantidad(registro.getCantidadProducto());
        productoService.update(producto);

        return response;
    }

    @PutMapping("/{id}")
    public RegistroEntradaEntity update(@PathVariable long id, @RequestBody RegistroEntradaEntity t) {
        return service.update(t);
    }

    @DeleteMapping("/{id}")
    public RegistroEntradaEntity delete(@PathVariable long id, @RequestBody RegistroEntradaEntity t) {
        return service.delete(t);
    }

    @PutMapping("/enable/{id}")
    public RegistroEntradaEntity enable(@PathVariable long id, @RequestBody RegistroEntradaEntity t) {
        return service.enable(t);
    }

}
