
package pe.com.ferreteriamas.FerreteriaMas.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.ferreteriamas.FerreteriaMas.model.CategoriaProductoEntity;
import pe.com.ferreteriamas.FerreteriaMas.repository.CategoriaProductoRepository;
import pe.com.ferreteriamas.FerreteriaMas.service.CategoriaProductoService;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public Page<CategoriaProductoEntity> findAll(Pageable pageable) {
        return categoriaProductoRepository.findAll(pageable);
    }

    @Override
    public Page<CategoriaProductoEntity> findAllCustom(Pageable pageable) {
        return null;
    }

    @Override
    public CategoriaProductoEntity findById(Long id) {
        Optional<CategoriaProductoEntity> optional = categoriaProductoRepository.findById(id);
        return optional.get();
    }

    @Override
    public CategoriaProductoEntity add(CategoriaProductoEntity t) {
        return categoriaProductoRepository.save(t);
    }

    @Override
    public CategoriaProductoEntity update(CategoriaProductoEntity t, Long id) {
        CategoriaProductoEntity obj = categoriaProductoRepository.getReferenceById(id);
        BeanUtils.copyProperties(t, obj);
        return categoriaProductoRepository.save(obj);
    }

    @Override
    public CategoriaProductoEntity delete(Long id) {
        CategoriaProductoEntity obj = categoriaProductoRepository.getReferenceById(id);
        obj.setEstado(false);
        return categoriaProductoRepository.save(obj);
    }

    @Override
    public CategoriaProductoEntity enable(Long id) {
        CategoriaProductoEntity obj = categoriaProductoRepository.getReferenceById(id);
        obj.setEstado(true);
        return categoriaProductoRepository.save(obj);
    }
}
