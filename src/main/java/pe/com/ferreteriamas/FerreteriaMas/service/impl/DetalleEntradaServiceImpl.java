package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.DetalleEntradaRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.DetalleEntradaService;

@Service
public class DetalleEntradaServiceImpl implements DetalleEntradaService {

    @Autowired
    private DetalleEntradaRepository detalleEntradaRepository;

    @Override
    public Page<DetalleEntradaEntity> findAll(Pageable pageable) {
        return detalleEntradaRepository.findAll(pageable);
    }

    @Override
    public Page<DetalleEntradaEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public DetalleEntradaEntity findById(Long id) {
        Optional<DetalleEntradaEntity> optional = detalleEntradaRepository.findById(id);
        return optional.get();
    }

    @Override
    public DetalleEntradaEntity add(DetalleEntradaEntity t) {
        return detalleEntradaRepository.save(t);
    }

    @Override
    public DetalleEntradaEntity update(DetalleEntradaEntity t, Long id) {
        DetalleEntradaEntity obj = detalleEntradaRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return detalleEntradaRepository.save(obj);
    }

    @Override
    public DetalleEntradaEntity delete(Long id) {
        DetalleEntradaEntity obj = detalleEntradaRepository.getReferenceById(id);
        obj.setEstado(false);
        return detalleEntradaRepository.save(obj);
    }

    @Override
    public DetalleEntradaEntity enable(Long id) {
        DetalleEntradaEntity obj = detalleEntradaRepository.getReferenceById(id);
        obj.setEstado(true);
        return detalleEntradaRepository.save(obj);
    }
}
