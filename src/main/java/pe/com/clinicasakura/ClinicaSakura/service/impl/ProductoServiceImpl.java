
package pe.com.clinicasakura.ClinicaSakura.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.ProductoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<ProductoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ProductoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ProductoEntity add(ProductoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ProductoEntity update(ProductoEntity t) {
        ProductoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public ProductoEntity delete(ProductoEntity t) {
        ProductoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public ProductoEntity enable(ProductoEntity t) {
        ProductoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }

}
