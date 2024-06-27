package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.EmpleadoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<EmpleadoEntity> findAll() {
        return empleadoRepository.findAll();
    }
    @Override
    public Page<EmpleadoEntity> findAllCustom(Pageable pageable) {
        return empleadoRepository.findAllCustom(pageable);
    }

    @Override
    public Optional<EmpleadoEntity> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity empleado) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(empleado.getCodigo());
        BeanUtils.copyProperties(empleado, obj);
        return empleadoRepository.save(obj);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity empleado) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(empleado.getCodigo());
        obj.setEstado(false);
        return empleadoRepository.save(obj);
    }

    @Override
    public EmpleadoEntity enable(EmpleadoEntity empleado) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(empleado.getCodigo());
        obj.setEstado(true);
        return empleadoRepository.save(obj);
    }

    @Override
    public Page<EmpleadoEntity> obtenerPaginas(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    
}
