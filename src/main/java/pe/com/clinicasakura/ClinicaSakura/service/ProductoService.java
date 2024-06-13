package pe.com.clinicasakura.ClinicaSakura.service;

import pe.com.clinicasakura.ClinicaSakura.model.ProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public interface ProductoService extends BaseService<ProductoEntity> {

    List<ProductoEntity> findAllCustom();
}
