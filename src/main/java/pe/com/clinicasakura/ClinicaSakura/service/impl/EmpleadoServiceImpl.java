package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.EmpleadoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.EmpleadoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.EmpleadoService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        // Aquí iría la lógica personalizada si fuera necesaria
        return empleadoRepository.findAll(); // Ejemplo, podría cambiarse
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
        EmpleadoEntity obj = empleadoRepository.getById(empleado.getCodigo());
        BeanUtils.copyProperties(empleado, obj);
        return empleadoRepository.save(obj);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity empleado) {
        EmpleadoEntity obj = empleadoRepository.getById(empleado.getCodigo());
        // Aquí se asume que hay un campo estado en EmpleadoEntity que se maneja similar a ArtefactoEntity
        obj.setEstado(false); 
        return empleadoRepository.save(obj);
    }

    @Override
    public EmpleadoEntity enable(EmpleadoEntity empleado) {
        EmpleadoEntity obj = empleadoRepository.getById(empleado.getCodigo());
        // Aquí se asume que hay un campo estado en EmpleadoEntity que se maneja similar a ArtefactoEntity
        obj.setEstado(true); 
        return empleadoRepository.save(obj);
    }
}
