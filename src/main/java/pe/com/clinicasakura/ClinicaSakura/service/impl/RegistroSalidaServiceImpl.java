package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.RegistroSalidaRepository;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroSalidaService;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroSalidaServiceImpl implements RegistroSalidaService {

    private final RegistroSalidaRepository registroSalidaRepository;

    @Autowired
    public RegistroSalidaServiceImpl(RegistroSalidaRepository registroSalidaRepository) {
        this.registroSalidaRepository = registroSalidaRepository;
    }

    @Override
    public List<RegistroSalidaEntity> findAll() {
        return registroSalidaRepository.findAll();
    }

    @Override
    public Page<RegistroSalidaEntity> findAllCustom(Pageable pageable) {
        return registroSalidaRepository.findAllCustom(pageable);
    }

    @Override
    public Optional<RegistroSalidaEntity> findById(Long id) {
        return registroSalidaRepository.findById(id);
    }

    @Override
    public RegistroSalidaEntity add(RegistroSalidaEntity registroSalida) {
        return registroSalidaRepository.save(registroSalida);
    }

    @Override
    public RegistroSalidaEntity update(RegistroSalidaEntity registroSalida) {
        RegistroSalidaEntity obj = registroSalidaRepository.getById(registroSalida.getCodigo());
        BeanUtils.copyProperties(registroSalida, obj);
        return registroSalidaRepository.save(obj);
    }

    @Override
    public RegistroSalidaEntity delete(RegistroSalidaEntity registroSalida) {
        RegistroSalidaEntity obj = registroSalidaRepository.getById(registroSalida.getCodigo());
        // Aquí se asume que hay un campo estado en RegistroSalidaEntity que se maneja
        // similar a ArtefactoEntity
        obj.setEstado(false);
        return registroSalidaRepository.save(obj);
    }

    @Override
    public RegistroSalidaEntity enable(RegistroSalidaEntity registroSalida) {
        RegistroSalidaEntity obj = registroSalidaRepository.getById(registroSalida.getCodigo());
        // Aquí se asume que hay un campo estado en RegistroSalidaEntity que se maneja
        // similar a ArtefactoEntity
        obj.setEstado(true);
        return registroSalidaRepository.save(obj);
    }

    @Override
    public Page<RegistroSalidaEntity> obtenerPaginas(Pageable pageable) {
        return registroSalidaRepository.findAll(pageable);
    }
}
