
package pe.com.clinicasakura.ClinicaSakura.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import pe.com.clinicasakura.ClinicaSakura.model.CategoriaProductoEntity;
import pe.com.clinicasakura.ClinicaSakura.repository.base.BaseRepository;

public interface CategoriaProductoRepository extends BaseRepository<CategoriaProductoEntity, Long> {

    @Query("select c from CategoriaProductoEntity c where c.estado=true")
    Page<CategoriaProductoEntity> findAllCustom(Pageable pageable);

}