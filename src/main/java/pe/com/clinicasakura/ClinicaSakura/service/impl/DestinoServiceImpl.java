package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.DestinoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DestinoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DestinoService;

import java.util.List;

@Service
public class DestinoServiceImpl implements DestinoService {

    private final DestinoRepository destinoRepository;

    @Autowired
    public DestinoServiceImpl(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    @Override
    public DestinoEntity guardarDestino(DestinoEntity destino) {
        return destinoRepository.save(destino);
    }

    @Override
    public List<DestinoEntity> findAll() {
        return destinoRepository.findAll();
    }

    @Override
    public DestinoEntity add(DestinoEntity destino) {
        return destinoRepository.save(destino);
    }
}
