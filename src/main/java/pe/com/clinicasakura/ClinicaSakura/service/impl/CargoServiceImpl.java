package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.CargoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;
import java.util.List;

@Service
public class CargoServiceImpl extends CargoService {

    @Autowired
    private CargoRepository repositorio;

    @Override
    public List<CargoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Page<CargoEntity> findAllCustom(Pageable pageable) {
        return repositorio.findAllCustom(pageable);
    }

    @Override
    public CargoEntity findById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Page<CargoEntity> obtenerPaginas(Pageable pageable) {
        return repositorio.findAll(pageable);
    }
}
