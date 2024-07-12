package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.EmpleadoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private final EmpleadoRepository empleadoRepository;

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
    public EmpleadoEntity findById(Long id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity empleado, Long id) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(id);
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
    public EmpleadoEntity enable(Long id) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(id);
        obj.setEstado(true);
        return empleadoRepository.save(obj);
    }

    @Override
    public Page<EmpleadoEntity> obtenerPaginas(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

}
