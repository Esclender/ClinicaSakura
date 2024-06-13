package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.RegistroEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.RegistroEntradaRepository;
import pe.com.clinicasakura.ClinicaSakura.service.RegistroEntradaService;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroEntradaServiceImpl implements RegistroEntradaService {

    @Autowired
    private RegistroEntradaRepository registroEntradaRepository;

    @Override
    public List<RegistroEntradaEntity> findAll() {
        return registroEntradaRepository.findAll();
    }

    // Método customizado, similar a findAllCustom
    public List<RegistroEntradaEntity> findAllCustom() {
        // Aquí iría la lógica personalizada si fuera necesaria
        return registroEntradaRepository.findAll(); // Ejemplo, podría cambiarse
    }

    @Override
    public Optional<RegistroEntradaEntity> findById(Long id) {
        return registroEntradaRepository.findById(id);
    }

    @Override
    public RegistroEntradaEntity add(RegistroEntradaEntity registroEntrada) {
        return registroEntradaRepository.save(registroEntrada);
    }

    @Override
    public RegistroEntradaEntity update(RegistroEntradaEntity registroEntrada) {
        RegistroEntradaEntity obj = registroEntradaRepository.getById(registroEntrada.getCodigo());
        BeanUtils.copyProperties(registroEntrada, obj);
        return registroEntradaRepository.save(obj);
    }

    @Override
    public RegistroEntradaEntity delete(RegistroEntradaEntity registroEntrada) {
        RegistroEntradaEntity obj = registroEntradaRepository.getById(registroEntrada.getCodigo());
        // Aquí se asume que hay un campo estado en RegistroEntradaEntity que se maneja similar a ArtefactoEntity
        obj.setEstado(false); 
        return registroEntradaRepository.save(obj);
    }

    @Override
    public RegistroEntradaEntity enable(RegistroEntradaEntity registroEntrada) {
        RegistroEntradaEntity obj = registroEntradaRepository.getById(registroEntrada.getCodigo());
        // Aquí se asume que hay un campo estado en RegistroEntradaEntity que se maneja similar a ArtefactoEntity
        obj.setEstado(true); 
        return registroEntradaRepository.save(obj);
    }
}
