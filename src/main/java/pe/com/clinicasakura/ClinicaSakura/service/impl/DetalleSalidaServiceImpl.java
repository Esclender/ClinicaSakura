package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DetalleSalidaRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleSalidaService;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleSalidaServiceImpl implements DetalleSalidaService {
    
    @Autowired
    private  DetalleSalidaRepository detalleSalidaRepository;

    @Override
    public List<DetalleSalidaEntity> findAll() {
        return detalleSalidaRepository.findAll();
    }

    @Override
    public DetalleSalidaEntity add(DetalleSalidaEntity detalleSalida) {
        return detalleSalidaRepository.save(detalleSalida);
    }

    @Override
    public Page<DetalleSalidaEntity> findAllCustom(Pageable pageable) {
        return detalleSalidaRepository.findAllCustom(pageable);
   }

    @Override
    public Optional<DetalleSalidaEntity> findById(Long id) {
     return detalleSalidaRepository.findById(id);
    }

    @Override
    public DetalleSalidaEntity update(DetalleSalidaEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleSalidaEntity delete(DetalleSalidaEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleSalidaEntity enable(DetalleSalidaEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Page<DetalleSalidaEntity> obtenerPaginas(Pageable pageable) {
        return detalleSalidaRepository.findAll(pageable);
    }
}
