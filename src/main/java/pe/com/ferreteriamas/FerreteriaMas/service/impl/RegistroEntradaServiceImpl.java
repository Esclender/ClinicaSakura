package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.ProductoEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.ProductoRepository;
import pe.com.ferreteriamas.FerreteriaMas.repository.RegistroEntradaRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.RegistroEntradaService;

@Service
public class RegistroEntradaServiceImpl implements RegistroEntradaService {

    @Autowired
    private RegistroEntradaRepository registroEntradaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Page<RegistroEntradaEntity> findAll(Pageable pageable) {
        return registroEntradaRepository.findAll(pageable);
    }

    @Override
    public Page<RegistroEntradaEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public RegistroEntradaEntity findById(Long id) {
        Optional<RegistroEntradaEntity> optional = registroEntradaRepository.findById(id);
        return optional.get();
    }

    @Override
    public RegistroEntradaEntity add(RegistroEntradaEntity t) {
        return registroEntradaRepository.save(t);
    }

    @Override
    public RegistroEntradaEntity update(RegistroEntradaEntity t, Long id) {
        RegistroEntradaEntity obj = registroEntradaRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return registroEntradaRepository.save(obj);
    }

    @Override
    public RegistroEntradaEntity delete(Long id) {
        RegistroEntradaEntity obj = registroEntradaRepository.getReferenceById(id);
        obj.setEstado(false);
        return registroEntradaRepository.save(obj);
    }

    @Override
    public RegistroEntradaEntity enable(Long id) {
        RegistroEntradaEntity obj = registroEntradaRepository.getReferenceById(id);
        obj.setEstado(true);
        return registroEntradaRepository.save(obj);
    }
}
