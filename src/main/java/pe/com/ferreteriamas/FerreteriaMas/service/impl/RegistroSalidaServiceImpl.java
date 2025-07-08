package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.RegistroSalidaRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.RegistroSalidaService;

@Service
public class RegistroSalidaServiceImpl implements RegistroSalidaService {

    @Autowired
    private RegistroSalidaRepository registroSalidaRepository;

    @Override
    public Page<RegistroSalidaEntity> findAll(Pageable pageable) {
        return registroSalidaRepository.findAll(pageable);
    }

    @Override
    public Page<RegistroSalidaEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public RegistroSalidaEntity findById(Long id) {
        Optional<RegistroSalidaEntity> optional = registroSalidaRepository.findById(id);
        return optional.get();
    }

    @Override
    public RegistroSalidaEntity add(RegistroSalidaEntity t) {
        return registroSalidaRepository.save(t);
    }

    @Override
    public RegistroSalidaEntity update(RegistroSalidaEntity t, Long id) {
        RegistroSalidaEntity obj = registroSalidaRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return registroSalidaRepository.save(obj);
    }

    @Override
    public RegistroSalidaEntity delete(Long id) {
        RegistroSalidaEntity obj = registroSalidaRepository.getReferenceById(id);
        obj.setEstado(false);
        return registroSalidaRepository.save(obj);
    }

    @Override
    public RegistroSalidaEntity enable(Long id) {
        RegistroSalidaEntity obj = registroSalidaRepository.getReferenceById(id);
        obj.setEstado(true);
        return registroSalidaRepository.save(obj);
    }
}
