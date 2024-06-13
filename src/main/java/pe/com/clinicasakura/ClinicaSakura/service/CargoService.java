package pe.com.clinicasakura.ClinicaSakura.service;

import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import java.util.List;

public interface CargoService {
    List<CargoEntity> findAll();
    CargoEntity findById(Long id);
    CargoEntity save(CargoEntity cargo);
    void deleteById(Long id);
}
