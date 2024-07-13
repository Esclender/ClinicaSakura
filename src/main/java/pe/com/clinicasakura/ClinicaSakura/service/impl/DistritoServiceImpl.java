package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.DistritoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DistritoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DistritoService;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoEntity> findAll() {
        return distritoRepository.findAll();
    }

    @Override
    public DistritoEntity findById(Long id) {
        return distritoRepository.findById(id).get();
    }

}
