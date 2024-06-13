package pe.com.clinicasakura.ClinicaSakura.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clinicasakura.ClinicaSakura.model.CategoriaProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.CategoriaProductoRepository;
import pe.com.clinicasakura.ClinicaSakura.service.CategoriaProductoService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public List<CategoriaProductoEntity> findAll() {
        return categoriaProductoRepository.findAll();
    }

    @Override
    public List<CategoriaProductoEntity> findAllCustom() {
        // Implementación específica de findAllCustom si es necesario
        return null;
    }

    @Override
    public Optional<CategoriaProductoEntity> findById(Long id) {
        return categoriaProductoRepository.findById(id);
    }

    @Override
    public CategoriaProductoEntity add(CategoriaProductoEntity categoriaProducto) {
        return categoriaProductoRepository.save(categoriaProducto);
    }

    @Override
    public CategoriaProductoEntity update(CategoriaProductoEntity categoriaProducto) {
        CategoriaProductoEntity existingEntity = categoriaProductoRepository.getReferenceById(categoriaProducto.getCodigo());
        BeanUtils.copyProperties(categoriaProducto, existingEntity, "codigo"); // Copia todas las propiedades excepto 'codigo'
        return categoriaProductoRepository.save(existingEntity);
    }

    @Override
    public CategoriaProductoEntity delete(CategoriaProductoEntity categoriaProducto) {
        CategoriaProductoEntity existingEntity = categoriaProductoRepository.getById(categoriaProducto.getCodigo());
        categoriaProductoRepository.delete(existingEntity);
        return existingEntity;
    }

    @Override
    public CategoriaProductoEntity enable(CategoriaProductoEntity categoriaProducto) {
        CategoriaProductoEntity existingEntity = categoriaProductoRepository.getReferenceById(categoriaProducto.getCodigo());
        existingEntity.setEstado(true); // Suponiendo que 'activo' es el campo que controla el estado
        return categoriaProductoRepository.save(existingEntity);
    }

}
