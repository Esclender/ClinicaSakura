package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.DetalleSalidaRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.DetalleSalidaService;

@Service
public class DetalleSalidaServiceImpl implements DetalleSalidaService {

    @Autowired
    private DetalleSalidaRepository detalleSalidaRepository;

    @Override
    public Page<DetalleSalidaEntity> findAll(Pageable pageable) {
        return detalleSalidaRepository.findAll(pageable);
    }

    @Override
    public Page<DetalleSalidaEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public DetalleSalidaEntity findById(Long id) {
        Optional<DetalleSalidaEntity> optional = detalleSalidaRepository.findById(id);
        return optional.get();
    }

    @Override
    public DetalleSalidaEntity add(DetalleSalidaEntity t) {
        return detalleSalidaRepository.save(t);
    }

    @Override
    public DetalleSalidaEntity update(DetalleSalidaEntity t, Long id) {
        DetalleSalidaEntity obj = detalleSalidaRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return detalleSalidaRepository.save(obj);
    }

    @Override
    public DetalleSalidaEntity delete(Long id) {
        DetalleSalidaEntity obj = detalleSalidaRepository.getReferenceById(id);
        obj.setEstado(false);
        return detalleSalidaRepository.save(obj);
    }

    @Override
    public DetalleSalidaEntity enable(Long id) {
        DetalleSalidaEntity obj = detalleSalidaRepository.getReferenceById(id);
        obj.setEstado(true);
        return detalleSalidaRepository.save(obj);
    }
}
