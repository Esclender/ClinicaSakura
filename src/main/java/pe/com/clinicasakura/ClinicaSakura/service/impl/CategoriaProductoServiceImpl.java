
package pe.com.clinicasakura.ClinicaSakura.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.CategoriaProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.CategoriaProductoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.CategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository repositorio;

    @Override
    public List<CategoriaProductoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public CategoriaProductoEntity findById(Long id) {
        return repositorio.findById(id).orElseThrow();
    }

    @Override
    public CategoriaProductoEntity add(CategoriaProductoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public CategoriaProductoEntity update(CategoriaProductoEntity t) {
        CategoriaProductoEntity obj = repositorio.findById(t.getCodigo()).get();
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public CategoriaProductoEntity delete(CategoriaProductoEntity t) {
        CategoriaProductoEntity obj = repositorio.findById(t.getCodigo()).get();
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public CategoriaProductoEntity enable(CategoriaProductoEntity t) {
        CategoriaProductoEntity obj = repositorio.findById(t.getCodigo()).get();
        obj.setEstado(true);
        return repositorio.save(obj);
    }

    @Override
    public Page<CategoriaProductoEntity> obtenerPaginas(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPaginas'");
    }

    @Override
    public Page<CategoriaProductoEntity> findAllCustom(Pageable pageable) {
        return repositorio.findAllCustom(pageable);
    }

}
