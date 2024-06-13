package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DetalleSalidaRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleSalidaService;

import java.util.List;

@Service
public class DetalleSalidaServiceImpl implements DetalleSalidaService {

    private final DetalleSalidaRepository detalleSalidaRepository;

    @Autowired
    public DetalleSalidaServiceImpl(DetalleSalidaRepository detalleSalidaRepository) {
        this.detalleSalidaRepository = detalleSalidaRepository;
    }

    @Override
    public DetalleSalidaEntity guardarDetalleSalida(DetalleSalidaEntity detalleSalida) {
        return detalleSalidaRepository.save(detalleSalida);
    }

    @Override
    public List<DetalleSalidaEntity> findAll() {
        return detalleSalidaRepository.findAll();
    }

    @Override
    public DetalleSalidaEntity add(DetalleSalidaEntity detalleSalida) {
        return detalleSalidaRepository.save(detalleSalida);
    }
}
