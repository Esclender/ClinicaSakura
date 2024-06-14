package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.DetalleEntradaEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.DetalleEntradaRepository;
import pe.com.clinicasakura.ClinicaSakura.service.DetalleEntradaService;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class DetalleEntradaServiceImpl implements DetalleEntradaService {

    private DetalleEntradaRepository detalleEntradaRepository;

    @Autowired
    public DetalleEntradaServiceImpl(DetalleEntradaRepository detalleEntradaRepository) {
        this.detalleEntradaRepository = detalleEntradaRepository;
    }

    @Override
    public List<DetalleEntradaEntity> findAll() {
        return detalleEntradaRepository.findAll();
    }

    @Override
    public DetalleEntradaEntity add(DetalleEntradaEntity detalleEntrada) {
        return detalleEntradaRepository.save(detalleEntrada);
    }

    @Override
    public Page<DetalleEntradaEntity> findAllCustom(Pageable pageable) {
        return detalleEntradaRepository.findAllCustom(pageable);
    }

    @Override
    public Optional<DetalleEntradaEntity> findById(Long id) {
        return detalleEntradaRepository.findById(id);
    }

    @Override
    public DetalleEntradaEntity update(DetalleEntradaEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleEntradaEntity delete(DetalleEntradaEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DetalleEntradaEntity enable(DetalleEntradaEntity t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<DetalleEntradaEntity> obtenerPaginas(Pageable pageable) {
        return detalleEntradaRepository.findAll(pageable);
    }
}
