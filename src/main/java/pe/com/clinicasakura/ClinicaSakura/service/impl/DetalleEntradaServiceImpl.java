package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DetalleEntradaRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleEntradaService;

import java.util.List;

@Service
public class DetalleEntradaServiceImpl implements DetalleEntradaService {

    private final DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    public DetalleEntradaServiceImpl(DetalleEntradaRepository detalleEntradaRepository) {
        this.detalleEntradaRepository = detalleEntradaRepository;
    }

    @Override
    public List<DetalleEntradaEntity> findAll() {
        return detalleEntradaRepository.findAll();
    }

    @Override
    public DetalleEntradaEntity add(DetalleEntradaEntity detalleEntrada) {
        return detalleEntradaRepository.save(detalleEntrada);
    }
}
