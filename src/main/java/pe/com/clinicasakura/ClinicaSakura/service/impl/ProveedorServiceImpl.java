package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.ProveedorEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.ProveedorRepository;
import pe.com.clinicasakura.ClinicaSakura.service.ProveedorService;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorEntity> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public List<ProveedorEntity> findAllCustom() {
        return proveedorRepository.findAllCustom();
    }

    @Override
    public Optional<ProveedorEntity> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public ProveedorEntity add(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public ProveedorEntity update(ProveedorEntity proveedor) {
        ProveedorEntity obj = proveedorRepository.getById(proveedor.getCodigo());
        BeanUtils.copyProperties(proveedor, obj);
        return proveedorRepository.save(obj);
    }

    @Override
    public ProveedorEntity delete(ProveedorEntity proveedor) {
        ProveedorEntity obj = proveedorRepository.getById(proveedor.getCodigo());
        obj.setEstado(false); // Cambiar estado si es necesario
        return proveedorRepository.save(obj);
    }

    @Override
    public ProveedorEntity enable(ProveedorEntity proveedor) {
        ProveedorEntity obj = proveedorRepository.getById(proveedor.getCodigo());
        obj.setEstado(true); // Cambiar estado si es necesario
        return proveedorRepository.save(obj);
    }
}
