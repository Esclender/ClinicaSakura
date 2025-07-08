package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.TipoDocumentoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.TipoDocumentoRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public Page<TipoDocumentoEntity> findAll(Pageable pageable) {
        return tipoDocumentoRepository.findAll(pageable);
    }

    @Override
    public Page<TipoDocumentoEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public TipoDocumentoEntity findById(Long id) {
        Optional<TipoDocumentoEntity> optional = tipoDocumentoRepository.findById(id);
        return optional.get();
    }

    @Override
    public TipoDocumentoEntity add(TipoDocumentoEntity t) {
        return tipoDocumentoRepository.save(t);
    }

    @Override
    public TipoDocumentoEntity update(TipoDocumentoEntity t, Long id) {
        TipoDocumentoEntity obj = tipoDocumentoRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return tipoDocumentoRepository.save(obj);
    }

    @Override
    public TipoDocumentoEntity delete(Long id) {
        TipoDocumentoEntity obj = tipoDocumentoRepository.getReferenceById(id);
        obj.setEstado(false);
        return tipoDocumentoRepository.save(obj);
    }

    @Override
    public TipoDocumentoEntity enable(Long id) {
        TipoDocumentoEntity obj = tipoDocumentoRepository.getReferenceById(id);
        obj.setEstado(true);
        return tipoDocumentoRepository.save(obj);
    }
}
