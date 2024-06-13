package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.TipoDocumentoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.TipoDocumentoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.TipoDocumentoService;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumentoEntity> findAll() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public Optional<TipoDocumentoEntity> findById(Long id) {
        return tipoDocumentoRepository.findById(id);
    }

    @Override
    public TipoDocumentoEntity add(TipoDocumentoEntity tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public TipoDocumentoEntity update(TipoDocumentoEntity tipoDocumento) {
        TipoDocumentoEntity obj = tipoDocumentoRepository.getById(tipoDocumento.getCodigo());
        BeanUtils.copyProperties(tipoDocumento, obj);
        return tipoDocumentoRepository.save(obj);
    }

    @Override
    public TipoDocumentoEntity delete(TipoDocumentoEntity tipoDocumento) {
        TipoDocumentoEntity obj = tipoDocumentoRepository.getById(tipoDocumento.getCodigo());
        obj.setEstado(false); // Cambiar estado si es necesario
        return tipoDocumentoRepository.save(obj);
    }

    @Override
    public TipoDocumentoEntity enable(TipoDocumentoEntity tipoDocumento) {
        TipoDocumentoEntity obj = tipoDocumentoRepository.getById(tipoDocumento.getCodigo());
        obj.setEstado(true); // Cambiar estado si es necesario
        return tipoDocumentoRepository.save(obj);
    }

    @Override
    public Page<TipoDocumentoEntity> obtenerPaginas(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPaginas'");
    }

    @Override
    public Page<TipoDocumentoEntity> findAllCustom(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllCustom'");
    }
}
