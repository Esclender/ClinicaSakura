package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.CargoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;

import java.util.List;

@Service
public class CargoServiceImpl extends CargoService {

    private final CargoRepository cargoRepository;

    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<CargoEntity> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public CargoEntity findById(Long id) {
        return cargoRepository.findById(id).get();
    }

    @Override
    public CargoEntity add(CargoEntity cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public CargoEntity delete(Long id) {
        CargoEntity obj = cargoRepository.getById(id);
        obj.setEstado(false);
        return cargoRepository.save(obj);
    }

    @Override
    public CargoEntity enable(Long id) {
        CargoEntity obj = cargoRepository.getById(id);
        obj.setEstado(true);
        return cargoRepository.save(obj);
    }
}
