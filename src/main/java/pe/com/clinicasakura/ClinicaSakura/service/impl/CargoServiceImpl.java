package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.CargoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<CargoEntity> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public CargoEntity findById(Long id) {
        return cargoRepository.findById(id).orElse(null);
    }

    @Override
    public CargoEntity save(CargoEntity cargo) {
        return cargoRepository.save(cargo);
    }

    
    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }
}
