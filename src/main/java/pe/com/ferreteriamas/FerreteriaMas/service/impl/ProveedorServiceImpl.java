package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.ProveedorEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.ProveedorRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Page<ProveedorEntity> findAll(Pageable pageable) {
        return proveedorRepository.findAll(pageable);
    }

    @Override
    public Page<ProveedorEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public ProveedorEntity findById(Long id) {
        Optional<ProveedorEntity> optional = proveedorRepository.findById(id);
        return optional.get();
    }

    @Override
    public ProveedorEntity add(ProveedorEntity t) {
        return proveedorRepository.save(t);
    }

    @Override
    public ProveedorEntity update(ProveedorEntity t, Long id) {
        ProveedorEntity obj = proveedorRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return proveedorRepository.save(obj);
    }

    @Override
    public ProveedorEntity delete(Long id) {
        ProveedorEntity obj = proveedorRepository.getReferenceById(id);
        obj.setEstado(false);
        return proveedorRepository.save(obj);
    }

    @Override
    public ProveedorEntity enable(Long id) {
        ProveedorEntity obj = proveedorRepository.getReferenceById(id);
        obj.setEstado(true);
        return proveedorRepository.save(obj);
    }
}
