package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.EmpleadoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.EmpleadoRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Page<EmpleadoEntity> findAll(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }

    @Override
    public Page<EmpleadoEntity> findAllCustom(Pageable pageable) {
        return empleadoRepository.findAllCustom(pageable);
    }

    @Override
    public EmpleadoEntity findById(Long id) {
        Optional<EmpleadoEntity> optional = empleadoRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity t) {
        return empleadoRepository.save(t);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity t, Long id) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj, "codigo"); // Don't copy the ID
        return empleadoRepository.save(obj);
    }

    @Override
    public EmpleadoEntity delete(Long id) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(id);
        obj.setEstado(false);
        return empleadoRepository.save(obj);
    }

    @Override
    public EmpleadoEntity enable(Long id) {
        EmpleadoEntity obj = empleadoRepository.getReferenceById(id);
        obj.setEstado(true);
        return empleadoRepository.save(obj);
    }
}
