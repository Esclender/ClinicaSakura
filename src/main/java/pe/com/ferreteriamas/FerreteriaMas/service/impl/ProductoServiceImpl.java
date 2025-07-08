
package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.ProductoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.ProductoRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Page<ProductoEntity> findAll(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public Page<ProductoEntity> findAllCustom(Pageable pageable) {
        return productoRepository.findAllCustom(pageable);
    }

    @Override
    public ProductoEntity findById(Long id) {
        Optional<ProductoEntity> optional = productoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public ProductoEntity add(ProductoEntity t) {
        return productoRepository.save(t);
    }

    @Override
    public ProductoEntity update(ProductoEntity t, Long id) {
        ProductoEntity obj = productoRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj, "codigo"); // Don't copy the ID
        return productoRepository.save(obj);
    }

    @Override
    public ProductoEntity delete(Long id) {
        ProductoEntity obj = productoRepository.getReferenceById(id);
        obj.setEstado(false);
        return productoRepository.save(obj);
    }

    @Override
    public ProductoEntity enable(Long id) {
        ProductoEntity obj = productoRepository.getReferenceById(id);
        obj.setEstado(true);
        return productoRepository.save(obj);
    }
}
