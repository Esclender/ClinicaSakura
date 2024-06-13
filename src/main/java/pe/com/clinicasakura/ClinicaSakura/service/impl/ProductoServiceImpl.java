package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.ProductoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        // Aquí iría la lógica personalizada si fuera necesaria
        return productoRepository.findAll(); // Ejemplo, podría cambiarse
    }

    @Override
    public Optional<ProductoEntity> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoEntity add(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public ProductoEntity update(ProductoEntity producto) {
        ProductoEntity obj = productoRepository.getById(producto.getCodigo());
        BeanUtils.copyProperties(producto, obj);
        return productoRepository.save(obj);
    }

    @Override
    public ProductoEntity delete(ProductoEntity producto) {
        ProductoEntity obj = productoRepository.getById(producto.getCodigo());
        // Aquí se asume que hay un campo estado en ProductoEntity que se maneja similar a ArtefactoEntity
        obj.setEstado(false); 
        return productoRepository.save(obj);
    }

    @Override
    public ProductoEntity enable(ProductoEntity producto) {
        ProductoEntity obj = productoRepository.getById(producto.getCodigo());
        // Aquí se asume que hay un campo estado en ProductoEntity que se maneja similar a ArtefactoEntity
        obj.setEstado(true); 
        return productoRepository.save(obj);
    }
}
