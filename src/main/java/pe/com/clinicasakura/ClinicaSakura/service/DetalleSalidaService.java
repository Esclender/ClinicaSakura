package pe.com.clinicasakura.ClinicaSakura.service;

import pe.com.clinicasakura.ClinicaSakura.model.DetalleSalidaEntity;

import java.util.List;

public interface DetalleSalidaService {
    DetalleSalidaEntity guardarDetalleSalida(DetalleSalidaEntity detalleSalida);
    
    List<DetalleSalidaEntity> findAll();
    
    DetalleSalidaEntity add(DetalleSalidaEntity detalleEntrada);
    
    
}

