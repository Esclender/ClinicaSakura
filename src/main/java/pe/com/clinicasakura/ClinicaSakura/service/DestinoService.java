package pe.com.clinicasakura.ClinicaSakura.service;

import pe.com.clinicasakura.ClinicaSakura.model.DestinoEntity;

import java.util.List;

public interface DestinoService {
    DestinoEntity guardarDestino(DestinoEntity destino);
    
    List<DestinoEntity> findAll();
    
    DestinoEntity add(DestinoEntity destino);
    
}


