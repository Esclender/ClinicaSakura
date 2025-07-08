package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.CargoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.CargoRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Page<CargoEntity> findAll(Pageable pageable) {
        return cargoRepository.findAll(pageable);
    }

    @Override
    public Page<CargoEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public CargoEntity findById(Long id) {
        Optional<CargoEntity> optional = cargoRepository.findById(id);
        return optional.get();
    }

    @Override
    public CargoEntity add(CargoEntity t) {
        return cargoRepository.save(t);
    }

    @Override
    public CargoEntity update(CargoEntity t, Long id) {
        t.setCodigo(id);
        return cargoRepository.save(t);
    }

    @Override
    public CargoEntity delete(Long id) {
        CargoEntity obj = cargoRepository.getReferenceById(id);
        obj.setEstado(false);
        return cargoRepository.save(obj);
    }

    @Override
    public CargoEntity enable(Long id) {
        CargoEntity obj = cargoRepository.getReferenceById(id);
        obj.setEstado(true);
        return cargoRepository.save(obj);
    }

}
