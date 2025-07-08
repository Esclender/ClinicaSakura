package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.DistritoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.DistritoRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.DistritoService;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public Page<DistritoEntity> findAll(Pageable pageable) {
        return distritoRepository.findAll(pageable);
    }

    @Override
    public Page<DistritoEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public DistritoEntity findById(Long id) {
        Optional<DistritoEntity> optional = distritoRepository.findById(id);
        return optional.get();
    }

    @Override
    public DistritoEntity add(DistritoEntity t) {
        return distritoRepository.save(t);
    }

    @Override
    public DistritoEntity update(DistritoEntity t, Long id) {
        DistritoEntity obj = distritoRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return distritoRepository.save(obj);
    }

    @Override
    public DistritoEntity delete(Long id) {
        DistritoEntity obj = distritoRepository.getReferenceById(id);
        obj.setEstado(false);
        return distritoRepository.save(obj);
    }

    @Override
    public DistritoEntity enable(Long id) {
        DistritoEntity obj = distritoRepository.getReferenceById(id);
        obj.setEstado(true);
        return distritoRepository.save(obj);
    }
}
