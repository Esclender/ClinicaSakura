
package pe.com.clinicasakura.ClinicaSakura.service.impl;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CategoriaProductoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<CategoriaProductoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public CategoriaProductoEntity add(CategoriaProductoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public CategoriaProductoEntity update(CategoriaProductoEntity t) {
        CategoriaProductoEntity obj = repositorio.getById(t.getCodigo());
        BeanUtils.copyProperties(t, obj);
        return repositorio.save(obj);
    }

    @Override
    public CategoriaProductoEntity delete(CategoriaProductoEntity t) {
        CategoriaProductoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(false);
        return repositorio.save(obj);
    }

    @Override
    public CategoriaProductoEntity enable(CategoriaProductoEntity t) {
        CategoriaProductoEntity obj = repositorio.getById(t.getCodigo());
        obj.setEstado(true);
        return repositorio.save(obj);
    }

}
