package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.DestinoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.DestinoRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public Page<DestinoEntity> findAll(Pageable pageable) {
        return destinoRepository.findAll(pageable);
    }

    @Override
    public Page<DestinoEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public DestinoEntity findById(Long id) {
        Optional<DestinoEntity> optional = destinoRepository.findById(id);
        return optional.get();
    }

    @Override
    public DestinoEntity add(DestinoEntity t) {
        return destinoRepository.save(t);
    }

    @Override
    public DestinoEntity update(DestinoEntity t, Long id) {
        DestinoEntity obj = destinoRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return destinoRepository.save(obj);
    }

    @Override
    public DestinoEntity delete(Long id) {
        DestinoEntity obj = destinoRepository.getReferenceById(id);
        obj.setEstado(false);
        return destinoRepository.save(obj);
    }

    @Override
    public DestinoEntity enable(Long id) {
        DestinoEntity obj = destinoRepository.getReferenceById(id);
        obj.setEstado(true);
        return destinoRepository.save(obj);
    }
}
