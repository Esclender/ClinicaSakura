package pe.com.clinicasakura.ClinicaSakura.service;

import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import java.util.List;

public interface DetalleEntradaService {
    
    List<DetalleEntradaEntity> findAll();

    DetalleEntradaEntity add(DetalleEntradaEntity detalleEntrada);
}
