package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.TipoDocumentoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.TipoDocumentoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.TipoDocumentoService;

import java.util.List;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    @Override
    public List<TipoDocumentoEntity> findAll() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumentoEntity findById(Long id) {
        return tipoDocumentoRepository.findById(id).get();
    }

}
