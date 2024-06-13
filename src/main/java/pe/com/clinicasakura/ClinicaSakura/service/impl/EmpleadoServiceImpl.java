package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
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
    public Optional<EmpleadoEntity> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity empleado) {
        empleadoRepository.delete(empleado);
        return empleado;
    }

    @Override
    public EmpleadoEntity enable(EmpleadoEntity empleado) {
        // Implementación según la lógica de tu aplicación (activar/desactivar empleado)
        return empleadoRepository.save(empleado);
    }

    @Override
    public Page<EmpleadoEntity> obtenerPaginas(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    @Override
    public Page<EmpleadoEntity> findAllCustom(Pageable pageable) {
        return empleadoRepository.findAllCustom(pageable);
    }
}
