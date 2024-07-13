package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.CargoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.CargoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.CargoService;
import java.util.List;
import org.springframework.beans.BeanUtils;

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
    public CargoEntity add(CargoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public CargoEntity update(CargoEntity t) {
        CargoEntity obj = repositorio.getReferenceById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public CargoEntity delete(CargoEntity t) {
        CargoEntity obj = repositorio.getReferenceById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public CargoEntity enable(CargoEntity t) {
        CargoEntity obj = repositorio.getReferenceById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }

    @Override
    public Page<CargoEntity> obtenerPaginas(Pageable pageable) {
        return repositorio.findAll(pageable);
    }
}
