package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DistritoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;

import java.util.List;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoEntity> findAll() {
        return distritoRepository.findAll();
    }

    @Override
    public List<DistritoEntity> findAllCustom() {
        // Implementación específica de findAllCustom si es necesario
        return null;
    }

    @Override
    public Optional<DistritoEntity> findById(Long id) {
        return distritoRepository.findById(id);
    }

    @Override
    public DistritoEntity add(DistritoEntity distrito) {
        return distritoRepository.save(distrito);
    }

    @Override
    public DistritoEntity update(DistritoEntity distrito) {
        DistritoEntity existingEntity = distritoRepository.getById(distrito.getCodigo());
        BeanUtils.copyProperties(distrito, existingEntity, "codigo"); // Copia todas las propiedades excepto 'codigo'
        return distritoRepository.save(existingEntity);
    }

    @Override
    public DistritoEntity delete(DistritoEntity distrito) {
        DistritoEntity existingEntity = distritoRepository.getById(distrito.getCodigo());
        distritoRepository.delete(existingEntity);
        return existingEntity;
    }

    @Override
    public DistritoEntity enable(DistritoEntity distrito) {
        // Implementación específica si se requiere activar un distrito
        return null;
    }
}
